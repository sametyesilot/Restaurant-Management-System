/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.swing.JOptionPane;

/**
 *
 * @author Samet
 */
public class tables {
    public static void main(String[] args){
        try{
            String userTable = "create table user(id int AUTO_INCREMENT primary key, isim varchar(200), email varchar(200),telefonNo varchar(10),adres varchar(200),sifre varchar(200),soru varchar(200),cevap varchar(200),status varchar(20),UNIQUE (email))";
            String adminDetails = "insert into user(isim,email,telefonNo,adres,sifre,soru,cevap,status) values('Admin', 'admin@gmail.com', '1234567890', 'Turkey', 'admin','elma mı','elma','true')";
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key, name varchar(200))";
            String productTable = "create table product(id int AUTO_INCREMENT primary key, name varchar(200),category varchar(200), price varchar(200))";
            String billTable = "create table bill(id int primary key, name varchar(200), mobileNumber varchar(200), email varchar(200), date varchar(50), total varchar(200),createdBy varchar(200))";

     //       DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
   //         DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
   //         DbOperations.setDataOrDelete(categoryTable, "Category table created Successfully");
   //         DbOperations.setDataOrDelete(productTable, "Product table created Successfully"); 
            DbOperations.setDataOrDelete(billTable, "Bill table created Successfully"); 

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}