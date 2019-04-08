package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.business.ClassesLogic;
import sample.business.TeacherLogic;
import sample.database.ClassDAL;
import sample.database.DatabaseConnection;
import sample.entity.Exam;
import sample.entity.Materie;
import sample.entity.Profesor;
import sample.entity.Student;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;


public class TeacherController {


    public TableView<Student> studentTable;
    public TextField teacherID;
    public TextField teacherName;
    public TextField teacherCNP;
    public TableColumn nume;
    public TableColumn cnp;
    public TableColumn icn;
    public TableColumn adress;
    public TableColumn materii;
    public TableColumn grupa;

    public TableView<Exam> examenTable;
    public TableColumn materie;
    public TableColumn student;
    public TableColumn nota;
    public TableColumn data;
    public Button generareButton;
    public DatePicker dateFrom;
    public DatePicker dateTo;
    public ComboBox comboMaterii;
    public DatePicker dataExamen;
    public TextField notaExamen;
    public Button gradeExam;
    @FXML
    Button logoutButton;

    private int id;
    private TeacherLogic teacherLogic;

    public void setId(int id){
        this.id = id;
    }
    
    ClassesLogic classesLogic = new ClassesLogic();

    public void handleLogoutClick(ActionEvent event) {
        System.out.println("Logout succesfull");
        Parent loginViewParent = null;
        try {
            loginViewParent = FXMLLoader.load(getClass().getResource("../gui/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.show();
    }

    public void initialize() {
        teacherLogic = new TeacherLogic();
        Profesor teacher = teacherLogic.getTeacherInfoById(id);

        teacherID.setText(String.valueOf(teacher.getId()));
        teacherName.setText(teacher.getNume());
        teacherCNP.setText(String.valueOf(teacher.getCnp()));

        nume.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        cnp.setCellValueFactory(new PropertyValueFactory<Student,String>("cnp"));
        icn.setCellValueFactory(new PropertyValueFactory<Student,String>("icn"));
        adress.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
        materii.setCellValueFactory(new PropertyValueFactory<Student,String>("materii"));
        grupa.setCellValueFactory(new PropertyValueFactory<Student,String>("grupa"));

        materie.setCellValueFactory(new PropertyValueFactory<Student,String>("numematerie"));
        student.setCellValueFactory(new PropertyValueFactory<Student,String>("numestudent"));
        nota.setCellValueFactory(new PropertyValueFactory<Student,String>("nota"));
        data.setCellValueFactory(new PropertyValueFactory<Student,String>("dataexamen"));

        ObservableList<Student> data = FXCollections.observableArrayList(teacherLogic.getStudentTableData());
        studentTable.setItems(data);

        ClassesLogic classesLogic = new ClassesLogic();
        List<Materie> classes2 = classesLogic.getClasses();
        comboMaterii.getItems().setAll(Collections.emptyList());
        comboMaterii.setPromptText("Select a class..");
        classes2.forEach(c-> comboMaterii.getItems().add(c.getNume()));

    }

    public void generateReport(ActionEvent event) {

        String pattern = "yyyy-MM-dd";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

        Student student = studentTable.getSelectionModel().getSelectedItem();
        ObservableList<Exam> data2 = FXCollections.observableArrayList(teacherLogic.getExamTableData(student.getName(),dateFormatter.format(dateFrom.getValue()), dateFormatter.format(dateTo.getValue())));
        examenTable.setItems(data2);
        examenTable.refresh();
    }

    public void gradeExam(ActionEvent event) {

        String pattern = "yyyy-MM-dd";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

        Student student = studentTable.getSelectionModel().getSelectedItem();
        teacherLogic.gradeExam(student.getName(),comboMaterii.getValue().toString(), String.valueOf(Integer.parseInt(notaExamen.getText().toString())),dateFormatter.format(dataExamen.getValue()));

    }
}
