package lk.ijse.royal.otherUtil;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

//Singilton design Pattern
public class GoNextWindow {
    private static GoNextWindow window;

    private GoNextWindow(){}

    public void makeWindow(ActionEvent event, String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));

        FadeTransition tempTransition = new FadeTransition(Duration.millis(3500),root);
        tempTransition.setFromValue(0.0);
        tempTransition.setToValue(1.0);
        tempTransition.play();

        Scene scene = new Scene(root);
        Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainStage.setScene(scene);
        mainStage.centerOnScreen();
        mainStage.show();
    }//CLOSE

    public static GoNextWindow getWindow(){
        if (window==null) {
            window = new GoNextWindow();
        }
        return window;
    }
}
