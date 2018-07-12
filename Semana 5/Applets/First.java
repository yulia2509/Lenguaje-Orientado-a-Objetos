/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

/**
 *
 * @author Yulia
 */
//First.java  
import java.applet.Applet;  
import java.awt.Graphics;  
public class First extends Applet{  
  
    @Override
    public void paint(Graphics g){  
        g.drawString("HOLA MUNDO",100,100);  
    }  
  
}  
/* 
<applet code="First.class" width="150" height="150"> 
</applet> 
*/ 
