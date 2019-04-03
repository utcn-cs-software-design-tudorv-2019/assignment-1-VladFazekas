package sample.database;

public class StudentQueries {

    public String getStudentInfoById(String id){
        return "select * from student where id=" + id + ";";
    }

    public String getAddEnrolment(String id, String classs){
        return "update student set materii='"+classs+"' where id=" + id + ";";
    }

    public String getUpdateInfoById(String id, String cnp, String name, String adress) {
        return "update student set cnp='"+cnp+"', nume='"+name+"', address='"+adress+"' where id=" + id + ";";
    }

    public String getAddStudInfoById(String id, String text, String text1) {
        return "update student set icn='"+text+"', grupa='"+text1+"' where id=" + id + ";";
    }

    public String getDeleteStudInfoById(String id) {
        return "update student set icn='0', grupa='0', materii='' where id=" + id + ";";
    }

    public String getUpdateStudInfoById(String id, String text, String text1) {
        return "update student set icn='"+text+"', grupa='"+text1+"' where id=" + id + ";";
    }
}
