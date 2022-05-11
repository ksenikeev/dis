package ru.dis.itis.semester3.test.central.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dis.itis.semester3.test.central.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

}
