package hu.webuni.transport.lilla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.transport.lilla.repository.TransportPlanRepository;

@Service
public class DelayService {

	@Autowired
	TransportPlanRepository transportPlanRepository;

	public void registerDelay(int transportPlanId, int milestoneId, int delay) {
		System.out.println("register delay");
	}

}
