package com.Ashokit.formbinding;

public class Dashboard {
	
	private Integer totequiries;
	private Integer enrolled;
	private Integer lost;
	public Dashboard() {
		super();
	}
	public Dashboard(Integer totequiries, Integer enrolled, Integer lost) {
		super();
		this.totequiries = totequiries;
		this.enrolled = enrolled;
		this.lost = lost;
	}
	public Integer getTotequiries() {
		return totequiries;
	}
	public void setTotequiries(Integer totequiries) {
		this.totequiries = totequiries;
	}
	public Integer getEnrolled() {
		return enrolled;
	}
	public void setEnrolled(Integer enrolled) {
		this.enrolled = enrolled;
	}
	public Integer getLost() {
		return lost;
	}
	public void setLost(Integer lost) {
		this.lost = lost;
	}
	@Override
	public String toString() {
		return "Dashboard [totequiries=" + totequiries + ", enrolled=" + enrolled + ", lost=" + lost + "]";
	}
	
}
