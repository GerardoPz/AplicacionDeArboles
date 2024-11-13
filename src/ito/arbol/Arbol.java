package ito.arbol;

public interface Arbol<E> {
	
	public void add(E item) throws ExcepcionNodoRepetido;
	public void delete(E item) throws ExcepcionNodoNoLocalizado;
	public boolean isFree();
	public int lengthHojas();
	public int getAltura();
	
}
