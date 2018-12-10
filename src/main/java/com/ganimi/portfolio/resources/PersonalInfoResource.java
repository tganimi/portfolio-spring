package com.ganimi.portfolio.resources;

import com.ganimi.portfolio.domain.PersonalInfo;
import com.ganimi.portfolio.services.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/personal-info")
public class PersonalInfoResource {

    @Autowired
    private PersonalInfoService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable Integer id) {
        PersonalInfo response = service.getPersonalInfo(id);
        return ResponseEntity.ok().body(response);
    }
}
