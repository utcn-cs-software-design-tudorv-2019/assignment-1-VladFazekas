package sample.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entity.Exam;
import sample.entity.Profesor;
import sample.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAL {

    DatabaseConnection database = new DatabaseConnection();
    TeacherQueries teacherQueries = new TeacherQueries();
    String query = null;

    public List<Student> getStudentTableData() {

        query = teacherQueries.getAllStudents();
        ResultSet result = database.getResultByStatement(query);
        List<Student> studentList = new ArrayList<>();
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
        return studentList;
    }

    public Profesor getTeacherInfoById(int id) {

        query = teacherQueries.getTeacherInfoById(String.valueOf(id));
        ResultSet result = database.getResultByStatement(query);
        List<Profesor> professors = new ArrayList<>();
        try {
            result.next();
            return new Profesor(Integer.parseInt(result.getObject(1).toString()),result.getObject(2).toString(),result.getObject(3).toString());
        }catch(SQLException e){
            return null;
        }
    }


    public List<Exam> getExamTableData(String numestudent, String data1, String data2) {

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
            return examList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void gradeExam(String name, String numematerie, String nota, String data) {

        String query = teacherQueries.insertExam(name,numematerie,nota,data);
        database.executeStatement(query);
    }
}
