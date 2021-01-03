package lk.ijse.royal.controller.commonCon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.royal.otherUtil.GoNextWindow;

import java.io.IOException;

public class NavigationBarController {
    @FXML
    void navButtonCourseAction(ActionEvent event) throws IOException {
        GoNextWindow.getWindow().makeWindow(event,"../view/CourseForm.fxml");
    }

    @FXML
    void navButtonRegistrationAction(ActionEvent event) throws IOException {
        GoNextWindow.getWindow().makeWindow(event,"../view/RegistrationForm.fxml");
    }

    @FXML
    void navButtonStudentAction(ActionEvent event) throws IOException {
        GoNextWindow.getWindow().makeWindow(event,"../view/StudentForm.fxml");
    }
}
