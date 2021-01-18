package com.w2p.controller;

import com.w2p.model.entity.User;
import com.w2p.model.entity.UserOrganizations;
import com.w2p.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@GetMapping({ "/getUserByUsername/{username}" })
	public User getUserByUsername(@PathVariable("username") String username) {

		return jwtUserDetailsService.getUserByUsername(username);
}

	@GetMapping(value = "/findOrganizationsOfUser/{username}")
	public List<UserOrganizations> findOrganizationsOfUser(@PathVariable("username") String username) {
		return jwtUserDetailsService.findOrganizationsOfUser(username);
	}

}