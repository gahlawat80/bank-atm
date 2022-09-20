package org.luv2code.bank.atm.app.dao;

import org.luv2code.bank.atm.app.model.Login;

import java.sql.SQLException;

public interface LoginDao {

    boolean verifyLoginDetails(Login login) throws Exception;

}
