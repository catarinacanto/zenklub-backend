package com.ccanto.zenklub.authetication;

import com.ccanto.zenklub.registration.client.entity.Client;
import com.ccanto.zenklub.registration.client.repository.ClientRepository;
import com.ccanto.zenklub.registration.exception.ClientNotFoundException;
import com.ccanto.zenklub.registration.exception.ProfessionalNotFoundException;
import com.ccanto.zenklub.registration.professional.entity.Professional;
import com.ccanto.zenklub.registration.professional.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/authenticate-professional")
    @ResponseStatus(HttpStatus.OK)
    public RedirectView authenticateProfessional(@RequestParam(name = "mail") String mail, @RequestParam(name = "password") String password) {
        Professional professional = professionalRepository.findByMail(mail).orElseThrow(ProfessionalNotFoundException::new);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!encoder.matches(password, professional.getPassword())) {
            throw new ProfessionalNotFoundException();
        }

        return new RedirectView("index");
    }


    @PostMapping("/authenticate-client")
    @ResponseStatus(HttpStatus.OK)
    public RedirectView authenticateClient(@RequestParam(name = "mail") String mail, @RequestParam(name = "password") String password) {
        Client client = clientRepository.findByMail(mail).orElseThrow(ClientNotFoundException::new);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, client.getPassword())) {
            return new RedirectView("/error");
        }

        return new RedirectView("/index");
    }

}
