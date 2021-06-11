package hu.webuni.transport.lilla.model;

import java.util.ArrayList;
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

	@OneToMany(mappedBy = "transportPlan")
	private List<Section> sections = new ArrayList<>();

	public TransportPlan(int standardProfit) {
		super();
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

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}


	public void addSection(Section section) {
		this.sections.add(section);
	}

}
