package com.work.pennyflo.dto;

public class PropertyDTO {
	
	
	    private Long id;
	    private String location;
	    private int numberOfRooms;
	    private double cost;
	    private Long ownerId;
	    private String status;
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
		public Long getOwnerId() {
			return ownerId;
		}
		public void setOwnerId(Long ownerId) {
			this.ownerId = ownerId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

	    
	


}
