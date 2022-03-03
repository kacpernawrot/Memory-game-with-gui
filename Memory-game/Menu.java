package pl.KacperNawrot;

import javax.crypto.spec.PSource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class Menu implements ActionListener {
    JFrame frame= new JFrame();
    JButton button1= new JButton("New Game");
    JButton button2= new JButton("Stats");
    JButton button3= new JButton("Exit");
    String name;

    Menu(String name){
        this.name=name;
        button1.setBounds(200,150, 100, 20);
        button2.setBounds(200,200, 100, 20);
        button3.setBounds(200,250,100,20);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            frame.dispose();
            new Menu1(name);

        }
        if(e.getSource()==button2){
            frame.dispose();
            new Stats(name);
        }
        if(e.getSource()==button3){
            frame.dispose();
            exit(0);
        }
    }
}
