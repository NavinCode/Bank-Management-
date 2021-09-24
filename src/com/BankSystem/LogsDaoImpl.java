package com.BankSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogsDaoImpl implements  LogsDao
{
    private Connection connection;

    public LogsDaoImpl()
    {
        JDBC jdbc = new JDBC();
        connection = jdbc.connect();
    }

    public void insertLog(Logs log)
    {
        String query = "INSERT INTO bank.logs VALUES (?, ?, ?, ?, ?, NOW())";
        try
        {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, log.getAccountNo());
            st.setDouble(2, log.getBalance());
            st.setDouble(3, log.getDeposit());
            st.setDouble(4, log.getWithdraw());
            st.setDouble(5, log.getUpdatedBalance());
            st.executeUpdate();
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ResultSet getLog(User user)
    {
        String query = "SELECT balance, deposit, withdraw, updatedBalance, datetime from bank.logs WHERE accountNo = ?";
        try
        {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, user.getAccountNo());
            ResultSet rs = st.executeQuery();
            return rs;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
