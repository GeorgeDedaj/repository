package com.george.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRegistry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userRegistryId;
	private Date issueDate;
	private Date returnDate;
	public UserRegistry() {
		super();
	}
	public UserRegistry(long userRegistryId, Date issueDate, Date returnDate) {
		super();
		this.userRegistryId = userRegistryId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	public long getUserRegistryId() {
		return userRegistryId;
	}
	public void setUserRegistryId(long userRegistryId) {
		this.userRegistryId = userRegistryId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "UserRegistry [userRegistryId=" + userRegistryId + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
	}
}
