package dao;

import domain.Users;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Galabut on 14.04.2015.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private static Logger log = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sf;


    @Override
    public Long read(Users user) {
        Long id=0L;
        Session session;
        try {
            session = sf.getCurrentSession();
            id = (Long) session.get(Users.class, id);
        }catch (HibernateException e){
            log.error("Session to read User failed",e);
        }
        return id;
    }

    @Override
    public List<Users> findAll() {
        Session session;
        List<Users> usersList=null;
        try {
            session=sf.getCurrentSession();
            usersList=session.createCriteria(Users.class).list();
        }catch (HibernateException e){
            log.error("Session to find All Users failed",e);
        }
        return usersList;
    }
}
