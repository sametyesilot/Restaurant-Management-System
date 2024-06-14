/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import javax.swing.JOptionPane;
import java.io.File;
/**
 *
 * @author Samet
 */
public class OpenPdf {
    public static void openById(String id){
        String path = System.getProperty("user.home") + "\\Documents\\"; // Kullanıcı belgeleri dizini
        try{
            if((new File(path + id + ".pdf")).exists()){
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + path +id+".pdf");
            }else 
                JOptionPane.showMessageDialog(null, "File is not Exists");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
