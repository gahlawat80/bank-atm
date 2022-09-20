package org.luv2code.bank.atm.app.dao;

import org.luv2code.bank.atm.app.model.Login;
import org.luv2code.bank.atm.app.model.Registration;

import java.sql.SQLException;

public interface LoginDao {

    boolean verifyLoginDetails(Login login) throws Exception;
    String saveUser(Registration user) throws Exception;

}
