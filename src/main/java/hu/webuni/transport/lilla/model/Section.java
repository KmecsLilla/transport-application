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

	@OneToOne
	private Milestone fromMilestone;

	@OneToOne
	private Milestone toMilestone;

	private int ordinaryNumber;

	@ManyToOne
	private TransportPlan transportPlan;

	public Section(Milestone fromMilestone, Milestone toMilestone, int ordinaryNumber, TransportPlan transportPlan) {
		super();
		this.fromMilestone = fromMilestone;
		this.toMilestone = toMilestone;
		this.ordinaryNumber = ordinaryNumber;
		this.transportPlan = transportPlan;
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
