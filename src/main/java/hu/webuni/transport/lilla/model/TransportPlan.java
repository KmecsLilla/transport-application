package hu.webuni.transport.lilla.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TransportPlan {
	@Id
	@GeneratedValue
	private long id;
	private int standardProfit;

	@OneToMany(mappedBy = "TransportPlan")
	private List<Section> section;

	public TransportPlan(long id, int standardProfit) {
		super();
		this.id = id;
		this.standardProfit = standardProfit;
	}

	public TransportPlan() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStandardProfit() {
		return standardProfit;
	}

	public void setStandardProfit(int standardProfit) {
		this.standardProfit = standardProfit;
	}

	public List<Section> getSection() {
		return section;
	}

	public void setSection(List<Section> section) {
		this.section = section;
	}



}
