package org.luv2code.bank.atm.app.service;

import org.luv2code.bank.atm.app.dao.TransactionDao;
import org.luv2code.bank.atm.app.dao.TransactionDaoImpl;
import org.luv2code.bank.atm.app.model.Transaction;

import java.util.Date;
import java.util.UUID;

public class TransactionService {

    private TransactionDao transactionDao = new TransactionDaoImpl();

    public void getCurrentBalance(String accountId) throws Exception {
        double curBalance = transactionDao.viewCurrentBalance(accountId);
        System.out.println("Current balance for account :"+accountId+" is :-"+curBalance);
    }

    public void depositAmount(double amount, String accountId) throws Exception {
        Transaction tx = new Transaction();
        tx.setTransactionId(UUID.randomUUID().toString());
        tx.setTransactionType("DEPOSIT");
        tx.setTransactionAmount(amount);
        double currentBalance = transactionDao.viewCurrentBalance(accountId);
        tx.setCurrentBalance(currentBalance+amount);
        tx.setTransactionDate(new Date());

        boolean flag = transactionDao.depositTransaction(tx,accountId);
        if(flag){
            System.out.println("Deposit transaction of amount: "+amount+" is successfully created for account: "+accountId);
        } else {
            System.out.println("Deposit transaction of amount: "+amount+" is NOT created for account: "+accountId+". Please try again later!");
        }
    }

    public void withdrawMoney(double amount,String accountId) throws Exception {
        Transaction tx = new Transaction();
        tx.setTransactionId(UUID.randomUUID().toString());
        tx.setTransactionType("WITHDRAW");
        tx.setTransactionAmount(amount);
        double currentBalance = transactionDao.viewCurrentBalance(accountId);
        tx.setCurrentBalance(currentBalance - amount);
        tx.setTransactionDate(new java.sql.Date(new Date().getTime()));

        if((currentBalance - amount)>=0){
            double withdrawAmount = transactionDao.withdrawTransaction(tx,accountId);
            if(withdrawAmount>0){
                System.out.println("Withdrwal of amount :"+amount+" from account: "+accountId+" is successful!");
            }else {
                System.out.println("Withdrwal of amount :"+amount+" from account: "+accountId+" is NOT successful!");
            }
        } else {
            System.out.println("Withdrwal of amount :" + amount + " from account: " + accountId + " is NOT possible as current balance: " + currentBalance + " is less than amount to be withdrawn");
        }
    }
}
