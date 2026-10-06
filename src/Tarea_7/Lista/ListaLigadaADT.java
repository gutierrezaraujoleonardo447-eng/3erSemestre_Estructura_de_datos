package Tarea_7.Lista;


import Tarea_7.Nodo2.Nodo2;

public class ListaLigadaADT<T> {
    private Nodo2 head;

    public ListaLigadaADT() {
        this.head = null;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int getTamanio() {
        int contador = 0;

        if (head == null) {
            return contador;
        } else {
            Nodo2<T> actual = head;

            do {
                contador++;
                actual = actual.getSiguiente();
            } while (actual != null);

            return contador;
        }
    }

    public void agregar(T dato) {
        if (head == null) {
            this.head = new Nodo2<>(dato);
        } else {
            Nodo2<T> actual = head;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(new Nodo2<>(dato));
        }
    }

    public void agregarAlInicio(T valor) {
        Nodo2<T> nuevoNodo2 = new Nodo2<>(valor, head);
        head = nuevoNodo2;
    }

    public void agregarDespuesDe(T referencia, T valor) {
        if (head == null) {
            System.out.println("Vacia");
        } else {
            Nodo2<T> actual = this.head;

            while (actual != null && !actual.getDato().equals(referencia)) {
                actual = actual.getSiguiente();
            }

            if (actual == null) {
                System.out.println("No se encontro la referencia");
            } else {
                Nodo2<T> nuevoNodo2 = new Nodo2<>(valor, actual.getSiguiente());
                actual.setSiguiente(nuevoNodo2);
            }
        }
    }

    public void eliminarElPrimero() {
        if (head == null) {
            System.out.println("Vacia");
        } else {
            head = head.getSiguiente();
        }
    }

    public void eliminarElFinal() {
        if (head == null) {
            System.out.println("Vacia");
        } else if (head.getSiguiente() == null) {
            head = null;
        } else {
            Nodo2<T> actual = head;

            while (actual.getSiguiente().getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(null);
        }
    }

    public int buscar(T valor) {
        Nodo2<T> actual = head;
        int posicion = 0;

        while (actual != null) {
            if (actual.getDato().equals(valor)) {
                return posicion;
            }

            actual = actual.getSiguiente();
            posicion++;
        }

        return -1;
    }

    public void actualizar(T aBuscar, T nuevoValor) {
        if (head == null) {
            System.out.println("Vacia");
        } else {
            Nodo2<T> actual = this.head;

            while (actual != null && !actual.getDato().equals(aBuscar)) {
                actual = actual.getSiguiente();
            }

            if (actual == null) {
                System.out.println("No se encontro el elemento");
            } else {
                actual.setDato(nuevoValor);
            }
        }
    }

    public void transversal() {
        if (head == null) {
            System.out.println("Vacia");
        } else {
            Nodo2<T> actual = head;

            do {
                System.out.print("|" + actual.getDato());
                actual = actual.getSiguiente();
            } while (actual != null);

            System.out.println("|");
        }
    }
}