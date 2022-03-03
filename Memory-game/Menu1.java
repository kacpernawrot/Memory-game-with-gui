package pl.KacperNawrot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu1 implements ActionListener {
    String name;
    JFrame frame= new JFrame();
    JButton button1= new JButton("player vs player");
    JButton button2= new JButton("player vs computer");
    Menu1(String name){
        this.name=name;
        button1.setBounds(160,180, 150, 20);
        button2.setBounds(160,220, 150, 20);
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
            Size size= new Size(name,1);
        }
        if(e.getSource()==button2){
            frame.dispose();
            Size size= new Size(name,2);
        }


    }
}
