package ru.itis.dis.lab10restapi.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.dis.lab10restapi.model.Bank;

public interface BankRepository extends CrudRepository<Bank,Long> {

}
