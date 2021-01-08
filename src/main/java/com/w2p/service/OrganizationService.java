package com.w2p.service;

import com.w2p.config.JwtTokenUtil;
import com.w2p.controller.JwtAuthenticationController;
import com.w2p.model.dto.OrganizationDto;
import com.w2p.model.entity.Organization;
import com.w2p.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepo organizationRepo;

    public Organization addOrganization(OrganizationDto organizationDto){

        Organization newOrganization = new Organization();

        newOrganization.setName(organizationDto.getName());
        newOrganization.setDescription(organizationDto.getDescription());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        System.out.println(currentPrincipalName);

        newOrganization.setOrgUserName(currentPrincipalName);
        return organizationRepo.save(newOrganization);

    }

    public List<Organization> getOrganizationByUsername(String orgUserName){
        return organizationRepo.findByOrgUserName(orgUserName);
    }

    public  Organization getOrganizationByIdAndOrgUserName(Integer id, String orgUserName) {
        return organizationRepo.getOrganizationByIdAndOrgUserName(id, orgUserName);
    }

}
