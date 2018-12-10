package com.ganimi.portfolio.resources;

import com.ganimi.portfolio.domain.Project;
import com.ganimi.portfolio.dto.ProjectNewDTO;
import com.ganimi.portfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/projects")
public class ProjectResource {

    @Autowired
    private ProjectService service;

    /**
     * get an specific resource
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable Integer id) {
        Project response = service.getProject(id);
        return ResponseEntity.ok().body(response);
    }

    /**
     * create a new resource
     * @return
     */
    /*@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody ProjectNewDTO objDto) {

        Project obj = service.fromDTO(objDto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }*/

}
