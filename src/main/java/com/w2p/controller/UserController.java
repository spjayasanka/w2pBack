package com.w2p.controller;

import com.w2p.model.entity.User;
import com.w2p.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@GetMapping({ "/getUserByUsername/{username}" })
	public User getUserByUsername(@PathVariable("username") String username) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		return jwtUserDetailsService.getUserByUsername(username);
}


}