package ru.itis.dis.lab10restapi.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.dis.lab10restapi.controllers.dto.OrganizationDTO;
import ru.itis.dis.lab10restapi.controllers.dto.PageableDTO;
import ru.itis.dis.lab10restapi.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EntityPageableRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<OrganizationDTO> getOrgs(PageableDTO pageableDTO) {
        Query query = entityManager.createQuery(
                "select new ru.itis.dis.lab10restapi.controllers.dto.OrganizationDTO(o.id, o.name) from Organization o order by id");
        query.setFirstResult(pageableDTO.getPage() * pageableDTO.getSize());
        query.setMaxResults(pageableDTO.getSize());
        List<OrganizationDTO> orgs = query.getResultList();
        return orgs;
    }

    public List<Organization> getOrgs2(PageableDTO pageableDTO) {
        Query query = entityManager.createNativeQuery(
                "select * from organization  order by id limit ?1 offset ?2 ", Organization.class);

        query.setParameter(1, pageableDTO.getSize());
        query.setParameter(2,pageableDTO.getPage() * pageableDTO.getSize());

        List<Organization> orgs = query.getResultList();
        return orgs;
    }

}
