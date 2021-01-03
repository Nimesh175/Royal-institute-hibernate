package lk.ijse.royal.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.royal.bo.BOFactory;
import lk.ijse.royal.bo.customBO.CourseBO;
import lk.ijse.royal.bo.customBO.StudentBO;
import lk.ijse.royal.controller.commonCon.CommonFunction;
import lk.ijse.royal.controller.commonCon.NavigationBarController;
import lk.ijse.royal.dao.DAOFactory;
import lk.ijse.royal.dao.crudDAO.customDAO.StudentDAO;
import lk.ijse.royal.dto.CourseDTO;
import lk.ijse.royal.dto.StudentDTO;
import lk.ijse.royal.entity.Student;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StudentFormController extends NavigationBarController implements CommonFunction, Initializable {
    //
    StudentBO bo= (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);
    //
    ObservableList<StudentDTO> data=null;
    //
    @Override
    public void saveButtonAction(ActionEvent event) throws Exception {
        String id=txtStudentID.getText();
        String name=txtStudentName.getText();
        String address=txtAddress.getText();
        String telephone=txtTelepone.getText();
        String dob= txtDOB.getText();
        String gender=rationMale.getText();
            if (rationFemale.isSelected()) gender=rationFemale.getText();
         //
        if (id!=null & name!=null & address!=null & telephone!=null & dob!=null & gender!=null)
        bo.save(new StudentDTO(id,name,address,telephone,dob,gender));
        //
        loadTable();
    }

    @Override
    public void updateButtonAction(ActionEvent event) throws Exception {
        String id=txtStudentID.getText();
        String name=txtStudentName.getText();
        String address=txtAddress.getText();
        String telephone=txtTelepone.getText();
        String dob= txtDOB.getText();
        String gender=rationMale.getText();
        if (rationFemale.isSelected()) gender=rationFemale.getText();
        //
        if (id!=null & name!=null & address!=null & telephone!=null & dob!=null & gender!=null)
        bo.update(new StudentDTO(id,name,address,telephone,dob,gender));
        //
        loadTable();

    }

    @Override
    public void deleteButtonAction(ActionEvent event) throws Exception {
        String id=txtStudentID.getText();
        if (id!=null) bo.delete(id);
        //
        loadTable();
    }

    @Override
    public void searchKeypressAction(KeyEvent event) throws Exception {

        StudentDTO c=null;
        String id=txtStudentID.getText();
        if (id!=null) c=bo.getEntity(id);

        if (c!=null){
            txtStudentName.setText(c.getStudentName());
            txtAddress.setText(c.getAddress());
            txtTelepone.setText(c.getAddress());
            txtDOB.setText(c.getDob());

            rationFemale.setSelected(true);
            if (c.getGender().equalsIgnoreCase("Male"))rationMale.setSelected(true);

        }
    }

    @Override
    public void clearAllTextfield(ActionEvent event) throws Exception {
        txtStudentID.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtDOB.clear();
        txtTelepone.clear();

        rationFemale.setSelected(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // 1
            customizeTable();
            // 2 default
            rationFemale.setSelected(true);
            // 3
            loadTable();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void customizeTable() throws Exception {
        columnSID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        columnTelepone.setCellValueFactory(new PropertyValueFactory<>("contact"));
        columnDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        columnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    @Override
    public void loadTable() throws Exception {
        data=FXCollections.observableArrayList();
        List<StudentDTO> arr=bo.getAll();

        for (StudentDTO c : arr) data.add(c);

        table.setItems(data);
    }

//  ==========================

    @FXML
    private JFXTextField txtStudentID;

    @FXML
    private JFXTextField txtStudentName;

    @FXML
    private JFXTextArea txtAddress;

    @FXML
    private JFXTextField txtTelepone;

    @FXML
    private JFXTextField txtDOB;

    @FXML
    private RadioButton rationFemale;

    @FXML
    private RadioButton rationMale;

    @FXML
    private TableView<StudentDTO> table;

    @FXML
    private TableColumn<StudentDTO, String> columnSID;

    @FXML
    private TableColumn<StudentDTO, String> columnName;

    @FXML
    private TableColumn<StudentDTO, String> columnAddress;

    @FXML
    private TableColumn<StudentDTO, String> columnTelepone;

    @FXML
    private TableColumn<StudentDTO, Date> columnDOB;

    @FXML
    private TableColumn<StudentDTO, String> columnGender;



}
