package ru.bellintegrator.practice.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.person.dao.PersonDao;
import ru.bellintegrator.practice.person.model.Person;
import ru.bellintegrator.practice.person.service.PersonService;
import ru.bellintegrator.practice.person.view.PersonView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final PersonDao dao;

    @Autowired
    public OrganizationServiceImpl(PersonDao dao) {
        this.dao = dao;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OrganizationView organization(Long id) {

        Organization starOrg = new Organization();
        starOrg.setId(id);
        starOrg.setName("starOrg");
        starOrg.setInn(454555);
        starOrg.setFull_name("Саратовские авиалинии");
        starOrg.setKpp(5600114);
        starOrg.setAddress("г.Саратов, ул.Ленина,57");
        starOrg.setPhone(884526558);
        starOrg.setIs_active(true);
        OrganizationView view = mapOrganization().apply(starOrg);

        return view;
    }

    private Function<Organization, OrganizationView> mapOrganization() {
        return o -> {
            OrganizationView view = new OrganizationView();

            view.id = String.valueOf(o.getId());
            view.name = o.getName();
            view.inn = String.valueOf(o.getInn());
            view.full_name = o.getFull_name();
            view.kpp = String.valueOf(o.getKpp());
            view.address = o.getAddress();
            view.phone = String.valueOf(o.getPhone());
            view.is_active = o.isIs_active();

            log.debug(view.toString());

            return view;
        };
    }
}
