package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDaoImpl;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OfficeDaoImpl dao;

    @Autowired
    public OfficeServiceImpl(OfficeDaoImpl dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeView office(long id) {
        Office starOf = dao.loadById(id);
        OfficeView view = mapOffice().apply(starOf);

        return view;
    }

    private Office getOffice(long id) {
        Office starOf = new Office();
        starOf.setId(id);
        starOf.setName("Авангард");
        starOf.setAddress("г. Москва ул.Новая,55");
        starOf.setPhone("2505478");
        starOf.setOrgId(id);
        starOf.setActive(true);

        return starOf;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OfficeView> offices(OfficeView view) {
        List<Office> offices = dao.offices(Long.valueOf(view .orgId));

        return offices.stream()
                .map(mapOffice())
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(OfficeView view) {
        Office office = new Office(view.name, view.address, view.phone, Long.valueOf(view.orgId), view.isActive);

        dao.save(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(OfficeView view) {
        Office office = new Office(view.name, view.address, view.phone,
                Long.valueOf(view.orgId), view.isActive);
        //Office office = getOffice(Long.valueOf(view.id));
        office.setId(Long.valueOf(view.id));
//        office.setName(view.name);
//        office.setAddress(view.address);
//        office.setPhone(view.phone);
//        office.setOrgId(Long.valueOf(view.orgId));

        dao.update(office);
    }

    private Function<Office, OfficeView> mapOffice() {
        return office -> {
            OfficeView view = new OfficeView();

            view.id = String.valueOf(office.getId());
            view.name = office.getName();
            view.address = office.getAddress();
            view.phone = String.valueOf(office.getPhone());
            view.orgId = String.valueOf(office.getOrgId());
            view.isActive = office.isActive();

            log.debug(view.toString());

            return view;
        };
    }


}
