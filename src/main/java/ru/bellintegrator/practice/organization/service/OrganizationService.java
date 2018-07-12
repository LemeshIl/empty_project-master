package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.person.view.PersonView;

import java.util.List;

/**
 * Сервис
 */
public interface OrganizationService {


    /**
     * 2. api/organization/{id}
     * получить организацию
     * @param id
     * @return
     */
    OrganizationView organization(Long id);
}