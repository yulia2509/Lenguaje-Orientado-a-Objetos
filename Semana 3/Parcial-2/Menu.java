/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;

import java.util.*;

public class Menu {
    Scanner scan = new Scanner(System.in);

    private String fileName;
    //private boolean isFileNew = true;
    private boolean isFileSaved = false;
    private boolean isFileAvailable = false;
    private String fileContent = "";


    Lista milista; // = new Lista();
    ArchivoRw miArchivoRw;

    public void menuPrincipal() {
        this.isFileAvailable = false;
        int opcion = 0;

        while (!isFileAvailable && !isFileSaved) {
            System.out.println("Desea (1)crear o (2)editar un archivo o (3)Salir :");
            try {
                opcion = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) { //con esto cachamos el salto de linea para que no se coma un valor
                e.printStackTrace();
            }

            if (opcion == 1 || opcion == 2){
                System.out.println("Indique nombre del archivo: ");
                fileName = scan.nextLine();

                this.miArchivoRw = new ArchivoRw(fileName);
            }


            switch (opcion) {
                case 1: 
                    System.out.println("Creando archivo...");
                    milista = new Lista();
                    //milista.creaLista();
                    this.isFileAvailable = miArchivoRw.writeToFile("Mi lista: "+ fileName);
                    //this.isFileNew = true;
                    this.menuSecundario();
                    break;
                case 2: 
                    System.out.println("Abriendo archivo a editar...");
                    if (miArchivoRw.readFromFile()) {
                        this.fileToArray();
                        this.isFileAvailable=true;
                        this.menuSecundario();
                    }
                    //this.isFileNew = false;
                    break;
                case 3: 
                    System.out.println("Saliendo de sistema...");
                    this.isFileAvailable = true;
                    break;
                default: 
                    System.out.println("Opcion no valida...");
                    this.isFileAvailable = false;
                    break;
            }
        }
    }

    public void menuSecundario(){
        //this.isFileAvailable = false;
        int opcion = 0;
        int indiceLista = 0;
        String tempNombre ="";
        int tempPrecio = 0;

        while (isFileAvailable) {
            System.out.println("Desea (1)revisar, (2)editar, (3)guardar su lista?:");
            //opcion = scan.nextInt();
            try {
                opcion = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) { //con esto cachamos el salto de linea para que no se coma un valor
                e.printStackTrace();
            }

            switch (opcion) {
                case 1: 
                    System.out.println("Mostrando contenido de lista...");
                    this.fileContent = milista.mostrarLista();
                    break;
                    
                case 2: 
                    if (milista.getSize()> 0){
                        System.out.println("Mostrando contenido de lista...");
                        this.fileContent = milista.mostrarLista();
                        if (milista.getSize() <= 0){
                            System.out.println("Parece que esta vacío, intenta generar un nuevo archivo...");
                            this.isFileAvailable = false;
                        }
                    }
                    
                    opcion = 0;
                    
                    System.out.println("Escriba 1 para editar los items y 2 para eliminar");
                    try {
                        opcion = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) { //con esto cachamos el salto de linea para que no se coma un valor
                        e.printStackTrace();
                    }
                    
                    switch (opcion){
                        case 1:
                            System.out.println("Indique el item que desea editar (1 al "+ milista.getSize() +")...");
                            try {
                                indiceLista = Integer.parseInt(scan.nextLine())-1;
                            } catch (NumberFormatException e) { //con esto cachamos el salto de linea para que no se coma un valor
                                e.printStackTrace();
                            }
                            //indiceLista = scan.nextInt() - 1;
                            System.out.println("Nuevo nombre:");
                            tempNombre = scan.nextLine();
                            this.milista.itemList[indiceLista].setNombre(tempNombre);
                            System.out.println("Nuevo precio:");
                            try {
                                tempPrecio = Integer.parseInt(scan.nextLine());
                            } catch (NumberFormatException e) { //con esto cachamos el salto de linea para que no se coma un valor
                                e.printStackTrace();
                            }
                            //tempPrecio = scan.nextInt();
                            this.milista.itemList[indiceLista].setPrecio(tempPrecio);
                            System.out.println("Contenido actualizado...");
                            //isFileNew = false;
                        break;
                        
                        case 2:
                            ///////////////////////////////////////////////////////////////////////
                            System.out.println("Indique el item que desea eliminar (1 al "+ milista.getSize() +")...");
                            try {
                                indiceLista = Integer.parseInt(scan.nextLine())-1;
                            } catch (NumberFormatException e) { //con esto cachamos el salto de linea para que no se coma un valor
                                e.printStackTrace();
                            }
                            tempNombre = " ";
                            this.milista.itemList[indiceLista].setNombre(tempNombre);
                            tempPrecio = 0;
                            this.milista.itemList[indiceLista].setPrecio(tempPrecio);
                            System.out.println("Contenido actualizado...");
                            
                        break;
                    }
                    
                case 3: 
                    if (this.milista.getSize()> 0){
                        System.out.println("Guardando lista...");
                        if (miArchivoRw.writeToFile(this.ArrayToFile())) {
                            this.isFileAvailable= false; //invertimos para salir del loop
                            System.out.println("La lista se guardo satisfactoriamente...");
                            this.isFileSaved = true;
                        }
                    } else {
                        System.out.println("Su lista esta vacía, no se guardo nada...");
                        this.isFileAvailable=false;
                        this.menuPrincipal();
                    }
                    break;
                default:
                    System.out.println("Operacion no valida...");
            }
        }
    }  

    public void fileToArray(){
        String tempNombre = "none";
        int tempPrecio = 0;
        String tempString = "";

        tempString = miArchivoRw.getFileContent();
        //while(!" ".equals(tempString) || !"0".equals(tempString)){
        System.out.println(tempString);
        String[] rows = tempString.split("\\|");
        this.milista = new Lista(rows.length);

        for (int i = 0; i < rows.length; i++ ){
            //System.out.println("row:"+rows[i]);
            String[] entries = rows[i].split(",");
            //System.out.println("entry: "+ entries[0]);
            tempNombre = entries[0];
            //System.out.println("entry: "+ entries[1]);
            tempPrecio = Integer.parseInt(entries[1]);
            //System.out.println(rows.length);
 

            this.milista.itemList[i].setNombre(tempNombre);
            //System.out.println(this.milista.itemList[i].getNombre());
            this.milista.itemList[i].setPrecio(tempPrecio);
            //System.out.println(this.milista.itemList[i].getPrecio());
           // }   
        }
    }
    

    public String ArrayToFile() {
        String tempString = "";

        for (int i=0; i<milista.getSize(); i++) {
            tempString = tempString + this.milista.itemList[i].getNombre() + ",";
            tempString = tempString + this.milista.itemList[i].getPrecio() + "|";             
        }

        return tempString;
    }

}
