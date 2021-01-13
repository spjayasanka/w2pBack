package com.w2p.repository;

import com.w2p.model.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvitationRepo extends JpaRepository<Invitation, Integer> {
   List<Invitation> findByMemberEmail(String memberEmail);
   List<Invitation> findByUsername(String username);
   List<Invitation> findByOrganizationId(Integer organizationId);
//   Invitation findByEmail(String memberEmail);
   Invitation findInvitationById(Integer id);
}
