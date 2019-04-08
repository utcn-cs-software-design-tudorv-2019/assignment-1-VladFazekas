package sample.business;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.DatabaseConnection;
import sample.database.TeacherDAL;
import sample.database.TeacherQueries;
import sample.entity.Exam;
import sample.entity.Profesor;
import sample.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherLogic {

    TeacherDAL teacherDAL = new TeacherDAL();

    public List<Student> getStudentTableData() {
        return teacherDAL.getStudentTableData();
    }

    public Profesor getTeacherInfoById(int id) {
        return teacherDAL.getTeacherInfoById(id == 0 ? 1 : id);
    }


    public List<Exam> getExamTableData(String numestudent, String data1, String data2) {
        return teacherDAL.getExamTableData(numestudent, data1, data2);
    }

    public void gradeExam(String name, String numematerie, String nota, String data) {
        teacherDAL.gradeExam(name, numematerie, nota, data);
    }
}
