package ru.bellintegrator.dao.organization;


import ru.bellintegrator.model.organization.Organization;

import java.util.List;
import java.util.Map;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {

    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> all();

    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> allByParam(Map<String, String> params, Boolean isActive);

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Long id);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);


}
