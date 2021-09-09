package com.main;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager")


public class Manager implements Serializable {
	private static final long serialVersionUID = 1 ;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mid;

    @Column(name = "username")
    private String username;

    public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
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

	
		@Column(name = "password")
    private String password;
    
    
}
