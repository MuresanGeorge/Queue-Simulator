import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by George on 4/8/2017.
 */
public class Decriptor {

    public static int stoi(String s1)
    {
        try
        {
            int rez=Integer.parseInt(s1);

            return rez;

        }

        catch( NumberFormatException e)
        {
            System.out.println("aloooooooooooooo..... date incorecte");
            System.exit(1);

        }
        return -1;
    }

    public static void metoda(String timpsosiree,String timpstatlacasamaxx,String timpstatlacasaminn,String nrcasee,String nrclientii ) throws IOException {
        int timpsosire=stoi(timpsosiree);

        int timpstatlacasamax=stoi(timpstatlacasamaxx);
        int timpstatlacasamin=stoi(timpstatlacasaminn);

        int nrcase=stoi(nrcasee);
        int nrclienti=stoi(nrclientii);

        Interfata interfata = new Interfata(nrcase);
        CURtime tc=new CURtime();

        Simulare s1=new Simulare("SIMULATOR",timpsosire,timpstatlacasamin,timpstatlacasamax,nrcase,nrclienti,interfata,tc);
        s1.start();

    }

}
