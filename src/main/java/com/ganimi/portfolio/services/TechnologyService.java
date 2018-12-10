package com.ganimi.portfolio.services;

import com.ganimi.portfolio.domain.Project;
import com.ganimi.portfolio.domain.Technology;
import com.ganimi.portfolio.repositories.TechnologyRepository;
import com.ganimi.portfolio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyRepository repo;

    public Technology getTechnology(Integer id) {
        Optional<Technology> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found - ID: " + id + " - Model: " + Technology.class.getName()
        ));
    }

    public Technology insert(Technology obj) {
        return repo.save(obj);
    }

}
