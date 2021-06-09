package hu.webuni.transport.lilla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.transport.lilla.repository.MilestoneRepository;
import hu.webuni.transport.lilla.repository.SectionRepository;
import hu.webuni.transport.lilla.repository.TransportPlanRepository;

@Service
public class InitDbService {
	@Autowired
	MilestoneRepository milestoneRepository;

	@Autowired
	SectionRepository sectionRepository;

	@Autowired
	TransportPlanRepository transportPlanRepository;

	@Transactional
	public void initDb() {
		System.out.println("initDb");
	}
}
