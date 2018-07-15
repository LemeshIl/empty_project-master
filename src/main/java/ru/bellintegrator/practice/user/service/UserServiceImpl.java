package ru.bellintegrator.practice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.person.dao.PersonDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.function.Function;

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
    public UserView user(Long id) {

        User userSar = new User();
        userSar.setId(id);
        userSar.setFirstName("Иван");
        userSar.setSecondName("Сергеевич");
        userSar.setMiddleName("Дягилев");
        userSar.setPosition("диспетчер");
        userSar.setPhone(253387);
        userSar.setDocName("паспорт");
        userSar.setDocNumber(552211);
        userSar.setCitizenshipName("Россия");
        userSar.setCitizenshipCode("5hg8");
        userSar.setIdentified(true);
        userSar.setOfficeId(id);
        UserView view = mapUser().apply(userSar);

        return view;
    }

    private Function<User, UserView> mapUser() {
        return u -> {

            UserView view = new UserView();

            view.id = String.valueOf(u.getId());
            view.firstName = u.getFirstName();
            view.secondName = u.getSecondName();
            view.middleName = u.getMiddleName();
            view.position = u.getPosition();
            view.phone = String.valueOf(u.getPhone());
            view.docName = u.getDocName();
            view.docNumber = String.valueOf(u.getDocNumber());
            view.docDate = u.getDocDate();
            view.citizenshipName = u.getCitizenshipName();
            view.citizenshipCode = u.getCitizenshipCode();
            view.officeId = String.valueOf(u.getOfficeId());
            view.isIdentified = u.isIdentified();

            return view;
        };
    }
}
