package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

/**
 * Сервис
 */
public interface UserService {


    /**
     * получить пользователя
     * @param id
     * @return
     */
    List<UserView> user(int id);
}