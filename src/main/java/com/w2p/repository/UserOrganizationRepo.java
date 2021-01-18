package com.w2p.repository;

import com.w2p.model.entity.User;
import com.w2p.model.entity.UserOrganizations;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrganizationRepo extends JpaRepository<UserOrganizations, Integer> {

//    @Query("select User.username from User inner join UserOrganizations on User.username=UserOrganizations.username")
    List<UserOrganizations> findUserOrganizationsByUsername(String username);

    List<UserOrganizations> findUserOrganizationsByOrganizationId(Integer organizationId);
}
