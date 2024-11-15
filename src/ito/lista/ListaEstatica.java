package ito.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEstatica<E> implements Lista<E> {

	private E items[];
	private int p, u;
	private final int SIZE = 10;

	@SuppressWarnings("unchecked")
	public ListaEstatica() {
		this.items = (E[]) new Object[this.SIZE];
		this.p = this.u = -1;
	}

	@SuppressWarnings("unchecked")
	public ListaEstatica(int size) {
		this.items = (E[]) new Object[size];
		this.p = this.u = -1;
	}

	@Override
	public void add(E item) throws ExcepcionDeListaLlena {
		if (this.isFull())
			throw new ExcepcionDeListaLlena("La lista está llena!!");
		if (this.isEmpty())
			this.p++;
		this.items[++this.u] = item;
	}

	@Override
	public E delete(int i) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		return null;
	}

	@Override
	public E deleteFirst() throws ExcepcionDeListaVacia {
		return null;
	}

	@Override
	public E deleteLast() throws ExcepcionDeListaVacia {
		return null;
	}

	@Override
	public E deleteItem(E item) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return this.p == -1;
	}

	@Override
	public boolean isFull() {
		return this.u == this.items.length - 1;
	}

	@Override
	public int size() {
		return this.u + 1;
	}

	@Override
	public E getFirst() throws ExcepcionDeListaVacia {
		if (this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista está vacía!!");
		return this.items[this.p];
	}

	@Override
	public E getLast() throws ExcepcionDeListaVacia {
		if (this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista está vacía!!");
		return this.items[this.u];
	}

	@Override
	public E getItem(int i) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		if (this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista está vacía!!");
		if (i > this.u + 1)
			throw new ExcepcionDeElementoNoEncontrado("El elemento no se encuentra!!");
		return this.items[i - 1];
	}

	@Override
	public boolean search(E item) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		if (this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista está vacía!!");
		for (int i = this.p; i <= this.u; i++) {
			@SuppressWarnings("unchecked")
			Comparable<E> x = (Comparable<E>) items[i];
			if (x.compareTo(item) == 0) {
				return true;
			}
		}
		throw new ExcepcionDeElementoNoEncontrado("El elemento no se localiza!!");
	}

	@Override
	public Iterator<E> iterator() {
		return new ListaIterator();
	}

	// Clase interna para el iterador de la lista estática
	private class ListaIterator implements Iterator<E> {
		private int index = p;

		@Override
		public boolean hasNext() {
			return index <= u;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return items[index++];
		}
	}
}
