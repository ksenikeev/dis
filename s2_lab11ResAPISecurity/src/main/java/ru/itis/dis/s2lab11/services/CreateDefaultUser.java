package ru.itis.dis.s2lab11.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis.s2lab11.model.Counterparty;
import ru.itis.dis.s2lab11.model.Organization;
import ru.itis.dis.s2lab11.model.User;
import ru.itis.dis.s2lab11.repositories.CountryRepository;
import ru.itis.dis.s2lab11.repositories.OrganizationRepository;
import ru.itis.dis.s2lab11.repositories.UserRepository;

import java.util.Collections;

@Service
public class CreateDefaultUser {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Transactional
    public void createUser() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Organization organization = new Counterparty();
        organization.setCountry(countryRepository.findByCode("RU"));
        organization.setName("Первая металлургическая");
        User user = new User();
        user.setUserName("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRoles(Collections.singletonList(userRepository.findRoleById(1l)));
        user.setOrganization(organization);

        organizationRepository.save(organization);
        userRepository.save(user);

    }

}
