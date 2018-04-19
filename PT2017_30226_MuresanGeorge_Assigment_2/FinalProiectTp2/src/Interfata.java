
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


public class Interfata {
    private Stage stage;
    private TextArea inputArea;
    private Scene scene;
    private VBox layout;
    private TextArea ceas;

    public Interfata(Integer nrcase) throws MalformedURLException {

        stage = new Stage();
        stage.setTitle("Simulare");
        inputArea = new TextArea();

        inputArea.setText("-------------------Chestii de afisat---------------");
        layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(inputArea);

        for (int i = 0; i < nrcase; i++) {



            Label text = new Label();
            text.setText("Casa " + String.valueOf(i));

            Image image = new Image("bar3.gif");
            ImageView img = new ImageView();
            img.setId(String.valueOf(i));
            img.setImage(image);


            layout.getChildren().add(img);
            layout.getChildren().add(text);
        }
         stopCase();

       /* ceas=new TextArea();
        ceas.setText("-------------------ceas---------------");
        layout = new VBox(10);
        layout.setPadding(new Insets(40, 40, 40, 40));
        layout.getChildren().addAll(ceas);*/

        scene = new Scene(layout, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    public void init(String s) {
        this.inputArea.appendText("\n" + s);

    }

    public void checkCase(Integer x) {

        for (Node node : layout.getChildren()) {
            if (!node.toString().contains("TextArea") && !node.toString().contains("Label")) {
                if (node.getId().equals(String.valueOf(x))) {
                    node.setVisible(true);
                }
                //else
                   // node.setVisible(false);
            }

        }


    }

    public void stopCasa(Integer x){
        for (Node node : layout.getChildren()) {
            if (!node.toString().contains("TextArea") && !node.toString().contains("Label")) {
                if (node.getId().equals(String.valueOf(x)))
                    node.setVisible(false);

            }

        }
    }

    public void stopCase() {
        for (Node node : layout.getChildren()) {
            if (!node.toString().contains("TextArea") && !node.toString().contains("Label")) {
                node.setVisible(false);
            }
        }

    }
}
