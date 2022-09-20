package org.luv2code.bank.atm.app.service;

import org.luv2code.bank.atm.app.model.Login;

public class AuthService {

    public boolean isValidAccount(Login loginDetails){

        //User provided login detail

        //Login details saved in db

        //login verification
        if(loginDetails.getAccountId().equals("BANK-100001") && loginDetails.getPin()==1234){
            System.out.println("Login is successful!");
            return true;
        }
        return false;
    }
}
