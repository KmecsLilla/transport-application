package hu.webuni.transport.lilla.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Section {
	@Id
	@GeneratedValue
	private long id;

	@OneToOne(mappedBy = "section")
	private Milestone fromMilestone;

	@OneToOne(mappedBy = "section")
	private Milestone toMilestone;
	private int ordinaryNumber;

	@ManyToOne
	private TransportPlan transportPlan;

	public Section(long id, Milestone fromMilestone, Milestone toMilestone, int ordinaryNumber) {
		super();
		this.id = id;
		this.fromMilestone = fromMilestone;
		this.toMilestone = toMilestone;
		this.ordinaryNumber = ordinaryNumber;
	}

	public Section() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Milestone getFromMilestone() {
		return fromMilestone;
	}

	public void setFromMilestone(Milestone fromMilestone) {
		this.fromMilestone = fromMilestone;
	}

	public Milestone getToMilestone() {
		return toMilestone;
	}

	public void setToMilestone(Milestone toMilestone) {
		this.toMilestone = toMilestone;
	}

	public int getOrdinaryNumber() {
		return ordinaryNumber;
	}

	public void setOrdinaryNumber(int ordinaryNumber) {
		this.ordinaryNumber = ordinaryNumber;
	}

	public TransportPlan getTransportPlan() {
		return transportPlan;
	}

	public void setTransportPlan(TransportPlan transportPlan) {
		this.transportPlan = transportPlan;
	}

}
