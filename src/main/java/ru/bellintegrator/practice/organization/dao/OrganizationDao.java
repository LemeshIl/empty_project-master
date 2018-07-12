package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.person.model.Person;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Получить все объекты Person
     *
     * @return
     */
    List<Person> all();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Person loadById(Long id);

    /**
     * Получить Person по имени
     *
     * @param name
     * @return
     */
    Person loadByName(String name);

    /**
     * Сохранить Person
     *
     * @param person
     */
    void save(Person person);
}
