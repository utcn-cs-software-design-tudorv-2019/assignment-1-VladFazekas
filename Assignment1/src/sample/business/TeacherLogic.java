package sample.business;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.DatabaseConnection;
import sample.database.TeacherQueries;
import sample.entity.Exam;
import sample.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherLogic {
    DatabaseConnection database = new DatabaseConnection();
    TeacherQueries teacherQueries = new TeacherQueries();
    String query = null;

    public ObservableList<Student> getStudentTableData() {

       query = teacherQueries.getAllStudents();
       ResultSet result = database.getResultByStatement(query);
       List<Student>  studentList = new ArrayList<>();
           try {
               while(result.next()) {
                   studentList.add(new Student(result.getObject(1).toString(),
                           result.getObject(2).toString(),
                   result.getObject(3).toString(),
                   result.getObject(4).toString(),
                   result.getObject(5).toString(),
                   result.getObject(6).toString(),
                   result.getObject(7).toString()));
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return FXCollections.observableArrayList(studentList);
    }

    public ResultSet getStudentInfo(int id) {

        query = teacherQueries.getTeacherInfoById(String.valueOf(id));
        ResultSet result = database.getResultByStatement(query);
        return result;
    }


    public ObservableList<Exam> getExamTableData(String numestudent, String data1, String data2) {

        query = teacherQueries.getExamTableData(numestudent,data1,data2);
        ResultSet result = database.getResultByStatement(query);
        List<Exam>  examList = new ArrayList<>();
        try {
            while(result.next()) {
                examList.add(new Exam(result.getObject(2).toString(),
                        result.getObject(3).toString(),
                        result.getObject(4).toString(),
                        result.getObject(5).toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(examList);
    }

    public void gradeExam(String name, String numematerie, String nota, String data) {

        String query = teacherQueries.insertExam(name,numematerie,nota,data);
        database.executeStatement(query);
    }
}
