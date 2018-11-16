package Networkingapp.Database;

import java.sql.*;

public class DatabaseManager {
    
    // Suggest to read Before implementing (Chinese Wiki) 
    // http://wiki.jikexueyuan.com/project/jdbc/statements.html
   
    
    // Statement
    //      Use the for general-purpose access to your database. 
    //      Useful when you are using static SQL statements at runtime. 
    //      The Statement interface cannot accept parameters.
    // PreparedStatement
    //      Use the when you plan to use the SQL statements many times.
    //      The PreparedStatement interface accepts input parameters at runtime.
    // CallableStatement
    //      Use the when you want to access the database stored procedures. 
    //      The CallableStatement interface can also accept runtime input parameters.
    // Chinese Explanation http://wiki.jikexueyuan.com/project/jdbc/statements.html
    

    private static DatabaseManager dbm;
    private Connection con;

    public static DatabaseManager getInstance(){
        if (dbm == null) {
            dbm = new DatabaseManager();
        }
        return dbm;
    }
 
    // Initializing the Oracle JDBC driver
    private DatabaseManager(){
        try {
            // Do not need to Register JDBC driver here
            // BUT remember to put classes12.zip and hb15.zip in library
            System.out.print("Preparing JDBC driver...");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("JDBC driver is ready!");
        } catch (SQLException e) {
            // Handle errors for JDBC
            System.out.println("JDBC driver preparation failed: " + e);
            System.exit(-1);
        }
    }

    public boolean startConnection(String username, String password){
        System.out.println("Connecting to Oracle database...");
        try {
            // Connect to Oracle database
            // username, password given by user
            con = DriverManager.getConnection("jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug", username, password);
            
            // Retrieves the current auto-commit mode 
            //      for this startConnection object.
            // @return the current state of this startConnection object's 
            //      auto-commit mode
            // @exception SQLException if a database access error occurs 
            //      or this method is called on a closed connection
            // Chinese Explanation http://blog.sina.com.cn/s/blog_81547cad01014rnk.html
            con.setAutoCommit(true);
            
            System.out.println("Connected to Oracle successfully!");
            return true;
            
        } catch (SQLException e) {
            // Handle errors for Connection
            System.out.println("Connection failure: " + e.getMessage());
            return false;
        }
    }
    
    // After finishing with the Statement
    // DO NOT forget to close it using stmt.close()
    // Chinese Explanation https://zhidao.baidu.com/question/220965657
    
    // Execute a query
    public ResultSet query(String queryString) throws SQLException {
        // Before you can use a Statement object to execute 
        // a SQL statement, you need to create one using 
        // the Connection object's createStatement( ) method
        Statement stmt = con.createStatement();
        
        // ResultSet executeQuery (String SQL):
        // Returns a ResultSet object. 
        // Use this method when you expect to get a result set, 
        // as you would with a SELECT statement.
        return stmt.executeQuery(queryString);
        // Example for queryString:
        // "SELECT id, first, last, age FROM Registration";
    }

    // Update a query
    public int update(String updateString) throws SQLException{
        // Before you can use a Statement object to execute 
        // a SQL statement, you need to create one using 
        // the Connection object's createStatement( ) method
        Statement stmt = con.createStatement();
        
        // int executeUpdate (String SQL):
        // Returns the number of rows affected by the execution of 
        // the SQL statement. 
        // Use this method to execute SQL statements for which you expect 
        // to get a number of rows affected 
        //      - for example, an INSERT, UPDATE, or DELETE statement.
        return stmt.executeUpdate(updateString);
        // Example for updateString:
        // "UPDATE Registration " +
        //           "SET age = 30 WHERE id in (100, 101)";
        
    }

    public Connection getConnection(){ // Connection getter
        return con;
    }

   // Note for Myself:
   // boolean execute (String SQL): 
   // Returns a boolean value of true if a ResultSet object can be retrieved; 
   // otherwise, it returns false. Use this method to execute SQL DDL statements 
   // or when you need to use truly dynamic SQL.
    
    
    
    
   
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
    
    
    
    // Chinese Explanation https://blog.csdn.net/qh_java/article/details/48245945
    // English Explanation https://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
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
    
}