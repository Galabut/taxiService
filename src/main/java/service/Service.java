package service;


import domain.Users;

import java.util.List;

/**
 * Created by Galabut on 14.04.2015.
 */
public interface Service {
    List<Users> findAll();
    boolean getUser(String login, String password);
}
