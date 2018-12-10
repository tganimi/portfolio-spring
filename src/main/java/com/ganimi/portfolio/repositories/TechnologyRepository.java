package com.ganimi.portfolio.repositories;

import com.ganimi.portfolio.domain.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
