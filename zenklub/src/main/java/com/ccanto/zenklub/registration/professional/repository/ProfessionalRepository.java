package com.ccanto.zenklub.registration.professional.repository;

import com.ccanto.zenklub.registration.professional.entity.Professional;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfessionalRepository extends CrudRepository<Professional, Long> {

    Optional<Professional> findByMail(String mail);
}
