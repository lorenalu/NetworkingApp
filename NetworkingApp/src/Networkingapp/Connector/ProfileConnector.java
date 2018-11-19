/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp.Connector;

import Networkingapp.Database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peichen
 */
public class ProfileConnector {
    
    
        
    public static String getUserName() throws SQLException{
        ResultSet res = getProfileInfo();
        String uName = "";
        try {
            if(res.next()){
                uName = res.getString("profile_name");}
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        
        return uName;
        
//        return res.getString("profile_name");
    }
    
    public static String getUserAge() throws SQLException {
        ResultSet res = getProfileInfo();
        String uAge = "";
        try {
            if(res.next()){
                uAge = res.getString("profile_age");}
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        
        return uAge;
//        return res.getString("profile_age");
    }
    
    public static String getUserIntorduction() throws SQLException{
        ResultSet res = getProfileInfo();
        String uIntro = "";
        try {
            if(res.next()){
                uIntro = res.getString("profile_location");}
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return uIntro; 
//        return res.getString("profile_location");
    }
    
    public static String getUserGender() throws SQLException{
        ResultSet res = getProfileInfo();
        String uGender = "";
        try {
            if(res.next()){
                uGender = res.getString("profile_gender");}
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        
        return uGender;
        
//        return res.getString("profile_gender");
    }

    public static ResultSet getProfileInfo() throws SQLException{
        
        ResultSet res;

        try {
            DatabaseManager dbm = DatabaseManager.getInstance();
            res = dbm.queryWithPrepareStatement("SELECT * FROM Profile WHERE user_ID = ?", UserConnector.getUserID());
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        
        return res;
        
    }
    
    public static void updateUserProfile(String uName, String uAge, String uGender, String uIntroduction){       
        int res = 0;
        
        try {
            if(profileExits()){
                DatabaseManager dbm = DatabaseManager.getInstance();
                res = dbm.updateWithPrepareStatement("UPDATE Profile SET profile_name = ?,"
                                                     + " profile_age = ?, profile_gender = ?, "
                                                        + "profile_location = ? WHERE user_ID = ?", uName,
                        uAge, uGender, uIntroduction, UserConnector.getUserID());
            }else{
                DatabaseManager dbm = DatabaseManager.getInstance();
                res = dbm.updateWithPrepareStatement("INSERT INTO Profile(profile_ID, profile_name, "
                                                         + "profile_age, profile_location " 
                                                            + "profile_gender) VALUES(?,?,?,?)",
                                                    uName, uAge, uGender , uIntroduction, UserConnector.getUserID());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public static boolean profileExits() throws SQLException{
        ResultSet res = null;
        
        try{
        DatabaseManager dbm = DatabaseManager.getInstance();
        res = dbm.queryWithPrepareStatement ("SELECT * FROM Profile WHERE user_ID = ?", UserConnector.getUserID());
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        
        if (res == null){
            return false;
        }
        return res.next();
        
    }
    
}
