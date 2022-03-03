package pl.KacperNawrot;

import javax.crypto.spec.PSource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logorreg implements ActionListener {
    JFrame frame= new JFrame();
    JLabel label=new JLabel("Do you want to log in or register?");
    JButton button1= new JButton("Log in");
    JButton button2= new JButton("Register");
    Logorreg(){
        button1.setBounds(200,200, 100, 20);
        button2.setBounds(200,250, 100, 20);
        label.setBounds(150,150,200,20);
        frame.add(label);
        frame.add(button1);
        frame.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            frame.dispose();
            new Login();

        }
        if(e.getSource()==button2){
            frame.dispose();
            new Register();
        }

    }
}

