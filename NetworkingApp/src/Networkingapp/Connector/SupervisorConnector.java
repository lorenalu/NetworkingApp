/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp.Connector;

import Networkingapp.Database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author peichen
 */
public class SupervisorConnector {
    private static String superID;
    private static String superPassword;

    public static void setSuperIDAndPassword(String superID, String superPassword) {
        SupervisorConnector.superID = superID;
        SupervisorConnector.superPassword = superPassword;
    }

    
    public static boolean superExist(String uID) throws SQLException{
        ResultSet res = null;
        try{
        DatabaseManager dbm = DatabaseManager.getInstance();
        res = dbm.queryWithPrepareStatement ("SELECT * FROM Supervisor WHERE supervisor_ID = ?", uID.trim());
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        
        if (res == null){
            return false;
        }

        return res.next();
        
    }
    
    public static String getSuperID() {
        return superID;
    }
     
    public static String getSuperPassword() {
        return superPassword;
    }

    
}
