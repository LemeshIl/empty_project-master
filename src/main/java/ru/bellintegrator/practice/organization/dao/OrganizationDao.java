package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.person.model.Person;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {

    /**
     * 1. api/organization/list
     * Получить список организаций
     *
     * @return {@Organization}
     */
    List<Organization> organizations(String name);

    /**
     * 2. api/organization/{id}
     * Получить организацию по id
     *
     * @param id
     * @return
     */
    Organization loadById(Long id);

    /**
     * 3. api/organization/update
     * Обновить организацию
     * {@inheritDoc}
     */
     void update(Organization organization);

    /**
     * 4. api/organization/save
     * Сохранть организацию
     * {@inheritDoc}
     */
     void save(Organization organization);
}
