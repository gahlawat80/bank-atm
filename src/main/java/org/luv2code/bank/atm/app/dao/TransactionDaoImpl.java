package org.luv2code.bank.atm.app.dao;

import java.sql.*;

public class TransactionDaoImpl implements TransactionDao {
    private Connection con;

    private Connection createConnection() throws Exception {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_app", "root", "mysql");
        return con;
    }
    @Override
    public double viewCurrentBalance(String accountId) throws Exception {
        double currentBalance = 0.0;
        String sql = "SELECT * FROM tbl_transactions WHERE account_id='"+accountId+"' ORDER BY id desc LIMIT 1";
        con = createConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            currentBalance = rs.getDouble("current_balance");
        }
        return currentBalance;
    }
}
