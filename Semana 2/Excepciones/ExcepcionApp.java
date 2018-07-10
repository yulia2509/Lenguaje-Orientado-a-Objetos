/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;


/**
 *
 * @author Yulia
 */
public class ExcepcionApp {
    public static void main(String[]args){
        FileReader fr = null;
        
//Ejemplo 1 (forma generica)
        try{
            //Si el nombre del fichero no existe, lanza el catch
            fr = new FileReader("casa");
            
            //Esta linea no se ejecuta
            System.out.println("No verás este mensaje");
            
        } catch(IOException e){
            
            System.out.println("Error E/S: el fichero no existe (EJEMPLO 1)");
            
        }
        
//Ejemplo 2 (catches concatenados)
        try{
            //Si el nombre del fichero no existe, lanza el catch
            fr = new FileReader("casa");
            
            //Esta linea no se ejecuta
            System.out.println("No verás este mensaje");
            
        } catch(FileNotFoundException e){
            
            System.out.println("Error E/S: el fichero no existe (EJEMPLO 2)");
            
        } catch(IOException e){
        
            System.out.println("Si el fichero no existe, este mensaje no se verá");
            
        }
        
//Ejemplo 3: bloque finally
        try{
            //Si el nombre del fichero no existe, lanza el catch
            fr = new FileReader("casa");
            
            //Esta linea no se ejecuta
            System.out.println("No verás este mensaje");
            
        } catch(IOException e){
            
            System.out.println("Error E/S: el fichero no existe (EJEMPLO 3)");
            
        } finally {
//Siempre se ejecutará. Si en este bloque se podria producir una excepcion, se anidará un try-catch
            System.out.println("Este mensaje siempre se ejecutara ");
            
        }
  /*      
//Ejemplo 4: Llamadas superiores 
        try{
            //Si el nombre del fichero no existe, lanza el catch
            prueba();
            
            //Esta linea no se ejecuta
            System.out.println("No verás este mensaje");
            
        } catch(IOException e){
            
            System.out.println("Error E/S: el fichero no existe (EJEMPLO 4)");
            
        }
        
        public static void prueba() throws IOException{
        //Lanzara una excepcion pero se lanza en el try-catch del main
            FileReader fr = new FileReader("casa");
        }
        */
    }
}

//Excepciones, trabajar en dos archivos, variables estatica y final, suma, usasuma, try y catch, variables privadas(sets y gets)
