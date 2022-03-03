package pl.KacperNawrot;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Register implements ActionListener {
    JFrame frame= new JFrame();
    JLabel label=new JLabel("Creat account");
    JLabel label3= new JLabel("Again Password");
    JLabel label2= new JLabel("Password");
    JLabel label1= new JLabel("Login");
    JLabel label4= new JLabel();
    JTextField text1= new JTextField();
    JPasswordField text2= new JPasswordField();
    JPasswordField text3= new JPasswordField();
    JButton button1= new JButton("Submit");
    JButton button2= new JButton("Go back");
    JButton button3= new JButton("Go next");
    Register(){
        label1.setBounds(160,180,50,20);
        label2.setBounds(136,210,80,20);
        label3.setBounds(104,240,140,20);
        text1.setBounds(200,180,100,20);
        text2.setBounds(200,210,100,20);
        text3.setBounds(200,240,100,20);
        button1.setBounds(200,270, 100, 20);
        button2.setBounds(200,300,100,20);
        button2.addActionListener(this);
        button3.addActionListener(this);
        label.setBounds(210,130,200,20);
        frame.add(button2);
        frame.add(label3);
        frame.add(label1);
        frame.add(label2);
        frame.add(label);
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(button1);
        frame.add(label4);
        button1.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button3);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1)
        {
            if(String.valueOf(text2.getPassword()).equals(String.valueOf(text3.getPassword()))){
                check(text1.getText(),String.valueOf(text2.getPassword()));}
            else{
                label4.setText("Passwords aren't the same");
                label4.setBounds(170,100,200,20); }
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



    public void check(String var1,String var2){
        String var=var1+" "+var2;
        int pom=0;
        try {
            File plik=new File("src/Login.txt");
            Scanner read1= new Scanner(plik);
            while(read1.hasNextLine()){
                String data=read1.nextLine();
                String[] dane=data.split(" ");
                if(dane[0].equals(var1)){
                    pom=1;
                }
            }
            if(pom==1){
                label4.setText("Login is taken");
                label4.setBounds(210,100,200,20);
            }
            else{
                try {
                    FileWriter writer= new FileWriter(plik,true);
                    var="\n"+var;
                    writer.write(var);
                    writer.close();
                    label4.setText("successfully registered ");
                    button3.setBounds(200,330,100,20);
                    label4.setBounds(190,100,200,20);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
