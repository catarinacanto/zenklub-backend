package com.ccanto.zenklub.registration.client.controller;

import com.ccanto.zenklub.registration.client.entity.Client;
import com.ccanto.zenklub.registration.client.repository.ClientRepository;
import com.ccanto.zenklub.registration.exception.ClientNotFoundException;
import com.ccanto.zenklub.registration.exception.ProfessionalNotFoundException;
import com.sun.codemodel.internal.JTryBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client-registration")
public class ClientRegistrationController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public Iterable findAll() {
        return clientRepository.findAll();
    }

    @PutMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClient(@RequestBody Client client){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        client.setPassword(passwordEncoder.encode(client.getPassword()));

        clientRepository.save(client);
    }

    @PutMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteClient(@RequestParam(name = "mail") String mail){
        Client client = clientRepository.findByMail(mail).orElseThrow(ClientNotFoundException::new);

        clientRepository.delete(client);
    }

}
