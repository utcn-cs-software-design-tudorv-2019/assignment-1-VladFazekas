package sample.database;

import sample.entity.Materie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAL {

    DatabaseConnection database = new DatabaseConnection();
    String query = null;
    ClassesQueries c = new ClassesQueries();

    public List<Materie> getClasses(){

        query = c.getClasses();
        ResultSet result = database.getResultByStatement(query);
        List<Materie> materii = new ArrayList<>();
        try {
            while (result.next()) {
                materii.add(new Materie(Integer.parseInt(result.getObject(1).toString()),result.getObject(2).toString()));
            }
            return materii;
        } catch(SQLException e){
            return null;
        }
    }

}
