import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ControllerRun {
    @FXML
    TextField timpsosire;
    @FXML
    TextField timpstatlacasamin;
    @FXML
    TextField timpstatlacasamax;
    @FXML
    TextField nrcase;
    @FXML
    TextField nrclienti;

   public Main m1;
    public void setm1(Main m1){
        this.m1 = m1;
    }

    public void metodagettext() throws IOException {
        String s1=timpsosire.getText();
        String s3=timpstatlacasamax.getText();
        String s32=timpstatlacasamin.getText();
        String s2322=nrcase.getText();
        String s22322=nrclienti.getText();
        Decriptor.metoda(s1,s3,s32,s2322,s22322);
        m1.closePrimaryStage();

    }
}
