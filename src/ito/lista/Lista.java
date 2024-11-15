package ito.lista;

import java.util.Iterator;

public interface Lista<E> extends Iterable<E> {
	public void add(E item) throws ExcepcionDeListaLlena;
	public E delete(int i) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado;
	public E deleteFirst() throws ExcepcionDeListaVacia;
	public E deleteLast() throws ExcepcionDeListaVacia;
	public E deleteItem(E item) throws ExcepcionDeListaVacia,ExcepcionDeElementoNoEncontrado;
	public boolean isEmpty();
	public boolean isFull();
	public int size();
	public E getFirst() throws ExcepcionDeListaVacia;
	public E getLast() throws ExcepcionDeListaVacia;
	public E getItem(int i) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado;
    public boolean search(E item)throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado;
	public Iterator<E> iterator();
}
