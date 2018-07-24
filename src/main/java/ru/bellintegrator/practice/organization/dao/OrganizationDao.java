package ru.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDao(EntityManager em) {
        this.em = em;
    }

    /**
     * 1. api/organization/list
     * получить список organizations
     * {@inheritDoc}
     */
    public List<Organization> organizations(String name) {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o WHERE o.name=:name",
                Organization.class).setParameter("name", name);
        return query.getResultList();
    }

    /**
     * 2. api/organization/{id}
     * Получить organization по id
     * {@inheritDoc}
     */
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    /**
     * 3. api/organization/update
     * Обновить organization
     * {@inheritDoc}
     */
    public void update(Organization organization) {
        em.merge(organization);
    }

    /**
     * 4. api/organization/save
     * Сохранть organization
     * {@inheritDoc}
     */
    public void save(Organization organization) {
        em.persist(organization);
    }

    private CriteriaQuery<Organization> buildCriteria(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> organization = criteria.from(Organization.class);
        criteria.where(builder.equal(organization.get("name"), name));

        return criteria;
    }
}
