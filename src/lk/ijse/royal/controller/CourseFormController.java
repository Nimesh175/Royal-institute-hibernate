package lk.ijse.royal.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.royal.bo.BOFactory;
import lk.ijse.royal.bo.customBO.CourseBO;
import lk.ijse.royal.controller.commonCon.CommonFunction;
import lk.ijse.royal.controller.commonCon.NavigationBarController;
import lk.ijse.royal.dto.CourseDTO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CourseFormController extends NavigationBarController implements CommonFunction, Initializable {
    //
    CourseBO bo= (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOType.COURSE);
    //
    ObservableList<CourseDTO> data=null;
    //
    @Override
    public void saveButtonAction(ActionEvent event) throws Exception {
        String id=txtCode.getText();
        String name=txtName.getText();
        String type=cmbCourseType.getValue();
        String duration=txtDuration.getText();

        if (!id.isEmpty()) bo.save(new CourseDTO(id,name,type,duration));
        //
        loadTable();
    }

    @Override
    public void updateButtonAction(ActionEvent event) throws Exception {
        String id=txtCode.getText();
        String name=txtName.getText();
        String type=cmbCourseType.getValue();
        String duration=txtDuration.getText();

        if (!id.isEmpty()) bo.update(new CourseDTO(id,name,type,duration));
        //
        loadTable();
    }

    @Override
    public void deleteButtonAction(ActionEvent event) throws Exception {
       if (!txtCode.getText().isEmpty()) bo.delete(txtCode.getText());
       //
         loadTable();
    }

    @Override
    public void searchKeypressAction(KeyEvent event) throws Exception {
        CourseDTO c=null;
        if (!txtCode.getText().equals(null))c=bo.getEntity(txtCode.getText());
        if (c!=null){
            txtName.setText(c.getCourseName());
            txtDuration.setText(c.getDuration());
            cmbCourseType.setValue(c.getCourseType());
        }

    }

    @Override
    public void clearAllTextfield(ActionEvent event) throws Exception {
        txtCode.clear();
        txtName.clear();
        cmbCourseType.setValue("");
        txtDuration.clear();
    }

    @Override
    public void customizeTable() throws Exception {
        columCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        columName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        columType.setCellValueFactory(new PropertyValueFactory<>("courseType"));
        columDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
    }

    @Override
    public void loadTable() throws Exception {
        data=FXCollections.observableArrayList();
        List<CourseDTO> arr=bo.getAll();

        for (CourseDTO c : arr) {
            data.add(c);
        }
        table.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> combo=FXCollections.observableArrayList("FULL-TIME","PART-TIME");
        cmbCourseType.setItems(combo);
        cmbCourseType.setValue(combo.get(0));

        try {
            //1
            customizeTable();
            //2
            loadTable();
            //3

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//  ==========================
    @FXML
    private JFXTextField txtCode;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private JFXComboBox<String> cmbCourseType;

    @FXML
    private TableView<CourseDTO> table;

    @FXML
    private TableColumn<CourseDTO, String> columCode;

    @FXML
    private TableColumn<CourseDTO, String> columName;

    @FXML
    private TableColumn<CourseDTO, String> columType;

    @FXML
    private TableColumn<CourseDTO, String> columDuration;
}
