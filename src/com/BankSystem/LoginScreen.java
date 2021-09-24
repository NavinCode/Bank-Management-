package com.BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen implements ActionListener
{
    MyFrame myFrame;
    JButton loginButton;
    JButton signupButton;
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel error;
    User user = new User();
    UserDao userdao = new UserDaoImpl();

    public LoginScreen()
    {
        myFrame = new MyFrame();

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 320, 80, 40);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        signupButton = new JButton("Signup");
        signupButton.setBounds(250, 320, 80, 40);
        signupButton.setFocusable(false);
        signupButton.addActionListener(this);

        Label username = new Label("Enter email or number: ");
        username.setBounds(50,130, 150, 30);

        Label password = new Label("Enter password: ");
        password.setBounds(50, 190, 150, 30);

        error = new JLabel("Invalid credentials. Try again");
        error.setForeground(Color.RED);
        error.setBounds(150, 240, 200, 30);
        error.setVisible(false);

        usernameField = new JTextField();
        usernameField.setBounds(200, 130, 140, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 190, 140, 30);

        myFrame.add(error);
        myFrame.add(password);
        myFrame.add(username);
        myFrame.add(passwordField);
        myFrame.add(usernameField);
        myFrame.add(signupButton);
        myFrame.add(loginButton);
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }



    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == loginButton)
        {
            String uname = usernameField.getText();
            if(uname.contains("@"))
            {
                user.setEmail(uname);
            }
            else
            {
                user.setMobile(uname);
            }
            user.setPassword(String.valueOf(passwordField.getPassword()));

            boolean isLogin = userdao.check(user);


            if(isLogin)
            {
                userdao.getUser(user);
                myFrame.dispose();
                new BankScreen(user);
            }
            else
            {
                error.setVisible(true);
            }

        }
        if(e.getSource() == signupButton)
        {
            myFrame.dispose();
            new Profile(user, true);
        }
    }
}
