package lk.ijse.royal.controller.commonCon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public interface CommonFunction {
    @FXML
    void saveButtonAction(ActionEvent event) throws Exception;
    @FXML
    void updateButtonAction(ActionEvent event) throws Exception;
    @FXML
    void deleteButtonAction(ActionEvent event) throws Exception;
    @FXML
    void searchKeypressAction(KeyEvent event) throws Exception;
    @FXML
    void clearAllTextfield(ActionEvent event) throws Exception;
    //
    public void customizeTable() throws Exception;

    public void loadTable() throws Exception;

}
