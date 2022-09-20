package org.luv2code.bank.atm.app.service;

import org.luv2code.bank.atm.app.dao.LoginDao;
import org.luv2code.bank.atm.app.dao.LoginDaoImpl;
import org.luv2code.bank.atm.app.model.Login;

public class AuthService {
    private LoginDao loginDao = new LoginDaoImpl();

    public boolean isValidAccount(Login loginDetails){
        //login verification
        try {
            return loginDao.verifyLoginDetails(loginDetails);
        } catch (Exception e){
            e.printStackTrace();
        }
        /*if(loginDetails.getAccountId().equals("BANK-100001") && loginDetails.getPin()==1234){
            System.out.println("Login is successful!");
            return true;
        }*/
        return false;
    }
}
