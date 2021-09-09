package com.main;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")


public class Employee implements Serializable {
	private static final long serialVersionUID = 1 ;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eid;

    @Column(name = "username")
    private String username;

    public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;

}
