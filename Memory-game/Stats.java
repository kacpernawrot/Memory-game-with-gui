package pl.KacperNawrot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Stats implements ActionListener {
    File plik = new File("src/Stats.txt");
    String player;
    String[][] tab=new String[50][50];
    JFrame frame= new JFrame();
    JLabel label1= new JLabel("Top five players:");
    JLabel labels[]=new JLabel[5];
    JButton button=new JButton("MENU");
    int i=0;
    Stats(String player1 ) {
        for (int j = 0; j < 50; j++) {
            for (int k = 0; k < 50; k++) {
                tab[i][k] = "0";
            }
        }
        player = player1;
        try {
            Scanner read1 = new Scanner(plik);
            while (read1.hasNextLine()) {
                String data = read1.nextLine();
                String[] dane = data.split(" ");
                tab[i][0] = dane[0];
                tab[i][1] = dane[1];
                i++;
            }
            read1.close();
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        for (int i = 0; i < tab.length; i++) {
            //System.out.println(tab[i][0]+" "+tab[i][1]);
        }
        for (int i = 0; i < 9; i++) {
            for (int k = i + 1; k < 10; k++) {
                if(tab[k][0]!=null){
                    if (Integer.parseInt(tab[i][1])<(Integer.parseInt(tab[k][1]))) {
                        String temp = tab[i][0];
                        String temp2 = tab[i][1];
                        tab[i][0] = tab[k][0];
                        tab[i][1] = tab[k][1];
                        tab[k][0] = temp;
                        tab[k][1] = temp2;
                    }
            }}
        }
        for(int i=0;i< 10;i++){
            if(tab[i][0]!=null){
                System.out.println(tab[i][0]+" "+tab[i][1]);}
        }
        frame.setBounds(0,0,500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        label1.setBounds(185,100,100,20);
        frame.add(label1);
        JLabel player=new JLabel("Your stats");
        player.setBounds(190,300,100,20);
        frame.add(player);
        for(int i=0;i<5;i++){
            labels[i]=new JLabel(tab[i][0]+" "+tab[i][1]);
            labels[i].setBounds(200,130+i*30,100,20);
            frame.add(labels[i]);
        }
        int pom=-1;
        for(int i=0;i<tab.length;i++)
        {
            if(player1.equals(tab[i][0]))
            {
                pom=i;
            }
        }
        JLabel stats=new JLabel();
        if(pom!=-1){
            stats.setText(tab[pom][0]+" "+tab[pom][1]);
            stats.setBounds(190,330,200,20);
        }
        else{
            stats.setText("You haven't won any games");
            stats.setBounds(150,330,200,20);
        }
        frame.add(stats);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setBounds(174,400,100,20);
        button.addActionListener(this);
        frame.add(button);

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
            new Menu(player);
        }
    }
}