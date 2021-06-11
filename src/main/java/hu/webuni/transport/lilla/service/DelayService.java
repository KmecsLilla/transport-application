package hu.webuni.transport.lilla.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import hu.webuni.transport.lilla.model.Milestone;
import hu.webuni.transport.lilla.model.Section;
import hu.webuni.transport.lilla.model.TransportPlan;
import hu.webuni.transport.lilla.repository.MilestoneRepository;
import hu.webuni.transport.lilla.repository.TransportPlanRepository;

@Service
public class DelayService {

	@Autowired
	TransportPlanRepository transportPlanRepository;

	@Autowired
	MilestoneRepository milestoneRepository;

	@Transactional
	public int registerDelay(long id, long milestoneId, int delay) {
		TransportPlan transportPlan = transportPlanRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

		List<Section> sections = transportPlan.getSections();
		boolean milestoneFound = false;
		List<Long> visitedMilestoneIds = new ArrayList<>();
		for (int ordinaryNumber = 1; ordinaryNumber <= sections.size(); ordinaryNumber++) {
			for (Section section : sections) {
				if (section.getOrdinaryNumber() == ordinaryNumber) {
					Milestone fromMilestone = section.getFromMilestone();
					if (fromMilestone.getId() == milestoneId) {
						milestoneFound = true;
					}
					if (milestoneFound && !visitedMilestoneIds.contains(fromMilestone.getId())) {
						LocalDateTime newPlannedTime = fromMilestone.getPlannedTime().plusMinutes(delay);
						fromMilestone.setPlannedTime(newPlannedTime);
					}
					visitedMilestoneIds.add(fromMilestone.getId());

					Milestone toMilestone = section.getToMilestone();
					if (toMilestone.getId() == milestoneId) {
						milestoneFound = true;
					}
					if (milestoneFound && !visitedMilestoneIds.contains(toMilestone.getId())) {
						LocalDateTime newPlannedTime = toMilestone.getPlannedTime().plusMinutes(delay);
						toMilestone.setPlannedTime(newPlannedTime);
					}
					visitedMilestoneIds.add(toMilestone.getId());
				}
			}
		}
		if (!milestoneFound) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

//		sections.sort((Section s1, Section s2) -> s1.getOrdinaryNumber() - s2.getOrdinaryNumber());

//		Milestone milestone = milestoneRepository.findById(milestoneId)
//				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
//		int promptProfit =
//		System.out.println("register delay");

		int delayCost30 = 5;
		int delayCost60 = 10;
		int delayCost120 = 15;

		int newProfit = transportPlan.getStandardProfit();
		if (delay >= 120) {
			newProfit = newProfit * (100 - delayCost120) / 100;
		} else if (delay >= 60) {
			newProfit = newProfit * (100 - delayCost60) / 100;
		} else if (delay >= 30) {
			newProfit = newProfit * (100 - delayCost30) / 100;
		}
		transportPlan.setStandardProfit(newProfit);
		return newProfit;
	}

	public TransportPlan findById(long id) {
		return transportPlanRepository.findById(id).get();
	}

}
