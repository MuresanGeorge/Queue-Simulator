import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 4/8/2017.
 */
public class Simulare extends Thread {
    private List<Casa> listacase=new ArrayList<Casa>(100);
    private int timpsosire;
    private int timpstatlacasamin;
    private int timpstatlacasamax;
    private int nrcase;
    private int nrclienti;
    private Interfata interfata;
    private CURtime tc;



    public Simulare(String name, int timpsosire, int timpstatlacasamin,int timpstatlacasamax, int nrcase, int nrclienti,Interfata interfata,CURtime tc) {
        super(name);
        //this.listacase = listacase;
        this.timpsosire = timpsosire;
        this.timpstatlacasamin = timpstatlacasamin;
        this.timpstatlacasamax=timpstatlacasamax;
        this.nrcase = nrcase;
        this.nrclienti = nrclienti;
        this.interfata = interfata;
        this.tc=tc;
        for(int i=0;i<nrcase;i++)
        {
            Casa c1=new Casa("casa",interfata,tc,i);
            listacase.add(c1);
            c1.start();
        }
    }


    private int deciziamea()
    {
        int min;
        min=listacase.get(0).lungimecoada();
        int poz=0;
        for(int i=1;i<nrcase;i++)
        {
             int lungime=listacase.get(i).lungimecoada();
            if(lungime<min) {
                min = lungime;
                poz=i;
            }
        }
        return poz;//retin pozitia unde am cea mai scurta coada
    }

    public void run()
    {
        try
        {
            int i=0;
            while(i<nrclienti)
            {
                int cpoz=deciziamea();
                i++;

                Client cl=new Client();
                cl.setNrc(i);
                cl.setTimp(cl.randomTime(timpstatlacasamin,timpstatlacasamax));
                cl.setTimpsosire(cl.randomTime(timpsosire,timpsosire));
                cl.setTimpplecare(-1);
                //for(int j=0;j<cl.getTimp();j++)
                   // tc.ceas();
                System.out.println();
                System.out.println("Clientul "+cl.getNrc()+" a fost adaugat la casa "+Integer.toString(cpoz)+" si sta "+cl.getTimp()+" secunde");
                interfata.init("Clientul "+cl.getNrc()+" a fost adaugat la casa "+Integer.toString(cpoz)+" si sta "+cl.getTimp()+" secunde");
                interfata.checkCase(cpoz);
               // tc.ceas();
                //String s=tc.ceas();
               // interfata.init(s);

               // System.out.println("Clientul "+cl.getNrc()+" sta la casa "+cl.getTimp()+" secunde");
                //interfata.init("Clientul "+cl.getNrc()+" sta la casa "+cl.getTimp()+" secunde");

               // interfata.init(metodasec("secunde"));
                //metodasec("secunde");



                //System.out.println();

                listacase.get(cpoz).adaugaclientinlista(cl);
                sleep(cl.getTimpsosire()*1000);


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
       }

        interfata.stopCase();
    }
}
