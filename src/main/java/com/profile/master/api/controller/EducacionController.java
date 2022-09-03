package com.profile.master.api.controller;

import com.profile.master.api.dto.EducacionDTO;
import com.profile.master.api.exception.ModeloNotFoundException;
import com.profile.master.api.model.Educacion;
import com.profile.master.api.service.IEducacionService;
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
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    private IEducacionService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<EducacionDTO>> listar() throws Exception {
        List<EducacionDTO> lista = service.listar().stream().map(p -> mapper.map(p, EducacionDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducacionDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Educacion obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);

        }
        EducacionDTO dto = mapper.map(obj, EducacionDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody EducacionDTO dto) throws Exception {
        Educacion p = mapper.map(dto, Educacion.class);
        Educacion obj = service.registrar(p);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEducacion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<EducacionDTO> modificar(@Valid @RequestBody EducacionDTO dto) throws Exception {
        Educacion obj = service.listarPorId(dto.getIdEducacion());

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdEducacion());
        }

        Educacion p = mapper.map(dto, Educacion.class);
        Educacion pac = service.modificar(p);
        EducacionDTO dtoResponse = mapper.map(pac, EducacionDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Educacion obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<EducacionDTO> listarHateoas(@PathVariable("id") Integer id) throws Exception{
        Educacion obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        EducacionDTO dto = mapper.map(obj, EducacionDTO.class);

        EntityModel<EducacionDTO> recurso = EntityModel.of(dto);
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorId(id));
        recurso.add(link1.withRel("educacion-info"));
        return recurso;

    }

}

