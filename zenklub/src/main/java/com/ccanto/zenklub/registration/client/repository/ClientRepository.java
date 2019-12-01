package com.ccanto.zenklub.registration.client.repository;

import com.ccanto.zenklub.registration.client.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findByMail(String mail);
}
