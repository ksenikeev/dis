package ru.itis.dis.lab10restapi.controllers.dto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis.lab10restapi.model.Bank;
import ru.itis.dis.lab10restapi.repositories.BankPagingRepository;
import ru.itis.dis.lab10restapi.repositories.BankRepository;

import java.util.List;
import java.util.UUID;

@RestController
public class RestApiController {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BankPagingRepository bankPagingRepository;

    @PostMapping("/addbank")
    public Bank addBank(@RequestBody Bank bank) {
        return bank;
    }

    @PostMapping("/getbanks")
    public List<Bank> getBank(@RequestBody Bank bank) {
        Pageable firstPageWithTwoElements = PageRequest.of(3, 100, Sort.by("id"));
        Page<Bank> banks = bankPagingRepository.findAll(firstPageWithTwoElements);

        return banks.getContent();
    }
}
