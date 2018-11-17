/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networkingapp.Connector;

import Networkingapp.Database.OracleDatabaseConnect;
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

/**
 *
 * @author peichen
 */
public class PostConnector {
    
    private static String postID;

    
    //public static SimpleDateFormat dtf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

    
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    
    public int editPost(){
        
        
        
        return 0;
    }
    
    public static int createPost(String pTitle, String pContent){
//        LocalDateTime now = LocalDateTime.now();
//        ZonedDateTime zdt = now.atZone(ZoneId.systemDefault());
//        java.util.Date output = Date.from(zdt.toInstant());
        Timestamp timestamp = Timestamp.from(ZonedDateTime.now(ZoneOffset.systemDefault()).toInstant());       
        String rpID = "post" + randomAlphaNumeric(4);     
        int upst = 0;
        
        try {
            OracleDatabaseConnect dbm = OracleDatabaseConnect.getInstance();
            upst = dbm.updateWithPrepareStatement ("INSERT INTO Post(post_ID, post_title, "
                    + "post_time, post_content, user_ID) "
                    + "VALUES(?, ?, ?, ?, ?)", rpID, pTitle.trim(),
                    timestamp, pContent.trim(), UserConnector.getUserID());
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        setPostID(rpID);
        return upst;
    }
    
    
    public static boolean postExist(String checkType, String checkItem){
        ResultSet res;
        String pItem = checkItem.trim();
        
        switch (checkType){
            case "Post ID":
                checkItem = "post_ID";
                break;
            case "Title":
                checkItem = "post_title";
                break;
            case "time":
                checkItem = "post_time";
                break;
            case "Content":
                checkItem = "post_content";
                break;                
            case "uID":
                checkItem = UserConnector.getUserID();
                break;            
        }
                       
        try {
            OracleDatabaseConnect dbm = OracleDatabaseConnect.getInstance();
            res = dbm.queryWithPrepareStatement ("SELECT * FROM post");
            while(res.next()){
                if(res.getString(checkItem).equals(pItem) ){
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public static void setPostID(String postID) {
        PostConnector.postID = postID;
    }
    
    
    
    
    
    
    
    
    
}
