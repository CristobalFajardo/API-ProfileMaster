package com.profile.master.api.controller;

import com.profile.master.api.dto.UsuarioDTO;
import com.profile.master.api.exception.ModeloNotFoundException;
import com.profile.master.api.model.Usuario;
import com.profile.master.api.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private IUsuarioService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<UsuarioDTO>> listar() throws Exception {
        List<UsuarioDTO> lista = service.listar().stream().map(p -> mapper.map(p, UsuarioDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Usuario obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);

        }
        UsuarioDTO dto = mapper.map(obj, UsuarioDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody UsuarioDTO dto) throws Exception {
        Usuario p = mapper.map(dto, Usuario.class);
        Usuario obj = service.registrar(p);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> modificar(@Valid @RequestBody UsuarioDTO dto) throws Exception {
        Usuario obj = service.listarPorId(dto.getIdUsuario());

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdUsuario());
        }

        Usuario p = mapper.map(dto, Usuario.class);
        Usuario pac = service.modificar(p);
        UsuarioDTO dtoResponse = mapper.map(pac, UsuarioDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Usuario obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/hateoas/{id}")
    public EntityModel<UsuarioDTO> listarHateoas(@PathVariable("id") Integer id) throws Exception{
        Usuario obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        UsuarioDTO dto = mapper.map(obj, UsuarioDTO.class);

        EntityModel<UsuarioDTO> recurso = EntityModel.of(dto);
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorId(id));
        recurso.add(link1.withRel("usuario-info"));
        return recurso;

    }

}

