package ru.dis.itis.semester3.test.central.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dis.itis.semester3.test.central.model.Counterparty;
import ru.dis.itis.semester3.test.central.model.Organization;
import ru.dis.itis.semester3.test.central.model.User;
import ru.dis.itis.semester3.test.central.repositories.CountryRepository;
import ru.dis.itis.semester3.test.central.repositories.OrganizationRepository;
import ru.dis.itis.semester3.test.central.repositories.UserRepository;

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
