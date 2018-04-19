import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Thread.sleep;

/**
 * Created by George on 4/16/2017.
 */
public class CURtime {


    public void ceas()
    {
        Thread ceas=new Thread()
        {
        public void run() {
            try {
                for(;;) {
                    Calendar cal = new GregorianCalendar();
                    int sec = cal.get(Calendar.SECOND);
                    int min = cal.get(Calendar.MINUTE);
                    int ora = cal.get(Calendar.HOUR);
                    System.out.println("ora :" + ora + " " + min + " " + sec);
                    sleep(1000);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            };
            ceas.start();

    }
}
