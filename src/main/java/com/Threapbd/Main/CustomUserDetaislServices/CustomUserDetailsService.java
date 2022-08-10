/**
 * 
 */
package com.Threapbd.Main.CustomUserDetaislServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Threapbd.Main.CustomUserDetail.CustomUserDetails;
import com.Threapbd.Main.Entity.User;
import com.Threapbd.Main.Repository.UserRepository;

/**
 * @author User
 *
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user =repo.findByEmail(username);
		if (user==null) {
			throw new UsernameNotFoundException("User  not found ");
		}
		
		return new CustomUserDetails(user);
	}

}
