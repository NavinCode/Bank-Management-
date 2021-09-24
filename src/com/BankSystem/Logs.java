package com.BankSystem;

import java.time.LocalDateTime;

public class Logs
{
    private int accountNo;
    private double balance;
    private double deposit;
    private double withdraw;
    private double updatedBalance;

    public Logs(){}

    public Logs(Logs other)
    {
        this.accountNo = other.accountNo;
        this.balance = other.balance;
        this.deposit = other.deposit;
        this.withdraw = other.withdraw;
        this.updatedBalance = other.updatedBalance;
    }

    public String toString() {
        return "Logs{" +
                "accountNo=" + accountNo +
                ", balance=" + balance +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", updatedBalance=" + updatedBalance +
                '}';
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double getUpdatedBalance() {
        return updatedBalance;
    }

    public void setUpdatedBalance(double updatedBalance) {
        this.updatedBalance = updatedBalance;
    }
}
