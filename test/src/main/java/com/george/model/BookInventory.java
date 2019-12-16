package com.george.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uniqueId;
	private int availableNoOfCopies;
	private int totalNoOfCopies;
	
	public BookInventory() {
		super();
	}

	public BookInventory(int uniqueId, int availableNoOfCopies, int totalNoOfCopies) {
		super();
		this.uniqueId = uniqueId;
		this.availableNoOfCopies = availableNoOfCopies;
		this.totalNoOfCopies = totalNoOfCopies;
	}

	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getAvailableNoOfCopies() {
		return availableNoOfCopies;
	}

	public void setAvailableNoOfCopies(int availableNoOfCopies) {
		this.availableNoOfCopies = availableNoOfCopies;
	}

	public int getTotalNoOfCopies() {
		return totalNoOfCopies;
	}

	public void setTotalNoOfCopies(int totalNoOfCopies) {
		this.totalNoOfCopies = totalNoOfCopies;
	}

	@Override
	public String toString() {
		return "BookInventory [uniqueId=" + uniqueId + ", availableNoOfCopies=" + availableNoOfCopies
				+ ", totalNoOfCopies=" + totalNoOfCopies + "]";
	}
}
