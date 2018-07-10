/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

import javax.swing.*;

public class HolaMundoSwing {
public static void main(String[] args) {
	 	 JFrame frame = new JFrame("HolaMundoSwing");
	 	 final JLabel label = new JLabel("Hola Mundo");
	 	 frame.getContentPane().add(label);
			
	 	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	 	 frame.pack();
	 	 frame.setVisible(true);
    }
}
