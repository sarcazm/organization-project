package ru.bellintegrator.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.dao.organization.OrganizationDao;
import ru.bellintegrator.dto.OrganizationDto;
import ru.bellintegrator.model.organization.Organization;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationDao dao;
    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void add(@Valid OrganizationDto organizationDto) {
        dao.save(organizationDto.fromDto());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationDto> organizations() {
        List<Organization> all = dao.all();
        List<OrganizationDto> result = new ArrayList<>();
        for (Organization org :
                all) {
            result.add(OrganizationDto.toDto(org));
        }
        return result;
    }
}
