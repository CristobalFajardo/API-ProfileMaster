package com.profile.master.api.controller;

import com.profile.master.api.dto.TipoEducacionDTO;
import com.profile.master.api.exception.ModeloNotFoundException;
import com.profile.master.api.model.TipoEducacion;
import com.profile.master.api.service.ITipoEducacionService;
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
@RequestMapping("/tipoEducacion")
public class TipoEducacionController {


    @Autowired
    private ITipoEducacionService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<TipoEducacionDTO>> listar() throws Exception {
        List<TipoEducacionDTO> lista = service.listar().stream().map(p -> mapper.map(p, TipoEducacionDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEducacionDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        TipoEducacion obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);

        }
        TipoEducacionDTO dto = mapper.map(obj, TipoEducacionDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody TipoEducacionDTO dto) throws Exception {
        TipoEducacion p = mapper.map(dto, TipoEducacion.class);
        TipoEducacion obj = service.registrar(p);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoEducacion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<TipoEducacionDTO> modificar(@Valid @RequestBody TipoEducacionDTO dto) throws Exception {
        TipoEducacion obj = service.listarPorId(dto.idTipoEducacion);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdTipoEducacion());
        }

        TipoEducacion p = mapper.map(dto, TipoEducacion.class);
        TipoEducacion pac = service.modificar(p);
        TipoEducacionDTO dtoResponse = mapper.map(pac, TipoEducacionDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        TipoEducacion obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<TipoEducacionDTO> listarHateoas(@PathVariable("id") Integer id) throws Exception{
        TipoEducacion obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        TipoEducacionDTO dto = mapper.map(obj, TipoEducacionDTO.class);

        EntityModel<TipoEducacionDTO> recurso = EntityModel.of(dto);
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorId(id));
        recurso.add(link1.withRel("tipo_educacion-info"));
        return recurso;

    }

}
