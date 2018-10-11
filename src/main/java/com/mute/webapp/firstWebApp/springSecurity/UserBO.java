package com.mute.webapp.firstWebApp.springSecurity;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserBO {
	
	private String userName;
	private String password;
	private boolean enabled;
	Set<UserRole> userRoles;
	
	
	public void loadTestUser() {
		this.userName="user";
		this.password = "password";
		this.enabled = true;
		Set<UserRole> tmp = new HashSet<UserRole>();
		UserRole newRole = new UserRole();
		newRole.setRole("USER");
		tmp.add(newRole);
		this.setUserRoles(tmp);
		
	}

}
