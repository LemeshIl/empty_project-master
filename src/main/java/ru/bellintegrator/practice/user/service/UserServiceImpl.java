package ru.bellintegrator.practice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.person.dao.PersonDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final PersonDao dao;

    @Autowired
    public UserServiceImpl(PersonDao dao) {
        this.dao = dao;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserView> user(int id) {

        List<User> all = new ArrayList<User>();



        return all.stream()
                .map(mapUser())
                .collect(Collectors.toList());
    }


    private Function<User, UserView> mapUser() {
        return u -> {

            UserView view = new UserView();

            view.id=String.valueOf(u.getId());
            view.first_name=u.getFirst_name();
            view.second_name=u.getSecond_name();
            view.middle_name=u.getMiddle_name();
            view.position=u.getPosition();
            view.phone=String.valueOf(u.getPhone());
            view.doc_name=u.getDoc_name();
            view.doc_number=String.valueOf(u.getDoc_number());
            view.doc_date=u.getDoc_date();
            view.citizen_ship_name=u.getCitizen_ship_name();
            view.citizen_ship_code=u.getCitizen_ship_code();
            view.office_id=String.valueOf(u.getOffice_id());
            //добить isIdentified


            log.debug(view.toString());

            return view;
        };
    }
}
