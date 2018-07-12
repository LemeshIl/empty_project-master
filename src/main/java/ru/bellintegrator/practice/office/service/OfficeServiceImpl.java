package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.person.dao.PersonDao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final PersonDao dao;

    @Autowired
    public OfficeServiceImpl(PersonDao dao) {
        this.dao = dao;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> office(int id) {

        List<Office> all = new ArrayList<Office>();
        Office saratovOffice = new Office();
        Office moscowOffice=new Office();
        Office novgorodOffice=new Office();


        return all.stream()
                .map(mapOffice())
                .collect(Collectors.toList());
    }

    private Function<Office, OfficeView> mapOffice() {
        return o -> {

            OfficeView view = new OfficeView();

            view.id = String.valueOf(o.getId());
            view.name = o.getName();
            view.address = o.getAddress();
            view.phone = String.valueOf(o.getPhone());
            view.org_id = String.valueOf(o.getOrg_id());
            view.is_active = o.isIs_active();

            log.debug(view.toString());

            return view;
        };
    }
}
