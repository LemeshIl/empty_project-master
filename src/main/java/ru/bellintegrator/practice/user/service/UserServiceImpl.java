package ru.bellintegrator.practice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.user.dao.UserDaoImpl;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;
import ru.bellintegrator.practice.userDocs.model.UserDocs;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserDaoImpl dao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<UserView> users(UserView view) {
        List<User> users = dao.users(Long.valueOf(view.officeId));

        return users.stream()
                .map(mapUser())
                .collect(Collectors.toList());
    }

    @Autowired
    public UserServiceImpl(UserDaoImpl dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
        starUs.setCitizenshipCode("285");
        starUs.setCitizenshipName("Россия");
        starUs.setOfficeId(id);
        starUs.setIdentified(true);

        return starUs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(UserView view) {
        UserDocs userDocs=new UserDocs(Long.valueOf(view.docId),view.docCode,view.docName,view.docNumber,view.docDate);
        User user = new User(Long.valueOf(view.id),view.firstName, view.secondName, view.middleName, view.position,
                view.phone, view.citizenshipName, view.citizenshipCode,
                Long.valueOf(view.officeId), view.isIdentified,userDocs);

        dao.update(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(UserView view) {
        UserDocs userDocs=new UserDocs(view.docCode,view.docName,view.docNumber,view.docDate);
        User user = new User(view.firstName, view.secondName, view.middleName, view.position,
                view.phone, view.citizenshipName, view.citizenshipCode,
                Long.valueOf(view.officeId), view.isIdentified,userDocs);
        dao.save(user);
    }

    private Function<User, UserView> mapUser() {
        return user -> {
            UserView view = new UserView();

            view.id = String.valueOf(user.getId());
            view.firstName = String.valueOf(user.getFirstName());
            view.secondName = user.getSecondName();
            view.middleName = user.getMiddleName();
            view.position = user.getPosition();
            view.phone = user.getPhone();
            view.citizenshipName = user.getCitizenshipName();
            view.citizenshipCode = user.getCitizenshipCode();
            view.officeId = String.valueOf(user.getOfficeId());
            view.isIdentified = user.isIdentified();

            view.docId= String.valueOf(user.getUserDocs().getId());
            view.docName=user.getUserDocs().getDocName();
            view.docCode=user.getUserDocs().getDocCode();
            view.docNumber=user.getUserDocs().getDocNumber();
            view.docDate=user.getUserDocs().getDocDate();

            log.debug(view.toString());

            return view;
        };
    }
}
