package com.w2p.controller;

import com.w2p.model.dto.OrganizationDto;
import com.w2p.model.entity.Organization;
import com.w2p.model.entity.UserOrganizations;
import com.w2p.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@CrossOrigin
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping(value = "/addOrganization")
    public Organization addOrganization(@RequestBody OrganizationDto organizationDto){
        return organizationService.addOrganization(organizationDto);
    }

    @GetMapping(value = "/findOrganizationByUsername")
    public List<Organization> findOrganizationByUsername(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return organizationService.getOrganizationByUsername(currentPrincipalName);
    }

    @GetMapping(value = "/getOrganizationByIdAndOrgUserName/{id}")
    public Organization getOrganizationByIdAndOrgUserName(@PathVariable("id") Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);

        return organizationService.getOrganizationByIdAndOrgUserName(id, currentPrincipalName);
    }

    @DeleteMapping(value = "/deleteOrganizationById/{id}")
    public void deleteOrganizationById (@PathVariable("id") Integer id) {
        organizationService.deleteOrganizationById(id);
    }

    @GetMapping(value = "/findUserOrganizationsByOrganizationId/{organizationId}")
    public  List<UserOrganizations> findUserOrganizationsByOrganizationId(@PathVariable("organizationId") Integer organizationId) {
        return organizationService.findUsersInOrganization(organizationId);
    }
}
