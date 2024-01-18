package com.Ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Counsellor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String name;
	private String email;
	private String password;
	private long phno;
	
	
	public Counsellor() {
		super();
	}
	public Counsellor(int cid, String name, String email, String password, long phno) {
		super();
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phno = phno;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Counsellor [cid=" + cid + ", name=" + name + ", email=" + email + ", password=" + password + ", phno="
				+ phno + "]";
	}

	

}
