package org.luv2code.bank.atm.app.dao;

import org.luv2code.bank.atm.app.model.Login;

import java.sql.*;

public class LoginDaoImpl implements LoginDao{

    private Connection con;

    private Connection createDBConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_app", "root", "mysql");
        } catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public boolean verifyLoginDetails(Login login) throws Exception {
        Connection con = createDBConnection();

        String sql = "SELECT * FROM tbl_accounts WHERE account_id='"+login.getAccountId()+"'";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
            String dbAccId = rs.getString("account_id");
            int dbPin = rs.getInt("pin");

            if(dbAccId != login.getAccountId() && dbPin !=login.getPin()){
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
