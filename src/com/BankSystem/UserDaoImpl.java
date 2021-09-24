package com.BankSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements  UserDao
{
    private Connection connection;

    public UserDaoImpl()
    {
        JDBC jdbc = new JDBC();
        connection = jdbc.connect();
    }
    public void getUser(User user)
    {
        String query = "SELECT accountNo, firstName, lastName, email, mobile, PAN, aadhar, address, DOB, gender, balance " +
                "FROM bank.user WHERE accountNo = ?";
        try
        {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, user.getAccountNo());
            ResultSet rs = st.executeQuery();
            if(!rs.next())
            {
                System.out.println("User doesn't exist");
            }
            else
            {
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setMobile(rs.getString(5));
                user.setPAN(rs.getString(6));
                user.setAadhar(rs.getString(7));
                user.setAddress(rs.getString(8));
                user.setDOB(rs.getDate(9));
                user.setGender(rs.getString(10));
                user.setBalance(rs.getDouble(11));
                rs.close();
                st.close();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }


    public boolean check(User user)
    {
        String query = "SELECT accountNo FROM bank.user WHERE ((email = ? OR mobile = ?) AND password = SHA1(?))";
        try
        {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, user.getEmail());
            st.setString(2, user.getMobile());
            st.setString(3, user.getPassword());
            ResultSet rs = st.executeQuery();
            if(!rs.next())
            {
                rs.close();
                st.close();
                return false;
            }
            else
            {
                user.setAccountNo(rs.getInt(1));
                rs.close();
                st.close();
                return true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public void updateBalance(User user)
    {
        String query = "UPDATE bank.user SET balance = ? WHERE accountNo = ?";
        try
        {
            PreparedStatement st = connection.prepareStatement(query);
            st.setDouble(1, user.getBalance());
            st.setInt(2, user.getAccountNo());
            st.executeUpdate();
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(User user)
    {
        System.out.println("update" + user);
        String query = "INSERT INTO bank.user"+
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
                "ON DUPLICATE KEY UPDATE firstName = ?, lastName = ?, email = ?, mobile = ?, PAN = ?, aadhar = ?,\n" +
                "address = ?, DOB = ?, gender = ?, balance = ?, password = SHA1(?)";

        try
        {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, user.getAccountNo());
            st.setString(2, user.getFirstName());
            st.setString(3, user.getLastName());
            st.setString(4, user.getEmail());
            st.setString(5, user.getMobile());
            st.setString(6, user.getPAN());
            st.setString(7, user.getAadhar());
            st.setString(8, user.getAddress());
            st.setDate(9, user.getDOB());
            st.setString(10, user.getGender());
            st.setDouble(11, user.getBalance());
            st.setString(12, user.getPassword());
            st.setString(13, user.getFirstName());
            st.setString(14, user.getLastName());
            st.setString(15, user.getEmail());
            st.setString(16, user.getMobile());
            st.setString(17, user.getPAN());
            st.setString(18, user.getAadhar());
            st.setString(19, user.getAddress());
            st.setDate(20, user.getDOB());
            st.setString(21, user.getGender());
            st.setDouble(22, user.getBalance());
            st.setString(23, user.getPassword());
            int rs = st.executeUpdate();
            st.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addUser(User user)
    {
        System.out.println("add" + user);
        String query = "INSERT INTO bank.user (firstName, lastName, email, mobile, \n" +
                "PAN, aadhar, address, DOB, gender, balance, password) \n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SHA1(?))";
        try
        {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getEmail());
            st.setString(4, user.getMobile());
            st.setString(5, user.getPAN());
            st.setString(6, user.getAadhar());
            st.setString(7, user.getAddress());
            st.setDate(8, user.getDOB());
            st.setString(9, user.getGender());
            st.setDouble(10, user.getBalance());
            st.setString(11, user.getPassword());
            st.executeUpdate();
            st.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
