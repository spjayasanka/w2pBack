package com.w2p.repository;

import com.w2p.model.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Integer> {

    List<Organization> findByOrgUserName(String orgUserName);
    Organization getOrganizationByIdAndOrgUserName(Integer id, String orgUsername);
}
