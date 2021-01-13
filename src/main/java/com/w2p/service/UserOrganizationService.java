package com.w2p.service;

import com.w2p.model.dto.UserOrganizationsDto;
import com.w2p.model.entity.UserOrganizations;
import com.w2p.repository.UserOrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrganizationService {

    @Autowired
    private UserOrganizationRepo userOrganizationRepo;

    @Autowired
    private InvitationService invitationService;

    public UserOrganizations addMembersToOrganization (UserOrganizationsDto userOrganizationsDto) {
        UserOrganizations userOrganization = new UserOrganizations();

        userOrganization.setOrganizationId(userOrganizationsDto.getOrganizationId());
        userOrganization.setUsername(userOrganizationsDto.getUsername());

        System.out.println(userOrganization.getOrganizationId());


        return userOrganizationRepo.save(userOrganization);
    }
}
