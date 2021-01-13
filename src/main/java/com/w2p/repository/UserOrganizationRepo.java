package com.w2p.repository;

import com.w2p.model.entity.UserOrganizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrganizationRepo extends JpaRepository<UserOrganizations, Integer> {
}
