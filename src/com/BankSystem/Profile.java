package com.BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Profile implements ActionListener
{
    User user;
    JFrame ProfileFrame;
    JTextField fnamefield;
    JTextField lnamefield;
    JTextField dobfield;
    JTextField panfield;
    JTextField aadarfield;
    JTextField emailfield;
    JTextField numberfield;
    JTextField accountfield;
    JRadioButton malebutton;
    JRadioButton femalebutton;
    JPasswordField enterpass;
    JTextArea addressarea;
    JButton confirm;
    JButton changePass;
    JButton back;
    ButtonGroup bg;
    boolean signUp;

    public Profile(User otheruser, boolean isSignup)
    {
        signUp = isSignup;
        ProfileFrame = new MyFrame();
        ProfileFrame.setTitle("Profile");
        ProfileFrame.setSize(540,500);
        user = otheruser;


        addressarea = new JTextArea();
        addressarea.setBorder((BorderFactory.createLineBorder(Color.black)));
        addressarea.setBounds(100, 150, 120, 60);

        JLabel fname = new JLabel("First Name ");
        fname.setBounds(10, 30, 80, 20);

        fnamefield = new JTextField();
        fnamefield.setBounds(100, 30, 120, 20);

        JLabel lname = new JLabel("Last Name ");
        lname.setBounds(10, 90, 80, 20);

        lnamefield = new JTextField();
        lnamefield.setBounds(100, 90, 120, 20);

        JLabel address = new JLabel("Address ");
        address.setBounds(10, 150, 80, 20);

        JLabel dob = new JLabel("Date of birth ");
        dob.setBounds(10, 230, 80, 20);

        dobfield = new JTextField("yyyy-MM-dd");
        dobfield.setBounds(100, 230, 120, 20);

        JLabel gender = new JLabel("Gender ");
        gender.setBounds(10, 290, 80, 20);

        JLabel pan = new JLabel("PAN number ");
        pan.setBounds(260, 30, 80, 20);

        panfield = new JTextField();
        panfield.setBounds(360, 30, 120, 20);

        JLabel aadar = new JLabel("Aadar number ");
        aadar.setBounds(260, 90, 120, 20);

        aadarfield = new JTextField();
        aadarfield.setBounds(360, 90, 120, 20);

        JLabel email = new JLabel("E-mail ");
        email.setBounds(260, 150, 80, 20);

        emailfield = new JTextField();
        emailfield.setBounds(360, 150, 120, 20);

        JLabel number = new JLabel("Mobile Number ");
        number.setBounds(260, 230, 100, 20);

        numberfield = new JTextField();
        numberfield.setBounds(360, 230, 120, 20);

        JLabel password = new JLabel("Password ");
        password.setBounds(260, 290, 80, 20);

        JLabel account = new JLabel("Account Number ");
        account.setBounds(10, 350, 100, 20);
        account.setVisible(false);

        accountfield = new JTextField();
        accountfield.setBounds(110, 350, 120, 20);
        accountfield.setEditable(false);
        accountfield.setVisible(false);

        confirm = new JButton("Confirm");
        confirm.setBounds(130, 400, 80, 30);
        confirm.setFocusable(false);
        confirm.addActionListener(this);

        malebutton = new JRadioButton("Male");
        malebutton.setBounds(100, 290, 80, 20);
        malebutton.addActionListener(this);

        femalebutton = new JRadioButton("Female");
        femalebutton.setBounds(100, 320, 80, 20);
        femalebutton.addActionListener(this);

        bg = new ButtonGroup();
        bg.add(malebutton);
        bg.add(femalebutton);

        Image unscaled = new ImageIcon("back.png").getImage();
        Image scaled = unscaled.getScaledInstance( 80, 50,  java.awt.Image.SCALE_SMOOTH );
        Icon backicon = new ImageIcon(scaled);
        back = new JButton(backicon);
        back.setFocusable(false);
        back.setBounds(30, 400, 80, 30);
        back.addActionListener(this);


        changePass = new JButton("Change Password");
        changePass.setBounds(360, 290, 120, 20);
        changePass.addActionListener(this);
        changePass.setVisible(false);

        enterpass = new JPasswordField();
        enterpass.setBounds(360, 290, 120, 20);

        if(!isSignup)
        {
            initialize();
            account.setVisible(true);
            accountfield.setVisible(true);
            enterpass.setVisible(false);
            changePass.setVisible(true);
            aadarfield.setEditable(false);
            panfield.setEditable(false);
            dobfield.setEditable(false);
            lnamefield.setEditable(false);
            fnamefield.setEditable(false);
            malebutton.setEnabled(false);
            femalebutton.setEnabled(false);
        }


        ProfileFrame.add(fname);
        ProfileFrame.add(lname);
        ProfileFrame.add(address);
        ProfileFrame.add(dob);
        ProfileFrame.add(gender);
        ProfileFrame.add(pan);
        ProfileFrame.add(aadar);
        ProfileFrame.add(email);
        ProfileFrame.add(fname);
        ProfileFrame.add(number);
        ProfileFrame.add(password);
        ProfileFrame.add(account);
        ProfileFrame.add(fnamefield);
        ProfileFrame.add(lnamefield);
        ProfileFrame.add(addressarea);
        ProfileFrame.add(dobfield);
        ProfileFrame.add(panfield);
        ProfileFrame.add(aadarfield);
        ProfileFrame.add(emailfield);
        ProfileFrame.add(numberfield);
        ProfileFrame.add(accountfield);
        ProfileFrame.add(confirm);
        ProfileFrame.add(back);
        ProfileFrame.add(malebutton);
        ProfileFrame.add(femalebutton);
        ProfileFrame.add(changePass);
        ProfileFrame.add(enterpass);
        ProfileFrame.setLocationRelativeTo(null);
        ProfileFrame.setVisible(true);
    }

    void changePassword(JDialog jd)
    {
        jd.setSize(350, 220);
        jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jd.setLayout(null);

        Label oldPass = new Label("Change Password");
        oldPass.setBounds(20, 20, 120, 20);

        Label newPass = new Label("Enter new password");
        newPass.setBounds(20, 80, 120, 20);

        JPasswordField oldPassField = new JPasswordField();
        oldPassField.setBounds(180, 20, 150, 20);

        JPasswordField newPassField = new JPasswordField();
        newPassField.setBounds(180, 80, 150, 20);

        JLabel error = new JLabel("The old password is wrong");
        error.setBounds(10, 120, 200, 20);
        error.setVisible(false);

        JButton change = new JButton("Confirm");
        change.setBounds(200, 120, 100, 20);
        change.setFocusable(false);
        change.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String newpass = String.valueOf(newPassField.getPassword());
                String oldpass = String.valueOf(oldPassField.getPassword());

                if(oldpass.equals(user.getPassword()))
                {
                    error.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Changed Successfully", "Success Message", JOptionPane.INFORMATION_MESSAGE);
                    user.setPassword(newpass);
                }
                else
                {
                    error.setVisible(true);
                }
            }
        });

        jd.add(error);
        jd.add(change);
        jd.add(oldPass);
        jd.add(newPass);
        jd.add(newPassField);
        jd.add(oldPassField);
        jd.setVisible(true);
    }


    void initialize()
    {
        fnamefield.setText(user.getFirstName());
        lnamefield.setText(user.getLastName());
        addressarea.setText(user.getAddress());
        dobfield.setText(String.valueOf(user.getDOB()));
        panfield.setText(user.getPAN());
        aadarfield.setText(user.getAadhar());
        emailfield.setText(user.getEmail());
        numberfield.setText(user.getMobile());
        accountfield.setText(String.valueOf(user.getAccountNo()));


        String gen = user.getGender();
        if(gen != null)
        {
            if (gen.equals("Male")) {
                malebutton.setSelected(true);
            } else if (gen.equals("Female")) {
                femalebutton.setSelected(true);
            }
        }
    }


    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == confirm)
        {
            confirm.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Changed Successfully", "Success Message", JOptionPane.INFORMATION_MESSAGE);
            user.setFirstName(fnamefield.getText());
            user.setLastName(lnamefield.getText());
            user.setAddress(addressarea.getText());
            user.setPAN(panfield.getText());
            user.setAadhar(aadarfield.getText());
            user.setEmail(emailfield.getText());
            user.setMobile(numberfield.getText());
            if(signUp)
            {
                user.setPassword(String.valueOf(enterpass.getPassword()));
            }



            try
            {
                String dt = dobfield.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate ld = LocalDate.parse(dt, formatter);
                Date date = Date.valueOf(ld);
                user.setDOB(date);
            }
            catch(Exception ex)
            {
            }

            UserDao userdao = new UserDaoImpl();

            if(signUp)
            {
                userdao.addUser(user);
            }
            else
            {
                userdao.update(user);
            }


        }
        if(e.getSource() == malebutton)
        {
            user.setGender("Male");
        }
        if(e.getSource() == femalebutton)
        {
            user.setGender("Female");
        }
        if(e.getSource() == changePass)
        {
            JDialog jd = new JDialog(new JFrame(), "Change");
            changePassword(jd);
            jd.setLocationRelativeTo(null);
            jd.setVisible(true);
        }
        if(e.getSource() == back)
        {
            if(signUp)
            {
                ProfileFrame.dispose();
                new LoginScreen();
            }
            else
            {
                ProfileFrame.dispose();
                new BankScreen(user);
            }
        }
    }
}

