/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;
//import java.util.*;
import java.io.*;

//Lee, escribe y muestra el contenido

public class ArchivoRw {
    FileReader fileReader;
    FileWriter fileWriter;

    private String fileUrl = "default";
    private String fileContent = "";

    //Inicializar el atributo
    public ArchivoRw (String fileName) {
        this.fileUrl = "C:\\Users\\Yulia\\Desktop\\Objetos\\" + fileName + ".txt";
    }

    public boolean writeToFile(String text) {
        try{
            fileWriter = new FileWriter(this.fileUrl);
            fileWriter.write(text); 
            fileWriter.close();
            return true;   
        } catch (FileNotFoundException e) {
            System.out.println("writeToFile: El archivo solicitado ("+ this.fileUrl +") no existe, por favor genere un nuevo archivo...");
            return false;
        } 
        catch(IOException e) {
            System.out.println("writeToFile: Ocurrio un error inesperado de escritura, intente nuevamente...");
            return false;
        }
    }

    public boolean readFromFile() {
        try{
            fileReader = new FileReader(this.fileUrl);
            int puntero = fileReader.read();
            while(puntero!=-1){
                this.fileContent = this.fileContent + (char)puntero;
                puntero = fileReader.read();
            }
            fileReader.close();
            return true;   
        } catch (FileNotFoundException e) {
            System.out.println("readToFile: El archivo solicitado no existe por favor genere un nuevo archivo...");
            return false;
        } 
        catch(IOException e) {
            System.out.println("readToFile: Ocurrio un error inesperado de lectura, intente nuevamente...");
            return false;
        }
    }

    public String getFileContent(){
        return this.fileContent;
    }

    public String getFileUrl(){
        return this.fileUrl;
    }

}
