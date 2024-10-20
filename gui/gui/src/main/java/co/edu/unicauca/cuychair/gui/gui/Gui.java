/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.unicauca.cuychair.gui.gui;

import co.edu.unicauca.cuychair.gui.gui.views.ViewLogin;
import javax.swing.JFrame;

public class Gui {

	public static void main(String[] args) {
            ViewLogin viewLogin = new ViewLogin();
            viewLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            viewLogin.setVisible(true);
	}
}