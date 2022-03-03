package pl.KacperNawrot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseCards implements ActionListener {
    int which=0;
    String name;
    JFrame frame= new JFrame();
    JLabel label= new JLabel("Choose type of cards");
    JButton button1= new JButton("Fotball clubs logos");
    JButton button2= new JButton("Animals");
    int multiplayer;
    ChooseCards(int which, String name, int multiplayer){
        this.multiplayer=multiplayer;
        this.name=name;
        this.which=which;
        label.setBounds(185,120,150,20);
        button1.setBounds(160,180, 150, 20);
        button2.setBounds(160,220, 150, 20);
        frame.add(button1);
        frame.add(button2);
        frame.add(label);
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
            if(which==1){
                frame.dispose();
                Board1 board= new Board1(1,name,multiplayer);}
            if(which==2){
                frame.dispose();
                Board2 board2=new Board2(1,name,multiplayer);
            }
        }
        if(e.getSource()==button2) {
            if (which == 1) {
                frame.dispose();
                Board1 board2 = new Board1(2, name,multiplayer);
            }
            if(which==2){
                frame.dispose();
                Board2 board2=new Board2(2, name,multiplayer);
            }
        }
    }
}

