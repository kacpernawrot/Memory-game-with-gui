package pl.KacperNawrot;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.exit;

public class test {
    static Timer timer = new Timer();
    int i=0;
    test(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Board1.czas.setText("Time played: "+i);
                Board2.czas.setText("Time played: "+i);
                i++;
            }
        },0,1000);
    }
}
