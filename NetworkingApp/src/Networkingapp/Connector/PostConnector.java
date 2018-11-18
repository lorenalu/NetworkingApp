/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp.Connector;

import Networkingapp.Database.DatabaseManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author peichen
 */
public class PostConnector {
    
    private static String postID;
    //public static SimpleDateFormat dtf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss")   
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    
    public static void editPost(String pID, String pTitle, String pContent){
        Timestamp timestamp = Timestamp.from(ZonedDateTime.now(ZoneOffset.systemDefault()).toInstant());
        
        try {
            DatabaseManager dbm = DatabaseManager.getInstance();
            dbm.updateWithPrepareStatement ("UPDATE post SET post_title = ?, post_time = ?, "
                                                + "post_content = ? WHERE post_ID = ?", pTitle, 
                                                timestamp, pContent, pID);
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public static void delPostHelper(String pID) throws SQLException{
        DatabaseManager dbm = DatabaseManager.getInstance();
        Connection con = dbm.getConnection();
        
        
        
        try {  
            con.setAutoCommit(false);
            
            dbm.updateWithPrepareStatement ("DELETE FROM App_Comment WHERE post_ID = ?", pID);
            dbm.updateWithPrepareStatement ("DELETE FROM Post_Category WHERE post_ID = ?", pID); 
            dbm.updateWithPrepareStatement ("DELETE FROM Advertisement WHERE post_ID = ?", pID);
            dbm.updateWithPrepareStatement ("DELETE FROM Post WHERE post_ID = ?", pID);
            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex1);
                JOptionPane.showMessageDialog(null, "Delete unsuccessful", "DELETE ERROR", JOptionPane.ERROR_MESSAGE);
                throw new SQLException(ex1.getMessage());
            }
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //return res;
    }
    
    public static void delPost(String pID){
        
        ResultSet res;
        DatabaseManager dbm = DatabaseManager.getInstance();
        
        try {
            res = dbm.queryWithPrepareStatement ("SELECT * FROM Post, App_User WHERE Post.user_ID = ?", UserConnector.getUserID());
                    
            if(res.next()){
                String str = res.getString("post_ID");
                if(str.equals(pID)){
                    delPostHelper(pID);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // (mode == 0) AllPost
    // (mode == 1) MyPost
    // Select...From...Where
    public static ResultSet getPost(int mode){
        ResultSet res = null;
        
        try {
            DatabaseManager dbm = DatabaseManager.getInstance();
            if(mode == 1){
                res = dbm.queryWithPrepareStatement ("SELECT * FROM Post WHERE user_ID = ? ORDER BY post_time ASC", UserConnector.getUserID());
            }else{
                res = dbm.queryWithPrepareStatement ("SELECT * FROM Post ORDER BY post_time ASC");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
//    public static ResultSet getMyPost(){
//        ResultSet res = null;
//        
//        try {
//            DatabaseManager dbm = DatabaseManager.getInstance();
//            res = dbm.queryWithPrepareStatement ("SELECT * FROM post WHERE user_ID = ?", UserConnector.getUserID());
//        } catch (SQLException ex) {
//            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return res;
//    }
    
    
    
    public static String getSelectedContent(String selectPostID){
        ResultSet res = null;
        String slp = selectPostID.trim();
        String sc = "There is no Content";
        try {
            DatabaseManager dbm = DatabaseManager.getInstance();
            res = dbm.queryWithPrepareStatement ("SELECT post_content FROM post WHERE post_ID = ?", slp);

            if(res.next()){
                sc = res.getString("post_content");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sc;
    }
   
    
    public static int createPost(String pTitle, String pContent){
//        LocalDateTime now = LocalDateTime.now();
//        ZonedDateTime zdt = now.atZone(ZoneId.systemDefault());
//        java.util.Date output = Date.from(zdt.toInstant());
        Timestamp timestamp = Timestamp.from(ZonedDateTime.now(ZoneOffset.systemDefault()).toInstant());       
        String rpID = "post" + randomAlphaNumeric(4);     
        int upst = 0;
        
        try {
            DatabaseManager dbm = DatabaseManager.getInstance();
            upst = dbm.updateWithPrepareStatement ("INSERT INTO Post(post_ID, post_title, "
                    + "post_time, post_content, user_ID) "
                    + "VALUES(?, ?, ?, ?, ?)", rpID, pTitle.trim(),
                    timestamp, pContent.trim(), UserConnector.getUserID());
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return upst;
    }
    
    
    
    // checkType: 1:"Post ID"
    //            2:"post_title"
    //            3:"post_time"
    //            4:"post_content"
    //            5: "user_ID"
    
    public static boolean postExist(int checkType, String checkItem){
        ResultSet res = null;
        String pItem = checkItem.trim();
        String checkOp = "post_ID = ?";
        switch (checkType){
            case 0:
                break;
            case 1:
                checkOp = "post_title = ?";
                break;
            case 2:
                checkOp = "post_time = ?";
                break;
            case 3:
                checkOp = "post_content = ?";
                break;                
            case 4:
                checkOp = "user_ID = ?";
                break;            
        }
                       
        try {
            DatabaseManager dbm = DatabaseManager.getInstance();
            res = dbm.queryWithPrepareStatement ("SELECT * FROM post WHERE " + checkOp, checkItem);
            if(res.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
        
    }
    
}
