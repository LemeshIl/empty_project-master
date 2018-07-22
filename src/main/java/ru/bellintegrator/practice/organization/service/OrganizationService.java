package ru.bellintegrator.practice.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationShortView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OrganizationDao dao;

    @Autowired
    public OrganizationService(OrganizationDao dao) {
        this.dao = dao;
    }

    /**
     * 2. api/organization/{id}
     * получить организацию по id
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public OrganizationView organization(long id) {
        Organization starOrg = dao.loadById(id);
        OrganizationView view = mapOrganization().apply(starOrg);
        return view;
    }

    private Organization getOrganization(Long id) {
        Organization starOrg = new Organization();
        starOrg.setId(id);
        starOrg.setName("starOrg");
        starOrg.setInn("454555");
        starOrg.setFullName("Саратовские авиалинии");
        starOrg.setKpp("5600114");
        starOrg.setAddress("г.Саратов, ул.Ленина,57");
        starOrg.setPhone("884526558");
        starOrg.setActive(true);
        return starOrg;
    }

    /**
     * 1. api/organization/list
     * возвращает организации по name
     *
     * @param view-данные которые передает пользователь и по которым фильтруем организации
     * @return organizations-возвращаю организации
     */
    @Transactional
    public List<OrganizationShortView> organizations(OrganizationShortView view) {
        List<Organization> organizations = dao.organizations(view.name);

        return organizations.stream()
                .map(mapShortOrganization())
                .collect(Collectors.toList());
    }

    /**
     * 4. api/organization/save
     * сохраняет организацию
     *
     * @param view
     */
    @Transactional
    public void add(OrganizationView view) {
        Organization organization = new Organization(view.name, view.fullName, view.inn, view.kpp,
                view.address, view.phone, view.isActive);
        dao.save(organization);
    }

    /**
     * 3. api/organization/update
     * Обновить организацию
     *
     * @param view
     */
    @Transactional
    public void update(OrganizationView view) {
        Organization organization = new Organization(view.name, view.fullName, view.inn, view.kpp,
                view.address, view.phone, view.isActive);
        organization.setId(Long.valueOf(view.id));
        dao.update(organization);
    }

    private Function<Organization, OrganizationView> mapOrganization() {
        return o -> {
            OrganizationView view = new OrganizationView();

            view.id = String.valueOf(o.getId());
            view.name = o.getName();
            view.inn = String.valueOf(o.getInn());
            view.fullName = o.getFullName();
            view.kpp = String.valueOf(o.getKpp());
            view.address = o.getAddress();
            view.phone = String.valueOf(o.getPhone());
            view.isActive = o.isActive();

            log.debug(view.toString());

            return view;
        };
    }

    private Function<Organization, OrganizationShortView> mapShortOrganization() {
        return o -> {

            OrganizationShortView view = new OrganizationShortView();
            view.id = String.valueOf(o.getId());
            view.name = o.getName();
            view.inn = String.valueOf(o.getInn());
            view.isActive = o.isActive();

            log.debug(view.toString());

            return view;
        };
    }
}
