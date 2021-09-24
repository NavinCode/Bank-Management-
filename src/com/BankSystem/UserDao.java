package com.BankSystem;

public interface UserDao
{
    void getUser(User user);
    void update(User user);
    boolean check(User user);
    void updateBalance(User user);
    void addUser(User user);
}
