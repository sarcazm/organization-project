package ru.bellintegrator.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.model.office.Office;
import ru.bellintegrator.model.organization.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public class OfficeDaoImpl implements OfficeDao{

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> all() {
        TypedQuery<Office> query = em.createQuery("select o from Office o", Office.class);
        return query.getResultList();
    }

    @Override
    public List<Office> allByParam(Map<String, String> params, Boolean isActive) {
        return null;
    }

    @Override
    public Office loadById(Long id) {
        return null;
    }

    @Override
    public void save(Office office) {

    }
}
