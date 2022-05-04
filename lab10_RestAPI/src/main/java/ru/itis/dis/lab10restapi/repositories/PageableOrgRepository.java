package ru.itis.dis.lab10restapi.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.itis.dis.lab10restapi.model.Organization;

public interface PageableOrgRepository extends PagingAndSortingRepository<Organization,Long> {
}
