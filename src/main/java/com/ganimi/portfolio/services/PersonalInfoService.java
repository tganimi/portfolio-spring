package com.ganimi.portfolio.services;

import com.ganimi.portfolio.domain.PersonalInfo;
import com.ganimi.portfolio.repositories.PersonalInfoRepository;
import com.ganimi.portfolio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalInfoService {

    @Autowired
    private PersonalInfoRepository repo;

    public PersonalInfo getPersonalInfo(Integer id) {
        Optional<PersonalInfo> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Object not found - ID: " + id + " - Model: " + PersonalInfo.class.getName()
        ));
    }

}
