package ito.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDinamica<E> implements Lista<E> {
	
	private NodoLista<E> p,u;
	private int size;
	
	public ListaDinamica() {
		this.p=this.u=null;
		this.size=0;
	}

	@Override
	public void add(E item) throws ExcepcionDeListaLlena {
		// TODO Auto-generated method stub
		NodoLista<E> nuevo= new NodoLista<E>(item);
		if(this.isEmpty())
			p=u=nuevo;
		else {
			u.setNext(nuevo);
			u=nuevo;
		}
        this.size++;
	}

	@Override
	public E delete(int i) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		if(i>this.size)
			throw new ExcepcionDeElementoNoEncontrado("El elemento no fue encontrado!!");
		NodoLista<E> aux=p,prev=null;
		for(int j=1;j<i;j++) {
			prev=aux;
			aux=aux.getNext();
		}
		if(prev==null)
			p=aux.getNext();
		else
			prev.setNext(aux.getNext());
		if(p==null)
			u=null;
		E item=aux.getItem();
		this.size--;
		return item;
	}

	@Override
	public E deleteFirst() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		E item=null;
		try {
			item=this.delete(1);
		}catch(Exception e) {}
		return item;
	}
	
	
	@Override
	public E deleteLast() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		E item=u.getItem();
		try {
			this.delete(this.size);
		}catch(Exception e) {}
		return item;
	}

	@Override
	public E deleteItem(E item) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		NodoLista<E> aux=this.p,prev=null;
		while(aux!=null) {
			@SuppressWarnings("unchecked")
			Comparable<E> c=(Comparable<E>)aux.getItem();
			if(c.compareTo(item)==0) 
				break;
			prev=aux;aux=aux.getNext();
		}
		if(aux==null)
			throw new ExcepcionDeElementoNoEncontrado("El elemento no fue localizado!!");
		if(prev==null) {
			this.p=this.p.getNext();
		    if(p==null)
			      u=null;
		}else if(aux.getNext()==null)
			  u=prev;
		else
			prev.setNext(aux.getNext());
		this.size--;
		return item;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return p==null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public E getFirst() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		return this.p.getItem();
	}

	@Override
	public E getLast() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		return this.u.getItem();
	}

	@Override
	public E getItem(int i) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		if(i>this.size)
			throw new ExcepcionDeElementoNoEncontrado("El elemento no fue encontrado!!");
		NodoLista<E> aux=p;
		for(int j=1;j<i;j++) 
			aux=aux.getNext();
		return aux.getItem();
	}

	@Override
	public boolean search(E item) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		NodoLista<E> aux=this.p;
		while(aux!=null) {
			@SuppressWarnings("unchecked")
			Comparable<E> c=(Comparable<E>)aux.getItem();
			if(c.compareTo(item)==0) 
				break;
			aux=aux.getNext();
		}
		if(aux==null)
			throw new ExcepcionDeElementoNoEncontrado("El elemento no fue localizado!!");
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListaIterator();
	}

	// Clase interna para el iterador de la lista
	private class ListaIterator implements Iterator<E> {
		private NodoLista<E> actual = p;

		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E item = actual.getItem();
			actual = actual.getNext();
			return item;
		}
	}

}
