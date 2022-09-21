package org.luv2code.bank.atm.app.dao;

import java.sql.SQLException;

public interface TransactionDao {

    double viewCurrentBalance(String accountId) throws Exception;
}
