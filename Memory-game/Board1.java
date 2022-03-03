package pl.KacperNawrot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.TimerTask;

public class Board1 implements ActionListener {
    static int koniec=1;
    int which=0,ile=1,multiplayer;
    ImageIcon icon1 = new ImageIcon("src/Obrazki1/obrazek1.png");
    ImageIcon icon2 = new ImageIcon("src/Obrazki1/obrazek2.png");
    ImageIcon icon3 = new ImageIcon("src/Obrazki1/obrazek3.png");
    ImageIcon icon4 = new ImageIcon("src/Obrazki1/obrazek4.png");
    ImageIcon icon5 = new ImageIcon("src/Obrazki1/obrazek5.png");
    ImageIcon icon6 = new ImageIcon("src/Obrazki1/obrazek6.png");
    ImageIcon icon7 = new ImageIcon("src/Obrazki1/obrazek7.png");
    ImageIcon icon8 = new ImageIcon("src/Obrazki1/obrazek8.png");
    ImageIcon icon10 = new ImageIcon("src/Obrazki2/obrazek1.png");
    ImageIcon icon20 = new ImageIcon("src/Obrazki2/obrazek2.png");
    ImageIcon icon30 = new ImageIcon("src/Obrazki2/obrazek3.png");
    ImageIcon icon40 = new ImageIcon("src/Obrazki2/obrazek4.png");
    ImageIcon icon50 = new ImageIcon("src/Obrazki2/obrazek5.png");
    ImageIcon icon60 = new ImageIcon("src/Obrazki2/obrazek6.png");
    ImageIcon icon70 = new ImageIcon("src/Obrazki2/obrazek7.png");
    ImageIcon icon80 = new ImageIcon("src/Obrazki2/obrazek8.png");
    ImageIcon icons[]= new ImageIcon[8];
    ImageIcon icons1[]=new ImageIcon[8];
    JPanel panel= new JPanel();
    JFrame frame= new JFrame();
    JPanel panel2=new JPanel();
    JLabel label1= new JLabel("Turn of:");
    JLabel label2= new JLabel("Player1");
    JButton newgame=new JButton("New Game");
    JLabel player1= new JLabel("Player1 points are: 0");
    JLabel player2= new JLabel("Player2 points are: 0");
    static JLabel czas=new JLabel("Time played: 0");
    JButton button1 = new JButton("PLAYER 1");
    JButton button2 = new JButton("PLAYER 2");
    Card[] gamebtn=new Card[16];
    int indexes[]=new int[16];
    Random random= new Random();
    Timer myTimer,myTimer1,myTimer2,myTimer3,myTimer4;
    long begin,end;
    int start=0;
    int pom=0,pom1=0,x = 0,moves=0,y=0;
    String name;
    test tes;
    String winner;

    Board1(int which, String name, int multiplayer) {
        this.name=name;
        this.multiplayer=multiplayer;
        label2.setText(name);
        player1.setText(name+" points are: 0");
        myTimer1 =new Timer(500, new TimerListener1());
        myTimer2= new Timer(1500,new TimerListener2());
        myTimer3= new Timer(1000,new TimerListener3());
        this.which=which;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,540);
        frame.setLayout(null);
        panel.setBounds(0,0,500,500);
        panel2.setBounds(500,0,200,540);//X:500-700 Y:0-540;
        label1.setBounds(40,150,60,20);
        label2.setBounds(100,150,60,20);
        player1.setBounds(30,200,200,20);
        player2.setBounds(30,250,200,20);
        czas.setBounds(45,70,200,20);
        newgame.setBounds(40,300,100,20);
        newgame.addActionListener(this);
        panel2.setLayout(null);
        panel2.add(newgame);
        panel2.add(label1);
        panel2.add(label2);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel2.add(player1);
        panel2.add(player2);
        panel2.add(czas);
        button1.setSize(30,30);
        button2.setSize(30,30);
        frame.add(panel);
        frame.add(panel2);
        frame.setVisible(true);
        icons1[0]=icon10;
        icons1[1]=icon20;
        icons1[2]=icon30;
        icons1[3]=icon40;
        icons1[4]=icon50;
        icons1[5]=icon60;
        icons1[6]=icon70;
        icons1[7]=icon80;
        icons[0]=icon1;
        icons[1]=icon2;
        icons[2]=icon3;
        icons[3]=icon4;
        icons[4]=icon5;
        icons[5]=icon6;
        icons[6]=icon7;
        icons[7]=icon8;

