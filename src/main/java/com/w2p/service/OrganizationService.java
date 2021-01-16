package com.w2p.service;

import com.w2p.config.JwtTokenUtil;
import com.w2p.controller.JwtAuthenticationController;
import com.w2p.model.dto.OrganizationDto;
import com.w2p.model.dto.UserOrganizationsDto;
import com.w2p.model.entity.Organization;
import com.w2p.model.entity.User;
import com.w2p.model.entity.UserOrganizations;
import com.w2p.repository.OrganizationRepo;
import com.w2p.repository.UserOrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepo organizationRepo;

    @Autowired
    private UserOrganizationRepo userOrganizationRepo;

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

    public void deleteOrganizationById(Integer id) {
        organizationRepo.deleteById(id);
    }

    public  List<UserOrganizations> findUsersInOrganization(Integer organizationId) {
        System.out.println(organizationId);
        return userOrganizationRepo.findUserOrganizationsByOrganizationId(organizationId);
    }

}
