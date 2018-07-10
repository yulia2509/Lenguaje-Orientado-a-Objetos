/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;
//Una lista está conformada por items (se atomiza de lo mas pequeño a lo mas grande)
public class Item {
	private int precio;
	private String nombre;

	public Item(){
	    this.precio = 10;
		this.nombre = "generico";
	}

	
	public Item(String nombreNuevo, int precioNuevo){
		this.precio = precioNuevo;
		this.nombre = nombreNuevo;
	}

	public void setNombre(String nombreNuevo) {
		this.nombre = nombreNuevo;
	}

	public void setPrecio(int precioNuevo) {
		this.precio = precioNuevo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getPrecio() {
		return this.precio;
	}

}
//Esta clase es inerte
