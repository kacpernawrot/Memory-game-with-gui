package pl.KacperNawrot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wynik implements ActionListener {
    String name;
    int which;
    JFrame frame= new JFrame();
    JLabel label= new JLabel("THE WINNER IS:");
    JLabel player=new JLabel();
    JButton button=new JButton("NEW GAME");
    Wynik(int which1,String name){
        this.name=name;
        this.which=which1;
        label.setBounds(185,120,150,20);
        player.setBounds(205,140,150,20);
        button.setBounds(165,180,150,20);
        button.addActionListener(this);
        frame.add(button);
        frame.add(player);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        if(this.which==1){player.setText(name);new Save(name);}
        else if(this.which==2) player.setText("PLAYER2");
        else player.setText("DRAW");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button)  {frame.dispose();new Menu(name);}

    }
}
