package ru.bellintegrator.practice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserDao dao;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    /**
     * 10. api/user/{id}
     * получить юзера по id
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public UserView user(long id) {
        User starUs = dao.loadById(id);
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
     * получить юзеров
     * @param view-данные которые передает пользователь и по которым фильтруем юзеров
     * @return users-возвращаю юзеров
     */
    @Transactional
    public List<UserView> users(UserView view) {
        List<User> users = dao.users(view.firstName);

        return users.stream()
                .map(mapUser())
                .collect(Collectors.toList());
    }

    /**
     * 12. api/user/save
     * сохранить юзера
     * @param view
     */
    @Transactional
    public void add(UserView view) {
        User user = new User(view.firstName, view.secondName, view.middleName, view.position,
                view.phone,view.docNumber, view.docName, view.docDate, view.citizenshipName, view.citizenshipCode,
                Long.valueOf(view.officeId), view.isIdentified);
        dao.save(user);
    }

    /**
     * 11. api/user/update
     * Обновить юзера
     * @param view
     */
    @Transactional
    public void update(UserView view) {
        User user = new User(view.firstName, view.secondName, view.middleName, view.position,
                view.phone, view.docName,view.docNumber, view.docDate, view.citizenshipName, view.citizenshipCode,
                Long.valueOf(view.officeId), view.isIdentified);
        user.setId(Long.valueOf(view.id));

        dao.update(user);
    }

    private Function<User, UserView> mapUser() {
        return u -> {
            UserView view = new UserView();

            view.id = String.valueOf(u.getId());
            view.firstName = String.valueOf(u.getFirstName());
            view.secondName = u.getSecondName();
            view.middleName = u.getMiddleName();
            view.position = u.getPosition();
            view.phone = u.getPhone();
            view.docName = u.getDocName();
            view.docNumber = u.getDocNumber();
            view.docDate = u.getDocDate();
            view.citizenshipName = u.getCitizenshipName();
            view.citizenshipCode = u.getCitizenshipCode();
            view.officeId = String.valueOf(u.getOfficeId());
            view.isIdentified = u.isIdentified();

            log.debug(view.toString());

            return view;
        };
    }
}
