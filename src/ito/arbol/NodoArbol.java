package ito.arbol;

public class NodoArbol <E> {
	
	private E item;
	private NodoArbol<E> izquierdo;
	private NodoArbol<E> derecho;
	
	public NodoArbol(E item) {
		this.item=item;
		this.setIzquierdo(null);
		this.setDerecho(null);
	}

	public E getItem() {
		return item;
	}

	public NodoArbol<E> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(NodoArbol<E> izquierdo) {
		this.izquierdo = izquierdo;
	}

	public NodoArbol<E> getDerecho() {
		return derecho;
	}

	public void setDerecho(NodoArbol<E> derecho) {
		this.derecho = derecho;
	}
	
	
	

}
