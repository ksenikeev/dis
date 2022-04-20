package ru.itis.dis.s2lab10.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.dis.s2lab10.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

}
