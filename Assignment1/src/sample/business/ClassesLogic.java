package sample.business;

import sample.database.ClassesQueries;
import sample.database.DatabaseConnection;

import java.sql.ResultSet;

public class ClassesLogic {

    DatabaseConnection database = new DatabaseConnection();
    String query = null;
    ClassesQueries c = new ClassesQueries();

    public ResultSet getClasses(){

        query = c.getClasses();
        ResultSet result = database.getResultByStatement(query);
        return result;
    }
}
