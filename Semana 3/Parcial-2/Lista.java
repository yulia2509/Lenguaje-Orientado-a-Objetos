/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;

import java.util.*;

public class Lista {
    Scanner scan = new Scanner(System.in);
    private int size = 0;
    Item[] itemList;

    public Lista (int size){
        this.size = size;
        //inicializamos como Arreglo
        itemList = new Item[size];
        
        //inicializamos cada objeto del Arreglo
        for (int i= 0; i < size; i++) {
            itemList[i] = new Item();
        }
    }

    public Lista() { //creaLista()
        inicializaLista();
        llenaLista();
    }
    
    public void inicializaLista() {
        System.out.println("Cuantos items tendra tu lista:");
        //this.size = scan.nextInt();
        try {
            this.size = Integer.parseInt(scan.nextLine()); 
        } catch (NumberFormatException e) { //con esto cachamos el salto de linea para que no se coma un valor
            e.printStackTrace();
        }

        //inicializamos como Arreglo
        itemList = new Item[this.size];
        
        //inicializamos cada objeto del Arreglo
        for (int i= 0; i < this.size; i++) {
            itemList[i] = new Item();
        }
    }

    public void llenaLista() {
        String tempNombre = "";
        int tempPrecio = 0;

        System.out.println("Dame los siguientes datos para hacer tu lista:");

        for (int i=0; i<this.size; i++) {
            System.out.println("Nombre:");
            tempNombre = scan.nextLine();
    
            this.itemList[i].setNombre(tempNombre);
            
            System.out.println("Precio:");
            try {
                tempPrecio = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) { //con esto cachamos el salto de linea para que no se coma un valor
                e.printStackTrace();
            }
            this.itemList[i].setPrecio(tempPrecio); 
        }

    }

    public String mostrarLista() {
        String contenidoLista="";

        System.out.println("Tu lista tiene los siguientes "+ this.size +" items:");

        for (int i=0; i<this.size; i++) {
            System.out.println("Nombre:" + this.itemList[i].getNombre());
            System.out.println("Precio:" + this.itemList[i].getPrecio());
            contenidoLista = itemList[i].getNombre() + "," + itemList[i].getPrecio()+"\r\n";
        }

        return contenidoLista;

    }

    public void editaLista(int index) {
        System.out.println("Dame los siguientes datos para editar tu item["+index+"]");

        for (int i=0; i<size; i++) {
            System.out.println("Nombre:");
            itemList[i].setNombre("hola");
            System.out.println("Precio:");
            itemList[i].setPrecio(5); 
        }

    }

    public int getSize(){
        return this.size;
    }

    //Este main se puede borrar
    public static void main (String arg[]){
       
    }
}
