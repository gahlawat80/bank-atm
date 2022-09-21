package org.luv2code.bank.atm.app.service;

import org.luv2code.bank.atm.app.dao.TransactionDao;
import org.luv2code.bank.atm.app.dao.TransactionDaoImpl;

public class TransactionService {

    private TransactionDao transactionDao = new TransactionDaoImpl();

    public void getCurrentBalance(String accountId) throws Exception {
        double curBalance = transactionDao.viewCurrentBalance(accountId);
        System.out.println("Current balance for account :"+accountId+" is :-"+curBalance);
    }
}
