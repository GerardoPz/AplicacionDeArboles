package ito.arbol;

import ito.Corrida;
import ito.arbol.ExcepcionNodoRepetido;

import java.util.Comparator;

public class ArbolBinario<E extends Comparable<E>> implements Arbol<E> {

	private NodoArbol<E> raiz;

	public ArbolBinario() {
		raiz = null;
	}

	@Override
	public void add(E item) throws ExcepcionNodoRepetido {
		this.raiz = this.add(this.raiz, item);
	}

	private NodoArbol<E> add(NodoArbol<E> r, E item) throws ExcepcionNodoRepetido {
		if (r == null)
			return new NodoArbol<>(item);

		// Aquí se usa Comparable para comparar el item
		int comparacion = item.compareTo(r.getItem());

		if (comparacion == 0)
			throw new ExcepcionNodoRepetido("El item ya se localiza en el árbol");

		if (comparacion < 0)
			r.setIzquierdo(add(r.getIzquierdo(), item));
		else
			r.setDerecho(add(r.getDerecho(), item));

		return r;
	}

	@Override
	public void delete(E item) throws ExcepcionNodoNoLocalizado {
		if (this.isFree())
			throw new ExcepcionNodoNoLocalizado("El arbol esta vacio");
		this.raiz = this.delete(this.raiz, item);
	}

	private NodoArbol<E> delete(NodoArbol<E> r, E item) throws ExcepcionNodoNoLocalizado {
		if (r == null)
			throw new ExcepcionNodoNoLocalizado("Item no encontrado para eliminar!!");

		int comparacion = item.compareTo(r.getItem());

		if (comparacion == 0) {
			if (r.getIzquierdo() == null && r.getDerecho() == null)
				return null;
			else if (r.getIzquierdo() == null)
				return r.getDerecho();
			else {
				NodoArbol<E> aux = r.getIzquierdo();
				while (aux.getDerecho() != null)
					aux = aux.getDerecho();
				aux.setDerecho(r.getDerecho());
				return r.getIzquierdo();
			}
		} else if (comparacion < 0)
			r.setIzquierdo(this.delete(r.getIzquierdo(), item));
		else
			r.setDerecho(this.delete(r.getDerecho(), item));

		return r;
	}

	@Override
	public boolean isFree() {
		return this.raiz == null;
	}

	@Override
	public int lengthHojas() {
		return lengthHojas(this.raiz);
	}

	private int lengthHojas(NodoArbol<E> r) {
		if (r == null)
			return 0;
		if (r.getIzquierdo() == null && r.getDerecho() == null)
			return 1;
		return lengthHojas(r.getIzquierdo()) + lengthHojas(r.getDerecho());
	}

	@Override
	public int getAltura() {
		return getAltura(this.raiz);
	}

	private int getAltura(NodoArbol<E> r) {
		if (r == null)
			return 0;
		int izq = getAltura(r.getIzquierdo());
		int der = getAltura(r.getDerecho());
		return 1 + Math.max(izq, der);
	}

	@Override
	public E search(E item) {
		return search(this.raiz, item);
	}

	private E search(NodoArbol<E> r, E item) {
		if (r == null) {
			return null;
		}

		int comparacion = item.compareTo(r.getItem());

		if (comparacion == 0) {
			return r.getItem();
		} else if (comparacion < 0) {
			return search(r.getIzquierdo(), item);
		} else {
			return search(r.getDerecho(), item);
		}
	}

	@Override
	public E search(E item, Comparator<E> comparator) {
		return search(this.raiz, item, comparator);
	}

	private E search(NodoArbol<E> r, E item, Comparator<E> comparator) {
		if (r == null) {
			return null;  // No encontrado
		}

		int comparacion = comparator.compare(item, r.getItem());

		if (comparacion == 0) {
			return r.getItem();  // Encontrado
		} else if (comparacion < 0) {
			return search(r.getIzquierdo(), item, comparator);  // Buscar en el subárbol izquierdo
		} else {
			return search(r.getDerecho(), item, comparator);  // Buscar en el subárbol derecho
		}
	}

	// Método para imprimir el árbol en inorden (izquierda, raíz, derecha)
	public void imprimirArbol() {
		imprimirEnInorden(raiz);
	}

	// Recorrido inorden: izquierdo, raíz, derecho
	private void imprimirEnInorden(NodoArbol<E> nodo) {
		if (nodo != null) {
			imprimirEnInorden(nodo.getIzquierdo()); // Recorrer el subárbol izquierdo
			System.out.println(nodo.getItem().toString()); // Imprimir el objeto de la corrida
			imprimirEnInorden(nodo.getDerecho()); // Recorrer el subárbol derecho
		}
	}
}
