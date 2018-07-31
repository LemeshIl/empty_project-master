package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.user.model.User;

import java.util.List;

/**
 * DAO для работы с User
 */
public interface UserDao {

    /**
     * 9. api/user/list
     * получить список  пользователей по officeId
     *
     * @return {@User}
     */
    List<User> users(Long officeId);

    /**
     * 10. api/user/{id}
     * получить пользователя по id
     *
     * @param id
     * @return
     */
    User loadById(Long id);

    /**
     * 11. api/user/update
     * обновить пользователя
     * {@inheritDoc}
     */
    void update(User user);

    /**
     * 12. api/user/save
     * сохранить пользователя
     * {@inheritDoc}
     */
    void save(User user);
}
