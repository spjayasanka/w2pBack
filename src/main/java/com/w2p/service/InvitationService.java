package com.w2p.service;

import com.w2p.model.dto.InvitationDto;
import com.w2p.model.entity.Invitation;
import com.w2p.repository.ConfirmationRepo;
import com.w2p.repository.InvitationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class InvitationService {
    @Autowired
    InvitationRepo invitationRepo;

    @Autowired
    ConfirmationRepo confirmationRepo;

    @Autowired
    EmailService emailService;

//    this method is used for add an invitation

    public Invitation addInvitation(InvitationDto invitationDto, HttpServletRequest request) {
        Invitation invitation = new Invitation();

        invitation.setMemberEmail(invitationDto.getMemberEmail());
        invitation.setOrganizationId(invitationDto.getOrganizationId());
        invitation.setStatus(invitationDto.getStatus());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
//        System.out.println(currentPrincipalName);

        invitation.setUsername(currentPrincipalName);

        //send email for invitation
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(invitationDto.getMemberEmail());
        mailMessage.setFrom("spjartz@gmail.com");
        mailMessage.setSubject("Invitation for add to my organization");

        String msg = "Hello, " + currentPrincipalName + " is inviting you to join his/her organization "
                + " Please register using this email to join to organization " + " http://localhost:8080/front";
        mailMessage.setText(msg);
//        mailMessage.setText("hello, I am inviting you to join my organization. Click the link to login or Register " + "http://localhost:4200/login");

//        System.out.println("tested URL : " + request.getRequestURL().toString());


        emailService.sendEmail(mailMessage);

        return invitationRepo.save(invitation);
    }


    //this method is used for update invitation status

    public Invitation changeStatus(InvitationDto invitationDto){
        Invitation invitation = invitationRepo.findInvitationById(invitationDto.getId());

        invitation.setStatus(invitationDto.getStatus());
        return invitationRepo.save(invitation);
    }



//    This method is used for get invitations by member email

    public List<Invitation> findInvitationByMemberEmail(String memberEmail){
        return invitationRepo.findByMemberEmail(memberEmail);
    }

    public List<Invitation> findInvitationByUsername(String username){
        return invitationRepo.findByMemberEmail(username);
    }

    public List<Invitation> findInvitationByOrganizationId(Integer organizationId){
        return invitationRepo.findByOrganizationId(organizationId);
    }

    public void deleteInvitationById (Integer id) {
        invitationRepo.deleteById(id);
    }







//    public Invitation saveInvitation(Invitation invitation) {
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("spjartz@gmail.com", "akilasanjeewa");
//            }
//        });
//
//        Invitation existingInvitation = invitationRepo.findByMemberEmail(invitation.getMemberEmail());
//
//        if (existingInvitation != null) {
//            return invitation;
//        }else {
//            invitationRepo.save(invitation);
//
//            System.out.println(invitation);
//
//            Confirmation confirmation = new Confirmation(invitation);
//
////            System.out.println(confirmation);
//
//            confirmationRepo.save(confirmation);
////            System.out.println(invitation.getMemberEmail());
//
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(invitation.getMemberEmail());
//            mailMessage.setSubject("Invitation");
//            mailMessage.setFrom("spjart@gmail.com");
////            mailMessage.setText("To add to the organization, please click here :" + "http://localhost:8080/confirm-account?token=" + confirmation.getConfirmationToken());
//            mailMessage.setText("To add to the organization, please click here :" + "http://localhost:8080/register");
//
//
//            emailService.sendEmail(mailMessage);
////            modelAndView.addObject("username", invitation.getMemberEmail());
//
//
//        }
//        return invitation;
//    }


//end of the class
}
