package lk.ijse.royal.controller;

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
import lk.ijse.royal.bo.customBO.RegistrationBO;
import lk.ijse.royal.bo.customBO.StudentBO;
import lk.ijse.royal.controller.commonCon.CommonFunction;
import lk.ijse.royal.controller.commonCon.NavigationBarController;
import lk.ijse.royal.dto.CourseDTO;
import lk.ijse.royal.dto.RegistrationDTO;
import lk.ijse.royal.dto.StudentDTO;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

import static java.time.LocalDateTime.now;

public class RegistrationFormController extends NavigationBarController implements CommonFunction, Initializable {
    //
    RegistrationBO bo= (RegistrationBO) BOFactory.getInstance().getBO(BOFactory.BOType.REGISTRAITION);
    //
    CourseBO cbo= (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOType.COURSE);
    //
    StudentBO sbo= (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);
    //
    ObservableList<RegistrationDTO> data=null;
    //

    @Override
    public void saveButtonAction(ActionEvent event) throws Exception {
        int regID = Integer.parseInt(txtRegID.getText());
        double regFee = Double.parseDouble(txtRegFee.getText());
        String sid =txtStudentID.getText();
        String cid =txtCourseID.getText();
        String cName =txtCourseName.getText();
        String sName =txtStudentName.getText();
        String regDate=LocalDateTime.now().toString();

        bo.save(new RegistrationDTO(regID,regDate,regFee,sid,sName,cid,cName));
        //
        loadTable();
    }

    @Override
    public void updateButtonAction(ActionEvent event) throws Exception {
        int regID = Integer.parseInt(txtRegID.getText());
        double regFee = Double.parseDouble(txtRegFee.getText());
        String sid =txtStudentID.getText();
        String cid =txtCourseID.getText();
        String cName =txtCourseName.getText();
        String sName =txtStudentName.getText();

        bo.update(new RegistrationDTO(regID,regFee,sid,sName,cid,cName));
        //
        loadTable();
    }

    @Override
    public void deleteButtonAction(ActionEvent event) throws Exception {
        bo.delete(txtRegID.getText());
        //
        loadTable();
    }

    @Override//find Registration by registration ID
    public void searchKeypressAction(KeyEvent event) throws Exception {
        RegistrationDTO c=null;
        if (!txtRegID.getText().equalsIgnoreCase("")) c = bo.getEntity(txtRegID.getText());
        if (c!=null){
           txtRegFee.setText(Double.toString(c.getRegFree()));
           txtStudentID.setText(c.getStudentId());
           txtStudentName.setText(c.getStudentName());
           txtCourseID.setText(c.getCourseCode());
           txtCourseName.setText(c.getCourseName());
        }
    }

    @Override
    public void clearAllTextfield(ActionEvent event) throws Exception {
        txtRegID.clear();
        txtRegFee.clear();
        txtStudentID.clear();
        txtCourseID.clear();
        txtCourseName.clear();
        txtStudentName.clear();
    }

    @Override
    public void customizeTable() throws Exception {
        columRegID.setCellValueFactory(new PropertyValueFactory<>("regNo"));
        columRegFee.setCellValueFactory(new PropertyValueFactory<>("regFree"));
        columStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        columnStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        columnCourseID.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        columnCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
    }

    @Override
    public void loadTable() throws Exception {
        data= FXCollections.observableArrayList();
        List<RegistrationDTO> arr=bo.getAll();

        for (RegistrationDTO c : arr) {
            data.add(c);
        }
        table.setItems(data);
    }

    //find Student By StudentID
    @FXML
    void studentSearchKeypressAction(KeyEvent event) throws Exception {
        StudentDTO c=null;
        if (!txtStudentID.getText().equals(null))c= sbo.getEntity(txtStudentID.getText());
        if (c!=null){
            txtStudentName.setText(c.getStudentName());
        }
    }


    //find Course By CourseCode
    @FXML
    void courseSearchKeypressAction(KeyEvent event) throws Exception {
        CourseDTO c=null;
        if (!txtCourseID.getText().equals(null))c=cbo.getEntity(txtCourseID.getText());
        if (c!=null){
            txtCourseName.setText(c.getCourseName().concat("  -  ( "+c.getCourseType()+" )"));
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // 1
            customizeTable();
            // 2
            loadTable();
            // 3


        } catch (Exception ex) {
            System.out.println("ex = " + ex);
            ex.printStackTrace();
        }
    }

//  ==========================

    @FXML
    private JFXTextField txtStudentID;

    @FXML
    private JFXTextField txtStudentName;

    @FXML
    private JFXTextField txtCourseID;

    @FXML
    private JFXTextField txtCourseName;

    @FXML
    private JFXTextField txtRegID;

    @FXML
    private JFXTextField txtRegFee;

    @FXML
    private TableView<RegistrationDTO> table;

    @FXML
    private TableColumn<RegistrationDTO, String> columRegID;

    @FXML
    private TableColumn<RegistrationDTO, Double> columRegFee;

    @FXML
    private TableColumn<RegistrationDTO, String> columStudentID;

    @FXML
    private TableColumn<RegistrationDTO, String> columnStudentName;

    @FXML
    private TableColumn<RegistrationDTO, String> columnCourseID;

    @FXML
    private TableColumn<RegistrationDTO, String> columnCourseName;

}
