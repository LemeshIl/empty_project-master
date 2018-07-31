package ru.bellintegrator.practice.user.service;

import org.h2.engine.User;
import ru.bellintegrator.practice.organization.view.OrganizationShortView;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

/**
 * Сервис
 */
public interface UserService {

    /**
     * 9. api/user/list
     * получить список  пользователей по officeId
     *
     * @return {@User}
     */
    List<UserView> users(UserView view);

    /**
     * 10. api/user/{id}
     * получить пользователя по id
     *
     * @param id
     * @return
     */
    UserView user(long id);

    /**
     * 11. api/user/update
     * обновить пользователя
     *
     * @param view
     */
    void update(UserView view);

    /**
     * 12. api/user/save
     * сохранить пользователя
     *
     * @param view
     */
    void add(UserView view);
}