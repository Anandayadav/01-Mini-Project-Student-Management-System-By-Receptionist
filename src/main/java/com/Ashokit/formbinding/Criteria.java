package com.Ashokit.formbinding;

public class Criteria {
	
	private String  course;
	private String coursemode;
	private String enqstatus;
	
	public Criteria() {
		super();
	}
	public Criteria(String course, String coursemode, String enqstatus) {
		super();
		this.course = course;
		this.coursemode = coursemode;
		this.enqstatus = enqstatus;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCoursemode() {
		return coursemode;
	}
	public void setCoursemode(String coursemode) {
		this.coursemode = coursemode;
	}
	public String getEnqstatus() {
		return enqstatus;
	}
	public void setEnqstatus(String enqstatus) {
		this.enqstatus = enqstatus;
	}
	@Override
	public String toString() {
		return "Criteria [course=" + course + ", coursemode=" + coursemode + ", enqstatus=" + enqstatus + "]";
	}
	
	

}
