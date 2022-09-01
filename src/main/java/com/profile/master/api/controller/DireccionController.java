package com.profile.master.api.controller;

import com.profile.master.api.dto.DireccionDTO;
import com.profile.master.api.exception.ModeloNotFoundException;
import com.profile.master.api.model.Direccion;
import com.profile.master.api.service.IDireccionService;
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
@RequestMapping("/direccion")
public class DireccionController {

    @Autowired
    private IDireccionService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<DireccionDTO>> listar() throws Exception {
        List<DireccionDTO> lista = service.listar().stream().map(p -> mapper.map(p, DireccionDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Direccion obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);

        }
        DireccionDTO dto = mapper.map(obj, DireccionDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody DireccionDTO dto) throws Exception {
        Direccion p = mapper.map(dto, Direccion.class);
        Direccion obj = service.registrar(p);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDireccion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<DireccionDTO> modificar(@Valid @RequestBody DireccionDTO dto) throws Exception {
        Direccion obj = service.listarPorId(dto.getIdDireccion());

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdDireccion());
        }

        Direccion p = mapper.map(dto, Direccion.class);
        Direccion pac = service.modificar(p);
        DireccionDTO dtoResponse = mapper.map(pac, DireccionDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Direccion obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/hateoas/{id}")
    public EntityModel<DireccionDTO> listarHateoas(@PathVariable("id") Integer id) throws Exception{
        Direccion obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        DireccionDTO dto = mapper.map(obj, DireccionDTO.class);

        EntityModel<DireccionDTO> recurso = EntityModel.of(dto);
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorId(id));
        recurso.add(link1.withRel("direccion-info"));
        return recurso;

    }



}

