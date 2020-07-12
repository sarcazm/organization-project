package ru.bellintegrator.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.dto.OrganizationDto;


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
    List<OrganizationDto> organizations();
}
