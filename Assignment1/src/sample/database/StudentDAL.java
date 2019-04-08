package sample.database;

import sample.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDAL {


    DatabaseConnection database = new DatabaseConnection();
    StudentQueries studentQueries = new StudentQueries();
    String query = null;

    public Student getStudentInfo(int id){

        query = studentQueries.getStudentInfoById(String.valueOf(id));
        ResultSet result = database.getResultByStatement(query);
        try {
            result.next();
            return new Student(result.getObject(1).toString(),
                    result.getObject(2).toString(),
                    result.getObject(3).toString(),
                    result.getObject(4).toString(),
                    result.getObject(5).toString(),
                    result.getObject(6).toString(),
                    result.getObject(7).toString());
        } catch (SQLException e){
            return null;
        }
    }


    public void enroll(int id, String classs) throws IllegalArgumentException{

        query = studentQueries.getStudentInfoById(String.valueOf(id));
        ResultSet result = database.getResultByStatement(query);


        try {
            result.next();
            List<String> classesList = this.parseList(result.getObject(6).toString());
            if (classesList.contains(classs)){
                throw new IllegalArgumentException();
            } else {
                database.executeStatement(studentQueries.getAddEnrolment(String.valueOf(id), result.getObject(6).toString()+","+classs));
            }
        } catch (SQLException e) {
        }


    }

    public List<String> parseList(String classes){
        return Arrays.asList(classes.split(","));
    }

    public void updateInfo(int id, String cnp, String name, String adress) {
        database.executeStatement(studentQueries.getUpdateInfoById(String.valueOf(id),cnp,name,adress));
    }

    public void addStudInfo(int id, String text, String text1) {
        database.executeStatement(studentQueries.getAddStudInfoById(String.valueOf(id),text,text1));
    }

    public void deleteStudInfo(int id) {
        database.executeStatement(studentQueries.getDeleteStudInfoById(String.valueOf(id)));
    }

    public void updateStudInfo(int id, String text, String text1) {
        database.executeStatement(studentQueries.getUpdateStudInfoById(String.valueOf(id),text,text1));
    }
}
