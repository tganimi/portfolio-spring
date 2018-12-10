package com.ganimi.portfolio.services;

import com.ganimi.portfolio.domain.PersonalInfo;
import com.ganimi.portfolio.domain.Project;
import com.ganimi.portfolio.dto.ProjectNewDTO;
import com.ganimi.portfolio.repositories.PersonalInfoRepository;
import com.ganimi.portfolio.repositories.ProjectRepository;
import com.ganimi.portfolio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repo;

    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    public Project getProject(Integer id) {
        Optional<Project> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Object not found - ID: " + id + " - Model: " + Project.class.getName()
        ));
    }

    public Project insert(Project obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    /*public Project fromDTO(ProjectNewDTO objDto) {
        Optional<PersonalInfo> info = personalInfoRepository.findById(objDto.getPersonalInfoId());
        Project project = new Project(null, objDto.getTitle(), objDto.getDescription(), info);

        return project;
    }*/

}
