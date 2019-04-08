package sample.business;

import sample.database.DatabaseConnection;
import sample.database.StudentDAL;
import sample.database.StudentQueries;
import sample.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class StudentLogic {

    StudentDAL studentDAL = new StudentDAL();

    public Student getStudentInfo(int id){
        return studentDAL.getStudentInfo(id == 0 ? 1 : id);
    }

    public void enroll(int id, String classs) throws IllegalArgumentException{
        studentDAL.enroll(id, classs);
    }

    public void updateInfo(int id, String cnp, String name, String adress) {
        studentDAL.updateInfo(id, cnp, name, adress);
    }

    public void addStudInfo(int id, String text, String text1) {
        studentDAL.addStudInfo(id, text, text1);
    }

    public void deleteStudInfo(int id) {
        studentDAL.deleteStudInfo(id);
    }

    public void updateStudInfo(int id, String text, String text1) {
        studentDAL.updateStudInfo(id, text, text1);
    }

    public List<String> parseList(String classes){
        return Arrays.asList(classes.split(","));
    }

}
