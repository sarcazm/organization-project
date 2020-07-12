package ru.bellintegrator.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.model.organization.Organization;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao{
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("select o from Organization o", Organization.class);
        return query.getResultList();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }
}
