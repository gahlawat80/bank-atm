package org.luv2code.bank.atm.app.dao;

import org.luv2code.bank.atm.app.model.Transaction;

import java.sql.SQLException;

public interface TransactionDao {

    double viewCurrentBalance(String accountId) throws Exception;

    boolean depositTransaction(Transaction tx, String accountId) throws Exception;
}
