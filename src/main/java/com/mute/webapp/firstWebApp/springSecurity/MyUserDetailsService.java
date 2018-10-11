package com.mute.webapp.firstWebApp.springSecurity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//get the user by name
		UserBO user = new UserBO();
		//TODO to load real userBo from anywhere
		user.loadTestUser();
		List<GrantedAuthority> authList = buildUserAuthority(user.getUserRoles());
		User result = buildUserForAuthentication(user, authList);
		
		return result;
	}
	
	
	 // Converts user to spring.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(UserBO user,
        List<GrantedAuthority> authorities) {
        return new User(user.getUserName(), user.getPassword(),
            user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // add user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }


}
