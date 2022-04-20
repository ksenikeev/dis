package ru.itis.dis.s2lab10.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.dis.s2lab10.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByCode(String code);

}
