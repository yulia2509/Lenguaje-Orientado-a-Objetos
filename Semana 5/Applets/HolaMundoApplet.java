/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

/* <applet
code = "HolaMundoApplet.class"
width = "150"
height = "50"
>
<param name="Usuario" value ="Juanillo">
</applet> */
import javax.swing.*;
import java.awt.event.*;
public class HolaMundoApplet extends JApplet{
    JButton btn = new JButton("Pulse...");
    JLabel lbl = new JLabel();
    String mensaje = "Hola, mundo!";
    
    @Override
    public void init(){
    String usuario = getParameter("Usuario");
    if(usuario != null)
        mensaje = "Hola, " + usuario + "!";
        getContentPane().add(btn);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
            btn.setText(mensaje);
            }
        });
    }
}
