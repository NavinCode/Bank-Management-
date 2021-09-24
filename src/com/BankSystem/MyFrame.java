package com.BankSystem;

import javax.swing.*;

public class MyFrame extends JFrame
{
    public MyFrame()
    {
        this.setTitle("E-Banking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(450,450);
        ImageIcon image = new ImageIcon("rupee.jpg");
        this.setIconImage(image.getImage());
   }
}
