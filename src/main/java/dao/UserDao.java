package dao;


import domain.Users;

import java.util.List;

/**
 * Created by Galabut on 14.04.2015.
 */
public interface UserDao {
    Long read(Users user);
    List<Users> findAll();
}
