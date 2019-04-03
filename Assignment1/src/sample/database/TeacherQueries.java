package sample.database;

public class TeacherQueries {

    public String getTeacherInfoById(String id) {
        return "select * from profesor where id="+ id +";";
    }

    public String getExamTableData(String numestudent, String data1, String data2) {
        return "select * from exam where numestudent ='"+numestudent+"' and dataexamen between '"+data1+"' and '"+data2+"';";
    }

    public String getAllStudents(){
        return "select * from student;";
    }

    public String insertExam(String name, String numematerie, String nota, String data) {
        return "insert into exam(`numematerie`,`numestudent`,`nota`,`dataexamen`) values " +
                "('"+numematerie+"','"+name+"','"+nota+"','"+data+"');";
    }
}
