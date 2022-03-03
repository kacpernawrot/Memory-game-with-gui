package pl.KacperNawrot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Login implements ActionListener {
    JFrame frame= new JFrame();
    JLabel label=new JLabel("Type your login and password");
    JLabel label2= new JLabel("Password");
    JLabel label1= new JLabel("Login");
    JTextField text1= new JTextField();
    JPasswordField text2=new JPasswordField();
    JButton button1= new JButton("Submit");
    JButton button2=new JButton("Go back");
    JButton button3= new JButton("Go next");
    JLabel label3=new JLabel();
    Login(){
        label1.setBounds(130,200,50,20);
        label2.setBounds(110,230,80,20);
        text1.setBounds(200,200,100,20);
        text2.setBounds(200,230,100,20);
        button1.setBounds(200,280, 100, 20);
        button2.setBounds(200,310,100,20);
        label.setBounds(160,150,200,20);
        button2.addActionListener(this);
        button3.addActionListener(this);
        frame.add(button2);
        frame.add(label1);
        frame.add(label2);
        frame.add(label);
        frame.add(text1);
        frame.add(text2);
        frame.add(button1);
        button1.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label3);
        frame.add(button3);


  }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1)
        {
            if(check(text1.getText(),String.valueOf(text2.getPassword()))==true){
                label3.setText("You are logged");
                label3.setBounds(200,100,200,20);
                button3.setBounds(200,340,100,20);
                 }
            else{
                label3.setText("Invalid username or password");
                label3.setBounds(160,100,200,20);
                }
            //frame.dispose();
        }
        if(e.getSource()==button2){
            frame.dispose();
            new Logorreg();
        }
        if(e.getSource()==button3){
            frame.dispose();
            new Menu(text1.getText());
        }

    }
    public boolean check(String var1,String var2 ){
        String var=var1+" "+var2;
        try {
            File plik=new File("src/Login.txt");
            Scanner read1= new Scanner(plik);
            while(read1.hasNextLine()){
                String data=read1.nextLine();
                if(data.equals(var)) {
                    read1.close();
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return false;
    }
}
