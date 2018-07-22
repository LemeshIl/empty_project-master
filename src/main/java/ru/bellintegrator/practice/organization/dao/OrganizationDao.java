package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.person.model.Person;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
        /**
     * Получить все объекты Organization по параметрам
     *
     * @return
     */
    List<Organization> organizations(String name);

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Long id);

    /**
     * Обновить Organization
     *
     * @param organization
     * @return
     */
    void update(Organization organization);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);
}
