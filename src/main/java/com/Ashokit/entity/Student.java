package com.Ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sid;
	private Integer cid;
	private String sname;
	private String contactno;
	private String course;
	private String classmode;
	private String enqstatus;
	
	public Student() {
		super();
	}
	public Student(int sid, int cid, String sname, String contactno, String course, String classmode,
			String enqstatus) {
		super();
		this.sid = sid;
		this.cid = cid;
		this.sname = sname;
		this.contactno = contactno;
		this.course = course;
		this.classmode = classmode;
		this.enqstatus = enqstatus;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getClassmode() {
		return classmode;
	}
	public void setClassmode(String classmode) {
		this.classmode = classmode;
	}
	public String getEnqstatus() {
		return enqstatus;
	}
	public void setEnqstatus(String enqstatus) {
		this.enqstatus = enqstatus;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", cid=" + cid + ", sname=" + sname + ", contactno=" + contactno + ", course="
				+ course + ", classmode=" + classmode + ", enqstatus=" + enqstatus + "]";
	}
	
	
	
	
}

