package com.ganimi.portfolio;

import com.ganimi.portfolio.domain.PersonalInfo;
import com.ganimi.portfolio.domain.Project;
import com.ganimi.portfolio.domain.Technology;
import com.ganimi.portfolio.repositories.PersonalInfoRepository;
import com.ganimi.portfolio.repositories.ProjectRepository;
import com.ganimi.portfolio.repositories.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner {

	@Autowired
	private PersonalInfoRepository personalInfoRepository;

	@Autowired
	private TechnologyRepository technologyRepository;

	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {

		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PersonalInfo info = new PersonalInfo(
				null,
				"Thiago",
				"Ganimi",
				"1987-04-24",
				"tganimi@gmail.com",
				"http://linkedin.com",
				"http://facebook.com",
				"http://twitter.com",
				"http://github.com/tganimi",
				"Lorem Ipsum"
		);

		Technology tech1 = new Technology(null, "PHP");
		Technology tech2 = new Technology(null, "Javascript");
		Technology tech3 = new Technology(null, "Java");

		info.getTechnologies().addAll(Arrays.asList(tech1, tech2, tech3));

		tech1.getPersonalInfos().addAll(Collections.singletonList(info));
		tech2.getPersonalInfos().addAll(Collections.singletonList(info));
		tech3.getPersonalInfos().addAll(Collections.singletonList(info));

		// project
		Project project1 = new Project(null, "FPB", "Lorem Ipsum", info);
		Project project2 = new Project(null, "Voxtell", "Lorem Ipsum Dolor sit Amet", info);

		personalInfoRepository.saveAll(Collections.singletonList(info));
		technologyRepository.saveAll(Arrays.asList(tech1, tech2, tech3));
		projectRepository.saveAll(Arrays.asList(project1, project2));

	}
}
