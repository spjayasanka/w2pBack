package com.w2p.controller;

import com.w2p.model.dto.InvitationDto;
import com.w2p.model.entity.Invitation;
import com.w2p.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class InvitationController {
    @Autowired
    InvitationService invitationService;

    @PostMapping(value = "/saveInvitation")
    public Invitation saveInvitation(@RequestBody InvitationDto invitationDto) {
        System.out.println("test controller");
        return invitationService.addInvitation(invitationDto);
    }

    @GetMapping(value = "/getInvitationByMemberEmail/{username}")
    public List<Invitation> getInvitationByMemberEmail(@PathVariable("username") String memberEmail){
        return invitationService.findInvitationByMemberEmail(memberEmail);
    }

    @GetMapping(value = "/getInvitationByOrganizationId/{organizationId}")
    public List<Invitation> getInvitationByOrganizationId(@PathVariable("organizationId") Integer organizationId){
        System.out.println(organizationId);
        return invitationService.findInvitationByOrganizationId(organizationId);
    }

    @PutMapping(value = "/updateStatus")
    public Invitation updateStatus(@RequestBody InvitationDto invitationDto){
        System.out.println("update tested");
        return invitationService.changeStatus(invitationDto);
    }

}
