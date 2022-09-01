package com.profile.master.api.controller;

import com.profile.master.api.dto.ExperienciaLaboralDTO;
import com.profile.master.api.exception.ModeloNotFoundException;
import com.profile.master.api.model.ExperienciaLaboral;
import com.profile.master.api.service.IExperienciaLaboralService;
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
@RequestMapping("/experienciaLaboral")
public class ExperienciaLaboralController {

    @Autowired
    private IExperienciaLaboralService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<ExperienciaLaboralDTO>> listar() throws Exception {
        List<ExperienciaLaboralDTO> lista = service.listar().stream().map(p -> mapper.map(p, ExperienciaLaboralDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaLaboralDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        ExperienciaLaboral obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);

        }
        ExperienciaLaboralDTO dto = mapper.map(obj, ExperienciaLaboralDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody ExperienciaLaboralDTO dto) throws Exception {
        ExperienciaLaboral p = mapper.map(dto, ExperienciaLaboral.class);
        ExperienciaLaboral obj = service.registrar(p);

        //localhost:8080/pacientes/5
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdExperienciaLaboral()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ExperienciaLaboralDTO> modificar(@Valid @RequestBody ExperienciaLaboralDTO dto) throws Exception {
        ExperienciaLaboral obj = service.listarPorId(dto.getIdExperienciaLaboral());

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdExperienciaLaboral());
        }

        ExperienciaLaboral p = mapper.map(dto, ExperienciaLaboral.class);
        ExperienciaLaboral pac = service.modificar(p);
        ExperienciaLaboralDTO dtoResponse = mapper.map(pac, ExperienciaLaboralDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        ExperienciaLaboral obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<ExperienciaLaboralDTO> listarHateoas(@PathVariable("id") Integer id) throws Exception{
        ExperienciaLaboral obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        ExperienciaLaboralDTO dto = mapper.map(obj, ExperienciaLaboralDTO.class);

        EntityModel<ExperienciaLaboralDTO> recurso = EntityModel.of(dto);
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorId(id));
        recurso.add(link1.withRel("experiencia_laboral-info"));
        return recurso;

    }

}

