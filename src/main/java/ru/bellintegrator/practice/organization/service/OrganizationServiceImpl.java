package ru.bellintegrator.practice.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.dao.OrganizationDaoImpl;
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
public class OrganizationServiceImpl implements OrganizationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OrganizationDaoImpl dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDaoImpl dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OrganizationShortView> organizations(OrganizationShortView view) {
        List<Organization> organizations = dao.organizations(view.name);

        return organizations.stream()
                .map(mapShortOrganization())
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(OrganizationView view) {
        Organization organization = new Organization(view.name, view.fullName, view.inn, view.kpp,
                view.address, view.phone, view.isActive);
        dao.save(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(OrganizationView view) {
        Organization organization = new Organization(view.name, view.fullName, view.inn, view.kpp,
                view.address, view.phone, view.isActive);
        organization.setId(Long.valueOf(view.id));
        dao.update(organization);
    }

    private Function<Organization, OrganizationView> mapOrganization() {
        return org -> {
            OrganizationView view = new OrganizationView();

            view.id = String.valueOf(org.getId());
            view.name = org.getName();
            view.inn = String.valueOf(org.getInn());
            view.fullName = org.getFullName();
            view.kpp = String.valueOf(org.getKpp());
            view.address = org.getAddress();
            view.phone = String.valueOf(org.getPhone());
            view.isActive = org.isActive();

            log.debug(view.toString());

            return view;
        };
    }

    private Function<Organization, OrganizationShortView> mapShortOrganization() {
        return org -> {

            OrganizationShortView view = new OrganizationShortView();
            view.id = String.valueOf(org.getId());
            view.name = org.getName();
            view.inn = String.valueOf(org.getInn());
            view.isActive = org.isActive();

            log.debug(view.toString());

            return view;
        };
    }
}
