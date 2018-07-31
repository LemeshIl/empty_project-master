package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OfficeDao {
    /**
     * 5.api/office/list
     * получить список офисов по orgId
     *
     * @return {@Office}
     */
    List<Office> offices(Long orgId);

    /**
     * 6. api/office/{id}
     * получить офис по id
     *
     * @param id
     * @return
     */
    Office loadById(Long id);

    /**
     * 7. api/office/update
     * обновить офис
     *
     * @param office
     */
     void update(Office office);

    /**
     * 8. api/office/save
     * сохранить офис
     *
     * @param office
     */
     void save(Office office);
}
