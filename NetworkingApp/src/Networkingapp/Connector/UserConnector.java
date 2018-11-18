/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp.Connector;
import Networkingapp.Database.DatabaseManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author peichen
 */
public class UserConnector{
    //DatabaseManager dbm = DatabaseManager.getInstance();
    private static String userID;
    private static String userPassword;

    
    public static boolean userExist(String uID, String uPassword) throws SQLException{
        ResultSet res = null;
        String pwd = "";
        try{
        DatabaseManager dbm = DatabaseManager.getInstance();
        res = dbm.queryWithPrepareStatement ("SELECT * FROM App_User WHERE user_ID = ?", uID.trim());
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        
        if (res == null){
            return false;
        }
        if(res.next()){
            pwd = res.getString("user_password");
        }
        return pwd.equals(uPassword.trim());
        
    }
    
    public static void setUserIDandPassword(String uID, String password){
        userID = uID.trim();
        userPassword = password.trim();
    }
    
    public static String getUserID() {
        return userID;
    }

    public static String getUserPassword() {
        return userPassword;
    }
    

}
