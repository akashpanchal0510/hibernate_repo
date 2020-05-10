package com.inn.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@Column(name="sno")
	@Type(type="int")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)//mysql
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//oracle
	private Integer sno;
	
	@Column(name="fname", length=15)
	@Type(type="string")
	private String fname;
	
	@Column(name="lname", length=15)
	@Type(type="string")
	private String lname;
	
	@Column(name="mail", length=30)
	@Type(type="string")
	private String mail;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
