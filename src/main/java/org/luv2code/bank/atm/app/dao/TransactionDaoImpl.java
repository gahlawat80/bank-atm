package org.luv2code.bank.atm.app.dao;

import org.luv2code.bank.atm.app.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean depositTransaction(Transaction tx,String accountId) throws Exception {
        con = createConnection();
        String sql = "INSERT INTO tbl_transactions(transaction_id,transaction_type,transaction_amount,current_balance,transaction_date,account_id) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,tx.getTransactionId());
        ps.setString(2,tx.getTransactionType());
        ps.setDouble(3,tx.getTransactionAmount());
        ps.setDouble(4,tx.getCurrentBalance());
        ps.setDate(5,new Date(tx.getTransactionDate().getTime()));
        ps.setString(6,accountId);
        int result = ps.executeUpdate();
        if(result==1){
            return true;
        }
        return false;
    }

    @Override
    public double withdrawTransaction(Transaction tx, String accountId) throws Exception {
        con = createConnection();
        String sql = "INSERT INTO tbl_transactions(transaction_id,transaction_type,transaction_amount,current_balance,transaction_date,account_id) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,tx.getTransactionId());
        ps.setString(2,tx.getTransactionType());
        ps.setDouble(3,tx.getTransactionAmount());
        ps.setDouble(4,tx.getCurrentBalance());
        ps.setDate(5,new Date(tx.getTransactionDate().getTime()));
        ps.setString(6,accountId);
        int result = ps.executeUpdate();
        if(result==1){
            return tx.getTransactionAmount();
        }
        return 0;
    }

    @Override
    public List<Transaction> miniStatements(String accountId) throws Exception {
        List<Transaction> miniStatementsList =new ArrayList<>();
        Transaction tx = null;
        con = createConnection();
        String sql = "SELECT * FROM tbl_transactions WHERE account_id='"+accountId+"' ORDER BY id desc LIMIT 5";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            tx = new Transaction();
            tx.setId(rs.getInt("id"));
            tx.setTransactionId(rs.getString("transaction_id"));
            tx.setTransactionType(rs.getString("transaction_type"));
            tx.setTransactionAmount(rs.getDouble("transaction_amount"));
            tx.setCurrentBalance(rs.getDouble("current_balance"));
            tx.setTransactionDate(new Date(rs.getDate("transaction_date").getTime()));

            miniStatementsList.add(tx);
        }
        return miniStatementsList;
    }
}
