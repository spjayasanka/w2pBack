package com.w2p.repository;

import com.w2p.model.entity.Confirmation;
import com.w2p.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepo extends CrudRepository<Confirmation, Integer> {
    Confirmation findByConfirmationToken(String confirmationToken);
}
