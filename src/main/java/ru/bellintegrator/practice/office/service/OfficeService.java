package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

/**
 * Сервис
 */
public interface OfficeService {


    /**
     * получить офис
     * @param id
     * @return
     */
    List<OfficeView> office(int id);
}