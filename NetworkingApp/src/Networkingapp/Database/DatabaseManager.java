package Networkingapp.Database;

import java.sql.*;

public class DatabaseManager {

    private static final String DATABASE_URL_WITH_SSH = "jdbc:oracle:thin:@localhost:1522:ug";
    private static DatabaseManager dbm;
    private static String username;
    private static String password;

    private Connection con;

    public static DatabaseManager getInstance(){
        if (dbm == null) {
            dbm = new DatabaseManager();
        }
        return dbm;
    }

    private DatabaseManager(){
        initializeJDBCDriver();
    }

    private void initializeJDBCDriver() {
        try {
            System.out.print("Preparing JDBC driver.");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Ready.");
        } catch (SQLException e) {
            System.out.println("JDBC preparation failed: " + e);
            System.exit(-1);
        }
    }

    public boolean startConnection(String username, String password){
        DatabaseLoginInfoSetup(username, password);

        System.out.println("Connecting to Oracle database...");
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug", username, password);
            con.setAutoCommit(true);
            System.out.println("Connected to Oracle!");
            return true;
        } catch (SQLException e) {
            System.out.println("Connection failure: " + e.getMessage());
            return false;
        }
    }

    public ResultSet queryWithPrepareStatement(String query, Object... param) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        prepareStatement(statement, param);
        return statement.executeQuery();
    }


    public int updateWithPrepareStatement(String query, Object... param) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        prepareStatement(statement, param);
        return statement.executeUpdate();
    }

    private void prepareStatement(PreparedStatement ps, Object[] parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++)
        {
            if( parameters[i] instanceof Integer ) {
                // Integer
                ps.setInt(i+1, ((Integer)parameters[i]).intValue());
            } else if( parameters[i] instanceof Double ) {
                // Double
                ps.setDouble(i+1, ((Double)parameters[i]).doubleValue());
            } else if( parameters[i] instanceof Float ) {
                // Float
                ps.setFloat(i+1, ((Float)parameters[i]).floatValue());
            } else if( parameters[i] instanceof java.sql.Date ) {
                // Date
                ps.setDate(i+1, ((java.sql.Date)parameters[i]));
            } else if( parameters[i] instanceof java.sql.Timestamp ) {
                // Date
                ps.setTimestamp(i+1, ((java.sql.Timestamp)parameters[i]));
            } else if( parameters[i] instanceof String ) {
                // String
                ps.setString(i+1, ((String)parameters[i]));
            }  else if( parameters[i] instanceof byte[] ) {
                // bytes
                ps.setBytes(i+1, ((byte[])parameters[i]));
            } else if( parameters[i] instanceof Boolean ) {
                // Boolean
                ps.setBoolean(i+1, ((Boolean)parameters[i]).booleanValue());
            } else {
                throw new SQLException("Invalid parameter type: "+parameters[i].getClass().getSimpleName());
            }
        }
    }

    public ResultSet query(String queryString) throws SQLException {
        Statement stmt = con.createStatement();
        return stmt.executeQuery(queryString);
    }

    public int update(String updateString) throws SQLException{
        Statement stmt = con.createStatement();
        return stmt.executeUpdate(updateString);
    }

    private static void DatabaseLoginInfoSetup(String user, String pass) {
        username = user;
        password = pass;
    }

    public Connection getConnection(){
        return con;
    }

    public void endConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Disconnect failed");
        }

    }
}
