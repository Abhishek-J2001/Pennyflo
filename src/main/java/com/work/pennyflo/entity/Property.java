package com.work.pennyflo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Property {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private int numberOfRooms;
    private double cost;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private com.work.pennyflo.entity.User owner; 
    @Enumerated(EnumType.STRING)
    private PropertyStatus status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public com.work.pennyflo.entity.User getOwner() {
		return owner;
	}
	public void setOwner(com.work.pennyflo.entity.User owner) {
		this.owner = owner;
	}
	public PropertyStatus getStatus() {
		return status;
	}
	public void setStatus(PropertyStatus status) {
		this.status = status;
	}

    
    
}
