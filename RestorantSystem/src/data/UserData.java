/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Samet
 */
public class UserData {
    public static void save(User user){
        String query = "insert into user(isim,email,telefonNo,adres,sifre,soru,cevap,status) values('"+user.getIsim()+"','"+user.getEmail()+"','"+user.getTelefonNo()+"','"+user.getAdres()+"','"+user.getSifre()+"','"+user.getSoru()+"','"+user.getCevap()+"','false')";
        DbOperations.setDataOrDelete(query, "Registered Successfully! Waid for Admin Approval! ");
    }
    
    
    public static User login(String email, String sifre){
        User user = null;
        try{
            ResultSet rs = DbOperations.getData("select *from user where email='"+email+"'and sifre='"+sifre+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
            
    public static User getGuvenlikSorusu(String email){
        User user=null;
        try{
           ResultSet rs = DbOperations.getData("select *from user where email = '"+ email +"'");
           while(rs.next()){
               user = new User();
               user.setSoru(rs.getString("soru"));
               user.setCevap(rs.getString("cevap"));
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }        
    public static void update(String email,String yeniSifre){
        String query = "update user set sifre = '"+yeniSifre+"' where email = '"+email+"'";
        DbOperations.setDataOrDelete(query, "Password Changed Successfully");
    }
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList =new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select *from user where email like '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setIsim(rs.getString("isim"));
                user.setEmail(rs.getString("email"));
                user.setTelefonNo(rs.getString("telefonNo"));
                user.setAdres(rs.getString("adres"));
                user.setSoru(rs.getString("soru"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
              
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return arrayList;
    }
    public static void changeStatus(String email, String status){
        String query = "update user set status ='"+status+"' where email ='"+email+"'";
        DbOperations.setDataOrDelete(query, "Status Changed Successfully");
    }
    public static void changePassword(String email, String oldPassword, String newPassword){
        try{
            ResultSet rs = DbOperations.getData("select *from user where email='"+email+"' and sifre='"+oldPassword+"'");
            if(rs.next()){
                update(email, newPassword);
            }else{
                JOptionPane.showMessageDialog(null, "Old Password is Wrong");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
