package com.w2p.service;

import java.util.ArrayList;
import java.util.List;

import com.w2p.model.entity.UserOrganizations;
import com.w2p.repository.UserOrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.w2p.repository.UserRepo;
import com.w2p.model.entity.User;
import com.w2p.model.dto.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
    private UserOrganizationRepo userOrganizationRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public User save(UserDTO user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setFirstname(user.getFirstname());
		newUser.setLastname(user.getLastname());
		return userRepo.save(newUser);
	}

	public User getUserByUsername(String username){
		return userRepo.findByUsername(username);
	}

    public List<UserOrganizations> findOrganizationsOfUser(String username) {
        System.out.println(username);
//        return userOrganizationRepo.findUserOrganizationsByUsername(username);
        return userOrganizationRepo.findUserOrganizationsByUsername(username);
    }


}