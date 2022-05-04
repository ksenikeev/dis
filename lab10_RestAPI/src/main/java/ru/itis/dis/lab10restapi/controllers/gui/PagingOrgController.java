package ru.itis.dis.lab10restapi.controllers.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis.lab10restapi.controllers.dto.OrganizationDTO;
import ru.itis.dis.lab10restapi.controllers.dto.PageableDTO;
import ru.itis.dis.lab10restapi.model.Organization;
import ru.itis.dis.lab10restapi.repositories.EntityPageableRepository;
import ru.itis.dis.lab10restapi.repositories.PageableOrgRepository;

import java.util.Collection;

@RestController
public class PagingOrgController {


    @Autowired
    private PageableOrgRepository repository;

    @Autowired
    private EntityPageableRepository entityPageableRepository;

    /*
        номер страницы (page number)
        количество записей на странице (count of page)
     */
    @RequestMapping("/getorgs")
    public Collection<Organization> getOrganizations(@RequestBody PageableDTO pageableDTO) {
        Pageable pageable = PageRequest.of(pageableDTO.getPage(), pageableDTO.getSize(), Sort.by("id"));
        Page page = repository.findAll(pageable);
        return page.getContent();
    }

    @RequestMapping("/getorgs1")
    public Collection<OrganizationDTO> getOrganizations1(@RequestBody PageableDTO pageableDTO) {
        return entityPageableRepository.getOrgs(pageableDTO);
    }

    @RequestMapping("/getorgs2")
    public Collection<Organization> getOrganizations2(@RequestBody PageableDTO pageableDTO) {
        return entityPageableRepository.getOrgs2(pageableDTO);
    }
}
