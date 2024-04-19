package com.work.pennyflo.dto;

import com.work.pennyflo.entity.UserRole;

public class UserDTO {
	
	    private String name;
	    private String email;
	    private String mobile;
	    private UserRole role;
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
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public UserRole getRole() {
			return role;
		}
		public void setRole(UserRole role) {
			this.role = role;
		}
	    
	    

	    
	

}
