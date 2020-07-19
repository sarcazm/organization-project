package ru.bellintegrator.service.organization;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.dao.organization.OrganizationDao;
import ru.bellintegrator.dto.OrganizationDto;
import ru.bellintegrator.helper.organization.OrganizationHelper;
import ru.bellintegrator.model.organization.Organization;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationDao dao;
    private final OrganizationHelper helper;
    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, OrganizationHelper helper) {
        this.dao = dao;
        this.helper = helper;
    }

    @Override
    @Transactional
    public void add(@Valid @NonNull OrganizationDto organizationDto) {
        dao.save(organizationDto.fromDto());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationDto> foundOrganizationsByParams(@NonNull OrganizationDto organizationDto) throws RuntimeException{
        List<OrganizationDto> result = new ArrayList<>();
        if (organizationDto.name == null){
            throw new RuntimeException("name is null");
        }
        Boolean isActive = true;
        if (organizationDto.isActive != null && organizationDto.isActive == false){
            isActive = false;
        }
        List<Organization> all = dao.allByParam(helper.paramsToMap(organizationDto), isActive);

        for (Organization org :
                all) {
            result.add(OrganizationDto.toDto(org));
        }
        return result;
    }

    @Override
    public OrganizationDto foundById (Long id) throws RuntimeException{
        Organization result = dao.loadById(id);
        if (result == null){
            throw new RuntimeException("Организации по такому id не найдено");
        }
        return OrganizationDto.toDto(result);
    }

    @Override
    @Transactional
    public void updateByParams(OrganizationDto organizationDto) throws RuntimeException{
        helper.requiredParametersForUpdateOrSave(organizationDto);
        Organization result = dao.loadById(organizationDto.id);
            if (result == null){
                throw new RuntimeException("Организации по такому id не найдено");
            }
            result = helper.recordDtoToOrganization(organizationDto, result);
    }

    @Override
    @Transactional
    public void saveByParams(OrganizationDto organizationDto) {
        helper.requiredParametersForUpdateOrSave(organizationDto);
        dao.save(organizationDto.fromDto());
    }

}
