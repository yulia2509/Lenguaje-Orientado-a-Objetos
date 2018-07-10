/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;
//Empezar de lo mas especifico a lo mas general

//import java.io.IOException;
import java.util.*;

public class AppMiLista {
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Menu miMenu = new Menu();
         miMenu.menuPrincipal();
         //miMenu.menuSecundario();
    }
}

//Archivo por cada objeto
//Archivo por cada funcion
//De lo mas especifico a lo mas general
//en el main de preferencia solo se llama todo
//Agregar baja o un valor (Eliminar item) solo hay altas y cambios(pero de algo ya existente) 
//Proyecto final: sistema de manejo de empleados
//Empleado, Autos (Altas, bajas y cambios, asignacion entr ellos)
