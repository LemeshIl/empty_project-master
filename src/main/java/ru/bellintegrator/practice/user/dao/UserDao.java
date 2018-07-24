package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.user.model.User;

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
public class UserDao {

    private final EntityManager em;

    @Autowired
    public UserDao(EntityManager em) {
        this.em = em;
    }

    /**
     * 9. api/user/list
     * получить список user
     * {@inheritDoc}
     */
    public List<User> users(String firstName) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.firstName=:firstName",
                User.class).setParameter("firstName", firstName);
        return query.getResultList();
    }

    /**
     * 10. api/user/{id}
     * Получить user по id
     * {@inheritDoc}
     */
    public User loadById(Long id) {
        return em.find(User.class, id);
    }

    /**
     * 11. api/user/update
     * Обновить user
     * {@inheritDoc}
     */
    public void update(User user) {
        em.merge(user);
    }

    /**
     *
     * 12. api/user/save
     * Сохранть user
     * {@inheritDoc}
     */
    public void save(User user) {
        em.persist(user);
    }

    private CriteriaQuery<User> buildCriteria(String firstName) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> user = criteria.from(User.class);
        criteria.where(builder.equal(user.get("firstName"),firstName));

        return criteria;
    }
}
