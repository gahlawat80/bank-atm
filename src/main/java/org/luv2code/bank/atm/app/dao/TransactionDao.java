package org.luv2code.bank.atm.app.dao;

import org.luv2code.bank.atm.app.model.Transaction;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface TransactionDao {

    double viewCurrentBalance(String accountId) throws Exception;

    boolean depositTransaction(Transaction tx, String accountId) throws Exception;

    double withdrawTransaction(Transaction tx, String accountId) throws Exception;

    List<Transaction> miniStatements(String accountId) throws Exception;

    List<Transaction> getDetailedStatements(String accountId, Date startDate, Date endDate) throws Exception;
}
