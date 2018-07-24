package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OfficeDao dao;

    @Autowired
    public OfficeService(OfficeDao dao) {
        this.dao = dao;
    }

    /**
     * 6. api/office/{id}
     * получить офис по id
     * @param id
     * @return
     */
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
     * 5.api/office/list
     * возвращает офисы
     *
     * @param view-данные которые передает пользователь и по которым фильтруем организации
     * @return offices-возвращаю организации
     */
    @Transactional
    public List<OfficeView> offices(OfficeView view) {
        List<Office> offices = dao.offices(Long.valueOf(view .orgId));

        return offices.stream()
                .map(mapOffice())
                .collect(Collectors.toList());
    }

    /**
     * 8. api/office/save
     * сохранить офис
     *
     * @param view
     */
    @Transactional
    public void add(OfficeView view) {
        Office office = new Office(view.name, view.address, view.phone, Long.valueOf(view.orgId), view.isActive);

        dao.save(office);
    }

    /**
     * 7. api/office/update
     * Обновить офис
     *
     * @param view
     */
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
