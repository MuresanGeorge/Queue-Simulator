import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sun.util.resources.cldr.ro.CalendarData_ro_RO;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class Main extends Application {
    private Stage primaryStage;
    CURtime obiect=new CURtime();
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Run.fxml"));
        Parent root = loader.load();
        ControllerRun ctrlRun = loader.getController();
        ctrlRun.setm1(this);

        this.primaryStage.setTitle("hhhhhhhh");
        this.primaryStage.setScene(new Scene(root, 600, 400));
        this.primaryStage.show();
        obiect.ceas();



    }

    public void closePrimaryStage() {
        this.primaryStage.close();
    }

    public static void main(String[] args) {

        launch(args);


    }


}
