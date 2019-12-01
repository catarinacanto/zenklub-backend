package com.ccanto.zenklub.registration.professional.controller;

import com.ccanto.zenklub.registration.exception.ProfessionalNotFoundException;
import com.ccanto.zenklub.registration.professional.entity.Professional;
import com.ccanto.zenklub.registration.professional.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professional-registration")
public class ProfessionalRegistrationController {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @GetMapping
    public Iterable findAll() {
        return professionalRepository.findAll();
    }

    @PutMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProfessional(@RequestBody Professional professional){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        professional.setPassword(passwordEncoder.encode(professional.getPassword()));

        professionalRepository.save(professional);
    }

    @PutMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProfessional(@RequestParam(name = "mail") String mail){
        Professional professional = professionalRepository.findByMail(mail).orElseThrow(ProfessionalNotFoundException::new);

        professionalRepository.delete(professional);
    }

}
