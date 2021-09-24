package com.BankSystem;

import java.sql.ResultSet;

public interface LogsDao
{
    void insertLog(Logs logs);
    ResultSet getLog(User user);
}
