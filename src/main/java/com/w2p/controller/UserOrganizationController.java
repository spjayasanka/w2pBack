package com.w2p.controller;

import com.w2p.model.dto.UserOrganizationsDto;
import com.w2p.model.entity.UserOrganizations;
import com.w2p.service.UserOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserOrganizationController {
    @Autowired
    private UserOrganizationService userOrganizationService;

    @PostMapping(value = "/addMembersToOrganization")
    public UserOrganizations addMembersToOrganization(@RequestBody UserOrganizationsDto userOrganizationsDto){
        System.out.println("sothimg " + userOrganizationsDto.getOrganizationId());
        return userOrganizationService.addMembersToOrganization(userOrganizationsDto);
    }
}
