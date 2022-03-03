package pl.KacperNawrot;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Save {
    File plik = new File("src/Stats.txt");
    File plik1 = new File("src/pom.txt");
    String player;
    Save(String player1 ){
        player=player1;
        try {
            Scanner read1= new Scanner(plik);
            plik1.delete();
            FileWriter writer1=new FileWriter(plik1,true);
            String var1=" ";
            int pom=0;
            while(read1.hasNextLine()){
                String data=read1.nextLine();
                String[] dane=data.split(" ");
                int var;
                if(dane[0].equals(player)){
                    var=Integer.parseInt(dane[1]);
                    var++;
                    var1="\n"+dane[0]+" "+var;
                    writer1.write(var1);
                    pom=1;
                }
                else
                {
                    var1="\n"+data;
                    writer1.write(var1);
                }
            }
            if(pom==0){
                var1="\n"+player1+" "+1;
                writer1.write(var1);
            }

            read1.close();
            writer1.close();
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        try {
            Scanner read2= new Scanner(plik1);
            FileWriter writer2= new FileWriter(plik);
            plik.delete();
            String data;
            read2.nextLine();
            int i=0;
            while(read2.hasNextLine()) {
                System.out.println(i);i++;
                data= read2.nextLine();
                System.out.println(data);
                data=data+"\n";
                writer2.write(data);
            }
            read2.close();
            writer2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    }

