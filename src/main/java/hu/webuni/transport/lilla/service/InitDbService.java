package hu.webuni.transport.lilla.service;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.transport.lilla.model.Address;
import hu.webuni.transport.lilla.model.Milestone;
import hu.webuni.transport.lilla.model.Section;
import hu.webuni.transport.lilla.model.TransportPlan;
import hu.webuni.transport.lilla.repository.AddressRepository;
import hu.webuni.transport.lilla.repository.MilestoneRepository;
import hu.webuni.transport.lilla.repository.SectionRepository;
import hu.webuni.transport.lilla.repository.TransportPlanRepository;

@Service
public class InitDbService {
	@Autowired
	AddressRepository addressRepository;

	@Autowired
	MilestoneRepository milestoneRepository;

	@Autowired
	SectionRepository sectionRepository;

	@Autowired
	TransportPlanRepository transportPlanRepository;

	@Transactional
	public void initDb() {
		System.out.println("initDb");
		TransportPlan transportPlan1 = transportPlanRepository.save(new TransportPlan(50));
		Address address1 = addressRepository.save(new Address("HU","2600", "Kecskemet", "Arany", 7, 37d, 47d)) ;
		Address address2 = addressRepository.save(new Address("HU","2750", "Nagykoros", "Kossuth", 11, 37d, 47d));
		Address address3 = addressRepository.save(new Address("HU","1022", "Budapest", "Lorantffy", 13, 37d, 47d));
		Address address4 = addressRepository.save(new Address("HU","2035", "Esztergom", "Géza fejedelem", 24, 37d, 47d));
//		Address address5 = addressRepository.save(new Address("SK","96230", "Ipolysag", "Hviezdoslavova", 11, 37d, 47d));
//		Address address6 = addressRepository.save(new Address("SK","93401", "Leva", "Bernolakova", 11, 37d, 47d));
//		Address address7 = addressRepository.save(new Address("SK","85520", "Pozsony", "Bratislavska", 11, 37d, 47d));
//		Address address8 = addressRepository.save(new Address("CZ","12340", "Praga", "Hlavna", 11, 37d, 47d));
		Milestone milestone1 = milestoneRepository.save(new Milestone(address1, LocalDateTime.of(2021, Month.JUNE, 12, 11, 0)));
		Milestone milestone2 = milestoneRepository.save(new Milestone(address2, LocalDateTime.of(2021, Month.JUNE, 12, 12, 0)));
		Milestone milestone3 = milestoneRepository.save(new Milestone(address3, LocalDateTime.of(2021, Month.JUNE, 12, 13, 0)));
		Milestone milestone4 = milestoneRepository.save(new Milestone(address4, LocalDateTime.of(2021, Month.JUNE, 12, 14, 0)));
  		Section section1 = sectionRepository.save(new Section(milestone1, milestone2, 1, transportPlan1));
		Section section2 = sectionRepository.save(new Section(milestone2, milestone3, 2, transportPlan1));
		Section section3 = sectionRepository.save(new Section(milestone3, milestone4, 3, transportPlan1));
	}
}
