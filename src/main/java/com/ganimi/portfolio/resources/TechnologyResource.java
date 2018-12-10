package com.ganimi.portfolio.resources;

import com.ganimi.portfolio.domain.Technology;
import com.ganimi.portfolio.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/technologies")
public class TechnologyResource {

    @Autowired
    private TechnologyService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable Integer id) {
        Technology response = service.getTechnology(id);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Technology obj) {
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
