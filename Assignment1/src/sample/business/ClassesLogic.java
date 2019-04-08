package sample.business;

import sample.database.ClassDAL;
import sample.database.ClassesQueries;
import sample.database.DatabaseConnection;
import sample.entity.Materie;
import java.util.List;
import java.sql.ResultSet;

public class ClassesLogic {

    ClassDAL classDAL =  new ClassDAL();

    public List<Materie> getClasses(){
        return classDAL.getClasses();
    }
}
