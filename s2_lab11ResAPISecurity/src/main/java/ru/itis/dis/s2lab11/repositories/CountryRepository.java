package ru.itis.dis.s2lab11.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.dis.s2lab11.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByCode(String code);

}
