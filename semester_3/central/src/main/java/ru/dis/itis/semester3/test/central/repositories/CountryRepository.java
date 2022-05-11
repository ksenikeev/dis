package ru.dis.itis.semester3.test.central.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dis.itis.semester3.test.central.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByCode(String code);

}
