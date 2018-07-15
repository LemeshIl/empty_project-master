package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.person.dao.PersonDao;

import java.util.function.Function;

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
    public OfficeView office(Long id) {

        Office sarOf = new Office();
        sarOf.setId(id);
        sarOf.setName("SarOf");
        sarOf.setAddress("г.Саратов, ул Новая,17");
        sarOf.setPhone(892565433);
        sarOf.setOrgId(id);
        sarOf.setActive(true);
        OfficeView view = mapOffice().apply(sarOf);

        return view;
    }

    private Function<Office, OfficeView> mapOffice() {
        return o -> {

            OfficeView view = new OfficeView();

            view.id = String.valueOf(o.getId());
            view.name = o.getName();
            view.address = o.getAddress();
            view.phone = String.valueOf(o.getPhone());
            view.orgId = String.valueOf(o.getOrgId());
            view.isActive = o.isActive();

            log.debug(view.toString());

            return view;
        };
    }
}
