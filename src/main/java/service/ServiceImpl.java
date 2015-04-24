package service;

import dao.UserDao;
import domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Galabut on 14.04.2015.
 */
@Component ("ServiceImpl")
@Transactional
public class ServiceImpl implements Service {

    @Autowired
    private UserDao dao;

    @Override
    public List<Users> findAll() {
        return dao.findAll();
    }

    @Override
    public boolean getUser(String login, String password) {
        List<Users> userses = findAll();
        for (Users users : userses) {
            if (users.getLogin().equals(login) && users.getPassword().equals(password)) return true;
        }
        return false;
    }
}
