package sample.database;

import java.sql.*;

public class DatabaseConnection {

    static Connection con;

    public DatabaseConnection(){
        con = this.getInstance();
    }

    public Connection getInstance(){
        if (con == null){
            con = getConnection();
            return con;
        } else{
            return con;
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeStatement(String query){
        try {
            Statement statement = con.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getResultByStatement(String query){
        try {
            Statement statement = con.createStatement();
            ResultSet rs  = statement.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
