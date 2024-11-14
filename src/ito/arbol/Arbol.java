package ito.arbol;

import java.util.Comparator;

public interface Arbol<E> {
	public void add(E item) throws ExcepcionNodoRepetido;
	public void delete(E item) throws ExcepcionNodoNoLocalizado;
	public boolean isFree();
	public int lengthHojas();
	public int getAltura();
	public E search(E item);
	public E search(E item, Comparator<E> comparator);
}
