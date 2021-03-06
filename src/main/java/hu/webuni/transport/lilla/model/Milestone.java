package hu.webuni.transport.lilla.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Milestone {
	@Id
	@GeneratedValue
	private long id;

	@OneToOne
	private Address address;

	private LocalDateTime plannedTime;

	@OneToOne(mappedBy = "toMilestone")
	private Section sectionLeft;

	@OneToOne(mappedBy = "fromMilestone")
	private Section sectionRight;

	public Milestone(Address address, LocalDateTime plannedTime) {
		super();
		this.address = address;
		this.plannedTime = plannedTime;
	}

	public Milestone() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDateTime getPlannedTime() {
		return plannedTime;
	}

	public void setPlannedTime(LocalDateTime plannedTime) {
		this.plannedTime = plannedTime;
	}


	public Section getSectionLeft() {
		return sectionLeft;
	}

	public void setSectionLeft(Section sectionLeft) {
		this.sectionLeft = sectionLeft;
	}

	public Section getSectionRight() {
		return sectionRight;
	}

	public void setSectionRight(Section sectionRight) {
		this.sectionRight = sectionRight;
	}

}
