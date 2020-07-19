package ru.bellintegrator.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.dto.OrganizationDto;
import ru.bellintegrator.model.organization.Organization;


import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganizationService {

    /**
     * Добавить новую организацию в БД
     *
     * @param organizationDto
     */
    void add(@Valid OrganizationDto organizationDto);
    /**
     * Получить список организаций
     *
     * @return {@Organization}
     */
    List<OrganizationDto> foundOrganizationsByParams(OrganizationDto organizationDto);

    /**
     * Получить организацию по id
     *
     * @return {@Organization}
     */
    OrganizationDto foundById(Long id);

    /**
     * Обновить организацию по параметрам
     *
     * @return {@Organization}
     */
    void updateByParams(OrganizationDto organizationDto);

    void saveByParams(OrganizationDto organizationDto);
}
