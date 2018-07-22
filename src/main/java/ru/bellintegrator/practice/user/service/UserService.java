package ru.bellintegrator.practice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * {@inheritDoc}
 */
@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    // private final UserDao dao;

//    @Autowired
//    public UserService(UserDao dao) {
//        this.dao = dao;
//    }

    /**
     * 10. api/user/{id}
     * получить юзера
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public UserView user(long id) {

        User starUs = getUser(id);
        //Organization starOrg = dao.loadById(id);
        UserView view = mapUser().apply(starUs);

        return view;
    }

    private User getUser(long id) {
        User starUs = new User();
        starUs.setId(id);
        starUs.setFirstName("Сергей");
        starUs.setSecondName("Иванович");
        starUs.setMiddleName("Алешин");
        starUs.setPosition("адвокат");
        starUs.setPhone("250005");
        starUs.setDocName("паспорт");
        starUs.setDocNumber("508");
        starUs.setDocDate("25.05.86");
        starUs.setCitizenshipCode("285");
        starUs.setCitizenshipName("Россия");
        starUs.setOfficeId(id);
        starUs.setIdentified(true);

        return starUs;
    }


    /**
     * 9. api/user/list
     *
     * @param view-данные которые передает пользователь и по которым фильтруем юзеров
     * @return users-возвращаю юзеров
     */
    @Transactional
    public List<UserView> users(UserView view) {
        List<UserView> users = new ArrayList<UserView>();
        for (int i = 0; i < 3; i++) {
            User oneUs = getUser((long) i);
            UserView view1 = mapUser().apply(oneUs);
            users.add(view1);
        }

        return users;
    }

    public UserService() {
    }

    /**
     * 12. api/user/save
     *
     * @param view
     */

    @Transactional
    public void add(UserView view) {
        User user = new User(view.firstName, view.secondName, view.middleName, view.position,
                view.phone, view.docName, view.docDate, view.citizenshipName, view.citizenshipCode,
               Long.valueOf(view.officeId), view.isIdentified);
        // dao.save(organization);

    }

    @Transactional
    public void update(UserView view) {
        User user = getUser(Long.valueOf(view.id));
        user.setId(Long.valueOf(view.id));
        user.setFirstName(view.firstName);
        user.setSecondName(view.secondName);
        user.setMiddleName(view.middleName);
        user.setPosition(view.position);
        user.setPhone(view.phone);
        user.setDocName(view.docName);
        user.setDocDate(view.docDate);
        user.setCitizenshipName(view.citizenshipName);
        user.setCitizenshipCode(view.citizenshipCode);
        user.setOfficeId(Long.valueOf(view.officeId));

        // dao.save(organization);
    }

    private Function<User, UserView> mapUser() {
        return v -> {
            UserView view = new UserView();

            view.id = String.valueOf(v.getId());
            view.firstName = String.valueOf(v.getFirstName());
            view.secondName = v.getSecondName();
            view.middleName = v.getMiddleName();
            view.position = v.getPosition();
            view.phone = v.getPhone();
            view.docName = v.getDocName();
            view.docNumber = v.getDocNumber();
            view.docDate = v.getDocDate();
            view.citizenshipName = v.getCitizenshipName();
            view.citizenshipCode = v.getCitizenshipCode();
            view.officeId = String.valueOf(v.getOfficeId());
            view.isIdentified = v.isIdentified();

            log.debug(view.toString());

            return view;
        };
    }
}
