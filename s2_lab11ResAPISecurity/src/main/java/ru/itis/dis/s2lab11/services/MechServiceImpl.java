package ru.itis.dis.s2lab11.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dis.s2lab11.model.Merch;
import ru.itis.dis.s2lab11.repositories.MerchRepository;

import java.util.List;

@Service
public class MechServiceImpl implements MerchService {

    @Autowired
    private MerchRepository repository;

    @Override
    public List<Merch> findByName(String name) {
        return repository.findByName(name.toUpperCase());
    }

    @Override
    public List<Merch> findByCode(String code) {
        return repository.findByCode(code);
    }
}
