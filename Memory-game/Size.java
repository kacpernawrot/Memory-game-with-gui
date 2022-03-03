package pl.KacperNawrot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Size implements ActionListener {
    int multiplayer;
    JFrame frame= new JFrame();
    JLabel label= new JLabel("Choose the size");
    JButton button1= new JButton("4x4");
    JButton button2= new JButton("5x6");
    String name;
    Size(String name,int multiplayer){
        this.multiplayer=multiplayer;
        this.name=name;
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
            frame.dispose();
            ChooseCards choosecards= new ChooseCards(1,name,multiplayer);
        }
        if(e.getSource()==button2){
            frame.dispose();
            ChooseCards chooseCards= new ChooseCards(2,name,multiplayer);
        }
    }
}
