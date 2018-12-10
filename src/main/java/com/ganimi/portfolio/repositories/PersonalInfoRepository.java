package com.ganimi.portfolio.repositories;

import com.ganimi.portfolio.domain.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> {

}
