package com.profile.master.api.controller;

import com.profile.master.api.dto.EducacionDTO;
import com.profile.master.api.dto.PersonaDTO;
import com.profile.master.api.exception.ModeloNotFoundException;
import com.profile.master.api.model.Educacion;
import com.profile.master.api.model.Persona;
import com.profile.master.api.service.IPersonaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<PersonaDTO>> listar() throws Exception {
        List<PersonaDTO> lista = service.listar().stream().map(p -> mapper.map(p, PersonaDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Persona obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);

        }
        PersonaDTO dto = mapper.map(obj, PersonaDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody PersonaDTO dto) throws Exception {
        Persona p = mapper.map(dto, Persona.class);
        Persona obj = service.registrar(p);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<PersonaDTO> modificar(@Valid @RequestBody PersonaDTO dto) throws Exception {
        Persona obj = service.listarPorId(dto.getIdPersona());

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdPersona());
        }

        Persona p = mapper.map(dto, Persona.class);
        Persona pac = service.modificar(p);
        PersonaDTO dtoResponse = mapper.map(pac, PersonaDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Persona obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/hateoas/{id}")
    public EntityModel<PersonaDTO> listarHateoas(@PathVariable("id") Integer id) throws Exception{
        Persona obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        PersonaDTO dto = mapper.map(obj, PersonaDTO.class);

        EntityModel<PersonaDTO> recurso = EntityModel.of(dto);
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorId(id));
        recurso.add(link1.withRel("medico-info"));
        return recurso;

    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<PersonaDTO>> listarPageable(Pageable page) throws Exception{
        Page<PersonaDTO> pacientes = service.listarPageable(page).map(p -> mapper.map(p, PersonaDTO.class));

        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
    @GetMapping("/maestria-doctorado")
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<PersonaDTO>> listarMaestriaDoctorado() throws Exception {
        List<PersonaDTO> lista = service.listar().stream().map(p -> mapper.map(p, PersonaDTO.class)).collect(Collectors.toList());
        List<PersonaDTO> listaAux  = new ArrayList<PersonaDTO>();

        for (PersonaDTO varPersona : lista)
        {
            for (EducacionDTO educacion : varPersona.educacionList) {
                    if(educacion.tipoEducacion.getIdTipoEducacion() == 2 ||educacion.tipoEducacion.getIdTipoEducacion() == 3){
                    listaAux.add(varPersona);
                    }
            };
        }


        return new ResponseEntity<>(listaAux, HttpStatus.OK);
    }

    @GetMapping("/pregrado")
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<PersonaDTO>> listarpregrado() throws Exception {
        List<PersonaDTO> lista = service.listar().stream().map(p -> mapper.map(p, PersonaDTO.class)).collect(Collectors.toList());
        List<PersonaDTO> listaAux  = new ArrayList<PersonaDTO>();

        for (PersonaDTO varPersona : lista)
        {
            for (EducacionDTO educacion : varPersona.educacionList) {
                if(educacion.tipoEducacion.getIdTipoEducacion() == 1){
                    listaAux.add(varPersona);
                }
            };
        }


        return new ResponseEntity<>(listaAux, HttpStatus.OK);
    }

    @GetMapping("/cambiar-residencia")
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<PersonaDTO>> listarCambiarResidencia() throws Exception {
        List<PersonaDTO> lista = service.listar().stream().map(p -> mapper.map(p, PersonaDTO.class)).collect(Collectors.toList());
        List<PersonaDTO> listaAux  = new ArrayList<PersonaDTO>();

        for (PersonaDTO varPersona : lista)
        {
            if(varPersona.openToWork == true)
            {
                listaAux.add(varPersona);
             }

        }


        return new ResponseEntity<>(listaAux, HttpStatus.OK);
    }

    @GetMapping("/filtrar-skill/{skill}")
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<PersonaDTO>> listarFiltroSkill(@PathVariable("skill") String skill) throws Exception {
        List<PersonaDTO> lista = service.listar().stream().map(p -> mapper.map(p, PersonaDTO.class)).collect(Collectors.toList());
        List<PersonaDTO> listaAux  = new ArrayList<PersonaDTO>();

        for (PersonaDTO varPersona : lista)
        {
            if(varPersona.openToWork == true)
            {
                listaAux.add(varPersona);
            }
        }
        return new ResponseEntity<>(listaAux, HttpStatus.OK);
    }

}

