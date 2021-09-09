package com.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transactions")
public class Ticket {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="rid")
 protected int rid;
 
 @Column(name="user")
 protected String user;
 
 @Column(name="type")
 protected String type;
 
 @Column(name="amount")
 protected String amount;
 
 public int getRid() {
	return rid;
}

public void setRid(int rid) {
	this.rid = rid;
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getAmount() {
	return amount;
}

public void setAmount(String amount) {
	this.amount = amount;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getTimestamp() {
	return timestamp;
}

public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Column(name="description")
 protected String description;
 
 @Column(name="timestamp")
 protected String timestamp;
 
 @Column(name="status")
 protected String status;
 
 public Ticket() {
 }
 
 public Ticket(String user, String type, String amount, String description, String timestamp, String status) {
	super();
	this.user = user;
	this.type = type;
	this.amount = amount;
	this.description = description;
	this.timestamp = timestamp;
	this.status = status;
}

public Ticket(int rid, String user, String type, String amount, String description, String timestamp, String status) {
	super();
	this.rid = rid;
	this.user = user;
	this.type = type;
	this.amount = amount;
	this.description = description;
	this.timestamp = timestamp;
	this.status = status;
}

}