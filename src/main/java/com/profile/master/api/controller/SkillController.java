package com.profile.master.api.controller;

import com.profile.master.api.dto.SkillDTO;
import com.profile.master.api.exception.ModeloNotFoundException;
import com.profile.master.api.model.Skill;
import com.profile.master.api.service.ISkillService;
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
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private ISkillService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    //@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
    public ResponseEntity<List<SkillDTO>> listar() throws Exception {
        List<SkillDTO> lista = service.listar().stream().map(p -> mapper.map(p, SkillDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Skill obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);

        }
        SkillDTO dto = mapper.map(obj, SkillDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody SkillDTO dto) throws Exception {
        Skill p = mapper.map(dto, Skill.class);
        Skill obj = service.registrar(p);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSkill()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<SkillDTO> modificar(@Valid @RequestBody SkillDTO dto) throws Exception {
        Skill obj = service.listarPorId(dto.idSkill);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdSkill());
        }

        Skill p = mapper.map(dto, Skill.class);
        Skill pac = service.modificar(p);
        SkillDTO dtoResponse = mapper.map(pac, SkillDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Skill obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/hateoas/{id}")
    public EntityModel<SkillDTO> listarHateoas(@PathVariable("id") Integer id) throws Exception{
        Skill obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        SkillDTO dto = mapper.map(obj, SkillDTO.class);

        EntityModel<SkillDTO> recurso = EntityModel.of(dto);

        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorId(id));
        recurso.add(link1.withRel("medico-info"));
        return recurso;

    }

}

