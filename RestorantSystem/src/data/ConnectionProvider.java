/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.sql.*;
/**
 *
 * @author Samet
 */
public class ConnectionProvider {
    public static Connection getCon(){
       Connection con = null;
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false&serverTimezone=Europe/Istanbul", "root", "samet3363");
           return con;
       }catch(Exception e){
            e.printStackTrace();
       }
       return con;
    }
}
