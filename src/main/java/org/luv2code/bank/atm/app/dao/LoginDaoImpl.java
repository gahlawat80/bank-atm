package org.luv2code.bank.atm.app.dao;

import org.luv2code.bank.atm.app.model.Login;
import org.luv2code.bank.atm.app.model.Registration;

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

    @Override
    public String saveUser(Registration user) throws Exception {
        Connection con = createDBConnection();
        boolean isUserCreated = false;
        boolean isLoginCreated = false;

        boolean isUserPresent = verifyLoginDetails(new Login(user.getAccountId(),user.getPin()));
        if(!isUserPresent){
            String registerQuery = "INSERT INTO tbl_registration(name,age,account_id) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(registerQuery);
            ps.setString(1,user.getName());
            ps.setInt(2,user.getAge());
            ps.setString(3,user.getAccountId());
            int result =ps.executeUpdate();
            if(result==1){
                isUserCreated = true;
            }
            String loginQuery = "INSERT INTO tbl_accounts(account_id,pin) VALUES(?,?)";
            ps = con.prepareStatement(loginQuery);
            ps.setString(1,user.getAccountId());
            ps.setInt(2,user.getPin());
            result = ps.executeUpdate();
            if(result==1){
                isLoginCreated=true;
            }
        }
        if(isLoginCreated && isUserCreated){
            return "User is successfully registered with account- "+user.getAccountId();
        }
        return "User is NOT registered with account- "+user.getAccountId();
    }
}
