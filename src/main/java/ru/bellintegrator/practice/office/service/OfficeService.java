package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.organization.view.OrganizationShortView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

/**
 * Сервис
 */
public interface OfficeService {

    /**
     * 5.api/office/list
     * получить список офисов по orgId
     *
     * @return {@Office}
     */
    List<OfficeView> offices(OfficeView view);

    /**
     * 6. api/office/{id}
     * получить офис по id
     *
     * @param id
     * @return
     */
    OfficeView office(long id);

    /**
     * 7. api/office/update
     * обновить офис
     *
     * @param view
     */
    void update(OfficeView view);

    /**
     * 8. api/office/save
     * сохранить офис
     *
     * @param view
     */
    void add(OfficeView view);
}