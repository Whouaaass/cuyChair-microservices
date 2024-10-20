/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.views.utilities;
import co.edu.unicauca.cuychair.gui.gui.views.AlertSimple;
import javax.swing.JFrame;

/**
 *
 * @author julia
 */
public class Utilities {
    //Imprime el resultado de un booleano
    public static void printResult(boolean prmBoolean){
        if(prmBoolean){
            System.out.println("True");
            return;
        }
        System.out.println("False");        
    }
    
    public static void setAlert(String title, String description) {
        AlertSimple objAlert = new AlertSimple(title, description);
        objAlert.pack();
        objAlert.setVisible(true);
        objAlert.setLocationRelativeTo(null);
        
        objAlert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
    }
}
