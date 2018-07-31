package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationShortView;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.person.view.PersonView;

import java.util.List;

/**
 * Сервис
 */
public interface OrganizationService {

    /**
     * 1. api/organization/list
     * получить список организаций по name
     *
     * @return {@Organization}
     */
    List<OrganizationShortView> organizations(OrganizationShortView view);

    /**
     * 2. api/organization/{id}
     * получить организацию по id
     *
     * @param id
     * @return
     */
    OrganizationView organization(long id);

    /**
     * 3. api/organization/update
     * обновить организацию
     *
     * @param view
     */
    void update(OrganizationView view);

    /**
     * 4. api/organization/save
     * сохранить организацию
     *
     * @param view
     */
    void add(OrganizationView view);
}