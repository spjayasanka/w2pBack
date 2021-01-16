package com.w2p.repository;

import com.w2p.model.entity.User;
import com.w2p.model.entity.UserOrganizations;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrganizationRepo extends JpaRepository<UserOrganizations, Integer> {
    User findUserByOrganizationId(Integer organizationId);
    List<UserOrganizations> findUserOrganizationsByOrganizationId(Integer organizationId);
}