        for(int i=0; i<16;i++)
        {
            indexes[i]=-1;
        }
        for(int i=0; i<16;i++){
            gamebtn[i]=new Card();
            gamebtn[i].num=i%8;
            gamebtn[i].button1.setSize(30,30);
            gamebtn[i].button1.addActionListener(this);
        }
        Collections.shuffle(Arrays.asList(gamebtn));
        for(int i=0; i<16;i++){
            panel.add(gamebtn[i].button1);
        }
    }
    public int clicks=0;
    int index1 = 0;
    int index2 = 0;



    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gamebtn[index1].button1.setIcon(null);
            gamebtn[index2].button1.setIcon(null);
            myTimer.stop();
        }
    }
    public class TimerListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            player=2;
            myTimer1.stop();
        }
    }
    public class TimerListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //myTimer.stop();
            System.out.print("x ");System.out.println(x);
            System.out.print("y ");System.out.println(y);
            System.out.println("-------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            gamebtn[x].button1.setIcon(null);
            gamebtn[y].button1.setIcon(null);
            player=1;
            myTimer2.stop();
        }
    }
    public class TimerListener3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(which==2){
                gamebtn[x].button1.setIcon(icons[gamebtn[x].num]);
                gamebtn[y].button1.setIcon(icons[gamebtn[y].num]);}
            if(which==1){
                gamebtn[x].button1.setIcon(icons1[gamebtn[x].num]);
                gamebtn[y].button1.setIcon(icons1[gamebtn[y].num]);}
            myTimer3.stop();
        }
    }
    public class TimerListener4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            {
                pointsplayer2++;
                player2.setText("Computer points are: " + pointsplayer2);
                player=2;
                myTimer4.stop();
            }
        }
    }


    int player=1;
    int pointsplayer1=0;
    int pointsplayer2=0;
    int pola=8;
    int z=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        myTimer = new Timer(500, new TimerListener());
        clicks++;
        if(e.getSource()==newgame){
            frame.dispose();
            koniec=0;
            new Menu(name);
        }
        for (int i = 0; i < 16; i++) {
            if(myTimer.isRunning()){return;}
            if (e.getSource() == gamebtn[i].button1) {
                if(which==1)gamebtn[i].button1.setIcon(icons1[gamebtn[i].num]);
                if(which==2)gamebtn[i].button1.setIcon(icons[gamebtn[i].num]);
                index1 = i;
                if(multiplayer==1){
                    if(z==0){
                        tes=new test();
                        z=1;}
                    checkwin();}
                if(multiplayer==2) {
                    if(z==0){
                        tes=new test();
                        z=1;}
                    Computerwin();}
            }
            }

    }
    public void checkwin(){
        //new test();
        if(pola!=0 ) {
            if (clicks % 2 == 0) {
                if (index1 == index2) {
                    clicks--;
                    return;
                }
                if (gamebtn[index1].num != gamebtn[index2].num) {
                    myTimer.start();
                    if (player == 1) {player = 2; label2.setText("player 2");}
                    else {player = 1; label2.setText(name);}
                }
                if (gamebtn[index1].num == gamebtn[index2].num) {
                    if (player == 1) {
                        pointsplayer1++;
                        player1.setText((name + " points are: "+pointsplayer1));}
                    else {pointsplayer2++;player2.setText("Player2 points are: "+pointsplayer2);}
                    if(pola==1){
                        koniec=0;
                        koniec=1;
                        if(pointsplayer1>pointsplayer2) { frame.dispose(); Wynik wynik=new Wynik(1,name);winner=name; }
                        if(pointsplayer2>pointsplayer1) { frame.dispose(); Wynik wynik=new Wynik(2,name);winner="player2"; }
                        if(pointsplayer1==pointsplayer2){ frame.dispose(); Wynik wynik=new Wynik(3,name);winner="remis";}
                    }
                    pola--;
                    gamebtn[index1].button1.getDisabledIcon();
                    gamebtn[index2].button1.getDisabledIcon();
                }
            } else index2 = index1;
        }
    }

    public void Computerwin() {
        if (pola!=0 ) {
            if(player==1){
                if (clicks % 2 == 0) {
                    if (index1 == index2) {
                        clicks--;
                        return;
                    }
                    if (gamebtn[index1].num != gamebtn[index2].num) {
                        myTimer.start();
                        label2.setText("Computer");
                        //myTimer1.start();
                        player=2;
                    }
                    if (gamebtn[index1].num == gamebtn[index2].num) {
                        indexes[index1]=0;
                        indexes[index2]=0;
                        if (player == 1) {
                            pointsplayer1++;
                            player1.setText((name + " points are: "+pointsplayer1));}
                        //else {pointsplayer2++;player2.setText("Computer points are: "+pointsplayer2);}
                        if(pola==1) {
                            end=System.currentTimeMillis();
                            System.out.println((end-begin)/1000);
                            if(pointsplayer1>pointsplayer2) { frame.dispose(); Wynik wynik=new Wynik(1,name); }
                            if(pointsplayer2>pointsplayer1) { frame.dispose(); Wynik wynik=new Wynik(2,name);winner="player2"; }
                            if(pointsplayer1==pointsplayer2){ frame.dispose(); Wynik wynik=new Wynik(3,name);winner="draw"; }
                        }
                        pola--;
                        gamebtn[index1].button1.getDisabledIcon();
                        gamebtn[index2].button1.getDisabledIcon();
                    }
                } else index2 = index1;
            }
        if (player==2) {
            while(ile==1){
                x=0;
                y=0;
                while(pom==0){
                    x=random.nextInt(16);
                    if(indexes[x]==-1) pom=1; }
                pom=0;
                while(pom1==0){
                    y=random.nextInt(16);
                    if(indexes[y]==-1 && x!=y) pom1=1; }
                pom1=0;//losowanie pól
                System.out.print("x= ");System.out.println(x);
                System.out.print("y= ");System.out.println(y);
                System.out.print("x.num= ");System.out.println(gamebtn[x].num);
                System.out.print("y.num= ");System.out.println(gamebtn[y].num);
                myTimer3.start();
                if(player==2) {
                    if (gamebtn[x].num != gamebtn[y].num) {
                            myTimer2.start();
                            label2.setText(name);
                            ile=0;}
                    }
                    if (gamebtn[x].num == gamebtn[y].num) {
                        //myTimer4.start();
                        indexes[x] = 0;
                        indexes[y] = 0;
                        player=0;

                        if(player==2){
                            pointsplayer2++;
                            player2.setText("Computer points are: " + pointsplayer2);
                        }
                        if (pola == 0) {
                            ile=0;
                            if (pointsplayer1 > pointsplayer2) {
                                frame.dispose();
                                Wynik wynik = new Wynik(1,name);
                            }
                            if (pointsplayer2 > pointsplayer1) {
                                frame.dispose();
                                Wynik wynik = new Wynik(2,name);
                            }
                            if (pointsplayer1 == pointsplayer2) {
                                frame.dispose();
                                Wynik wynik = new Wynik(3,name);
                            }
                        }
                        pola--;
                        gamebtn[x].button1.getDisabledIcon();
                        gamebtn[y].button1.getDisabledIcon();
                    }
                }

            }ile=1;}}


    }






