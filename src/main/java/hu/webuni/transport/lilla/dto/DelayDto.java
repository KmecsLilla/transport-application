package hu.webuni.transport.lilla.dto;

public class DelayDto {
	private int milestoneId;
	private int delay;

	public DelayDto(int milestoneId, int delay) {
		super();
		this.milestoneId = milestoneId;
		this.delay = delay;
	}

	public DelayDto() {
	}

	public int getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(int milestoneId) {
		this.milestoneId = milestoneId;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

}
