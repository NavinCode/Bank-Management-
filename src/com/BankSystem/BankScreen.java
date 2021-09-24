package com.BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankScreen implements ActionListener
{
    MyFrame BankFrame;
    JTextField amountField;
    JButton deposit;
    JButton changeProfile;
    JButton withdraw;
    JButton log;
    JButton out;
    JLabel username;
    JLabel accountNo;
    JLabel balance;
    JLabel prompt;
    JLabel error;
    User user;

    public BankScreen(User otheruser)
    {
        BankFrame = new MyFrame();
        user = otheruser;

        username = new JLabel();
        username.setText("Welcome " + user.getFirstName() + " " + user.getLastName());
        username.setBounds(10, 10, 200, 30);

        accountNo = new JLabel();
        accountNo.setText("Your account number is " + user.getAccountNo());
        accountNo.setBounds(10, 50, 200, 30);

        balance = new JLabel();
        setLabel();
        balance.setBounds(10, 100, 200, 30);

        prompt = new JLabel("Enter amount: ");
        prompt.setBounds(40, 150, 100, 30 );

        amountField = new JTextField();
        amountField.setBounds(160, 150, 100, 30);

        deposit = new JButton("Deposit");
        deposit.setBounds(100, 240, 120, 30 );
        deposit.setBackground(Color.decode("#4ea24e"));
        deposit.setFocusable(false);
        deposit.addActionListener(this);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(230, 240, 120, 30);
        withdraw.setBackground(Color.decode("#f06060"));
        withdraw.setFocusable(false);
        withdraw.addActionListener(this);


        log = new JButton("Transaction Logs");
        log.setBounds(160, 300, 150, 50);
        log.setFocusable(false);
        log.addActionListener(this);

        Image unscaledset = new ImageIcon("settings.png").getImage();
        Image scaledset =  unscaledset.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH );
        Icon settings = new ImageIcon(scaledset);
        changeProfile = new JButton(settings);
        changeProfile.setBounds(370, 20, 50, 50);
        changeProfile.setFocusable(false);
        changeProfile.addActionListener(this);

        error = new JLabel("Insufficient Balance");
        error.setBounds(170, 200, 200, 20);
        error.setForeground(Color.RED);
        error.setVisible(false);

        Image unscaled = new ImageIcon("logout.png").getImage();
        Image scaled = unscaled.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH );
        Icon logout = new ImageIcon(scaled);
        out = new JButton();
        out.setBounds(310, 20, 50, 50);
        out.setIcon(logout);
        out.setFocusable(false);
        out.addActionListener(this);

        BankFrame.add(error);
        BankFrame.add(out);
        BankFrame.add(log);
        BankFrame.add(deposit);
        BankFrame.add(withdraw);
        BankFrame.add(amountField);
        BankFrame.add(prompt);
        BankFrame.add(username);
        BankFrame.add(accountNo);
        BankFrame.add(balance);
        BankFrame.add(changeProfile);
        BankFrame.setLocationRelativeTo(null);
        BankFrame.setVisible(true);
    }

    void setLabel()
    {
        balance.setText("Your current balance is " + user.getBalance());
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == deposit)
        {
            error.setVisible(false);
            Logs log = new Logs();
            log.setBalance(user.getBalance());
            log.setAccountNo(user.getAccountNo());
            double amount = Double.parseDouble(amountField.getText());
            log.setDeposit(amount);
            user.setBalance(user.getBalance() + amount);
            log.setUpdatedBalance(user.getBalance());
            UserDao userdao = new UserDaoImpl();
            userdao.updateBalance(user);
            setLabel();
            LogsDao logsdao = new LogsDaoImpl();
            logsdao.insertLog(log);
        }
        if(e.getSource() == withdraw)
        {
            double amount = Double.parseDouble(amountField.getText());
            if(user.getBalance() < amount)
            {
                error.setVisible(true);
            }
            else
            {
                error.setVisible(false);
                Logs log = new Logs();
                log.setBalance(user.getBalance());
                log.setAccountNo(user.getAccountNo());
                log.setWithdraw(amount);
                user.setBalance(user.getBalance() - amount);
                log.setUpdatedBalance(user.getBalance());
                UserDao userdao = new UserDaoImpl();
                userdao.updateBalance(user);
                setLabel();
                LogsDao logsdao = new LogsDaoImpl();
                logsdao.insertLog(log);
            }

        }
        if(e.getSource() == log)
        {
            new logTable(user);
        }
        if(e.getSource() == changeProfile)
        {
            BankFrame.dispose();
            new Profile(user, false);
        }
        if(e.getSource() == out)
        {
            BankFrame.dispose();
            new LoginScreen();
        }


    }

}
