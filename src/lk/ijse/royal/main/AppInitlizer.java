package lk.ijse.royal.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitlizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource( "../view/StudentForm.fxml"));
        Scene scene=new Scene(root, Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.DECORATED);
        //title Icon Change
        primaryStage.getIcons().add( new Image(getClass().getResourceAsStream("../resource/icon1.png")));

        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
