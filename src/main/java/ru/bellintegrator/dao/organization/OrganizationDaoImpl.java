package ru.bellintegrator.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.model.organization.Organization;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Organization> allByParam(Map<String, String> params, Boolean isActive) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> organizationCriteria = cb.createQuery(Organization.class);
        Root<Organization> organizationRoot = organizationCriteria.from(Organization.class);
        organizationCriteria.select(organizationRoot).where(cb.equal(organizationRoot.get("isActive"), isActive));
        params.forEach((key, value) -> organizationCriteria.select(organizationRoot).where(organizationRoot.get(String.valueOf(key)).in(String.valueOf(value))));
        //isactive как сделать?

        return em.createQuery(organizationCriteria).getResultList();
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
