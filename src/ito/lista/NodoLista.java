package ito.lista;

public class NodoLista<E> {

	private E item;
	private NodoLista<E> next;
	
	public NodoLista(E item) {
		this.item=item;
		next=null;
	}

	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	public NodoLista<E> getNext() {
		return next;
	}

	public void setNext(NodoLista<E> next) {
		this.next = next;
	}
	
}
