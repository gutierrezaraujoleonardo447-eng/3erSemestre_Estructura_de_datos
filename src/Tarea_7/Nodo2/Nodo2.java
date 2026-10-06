package Tarea_7.Nodo2;

public class Nodo2<T>{
    private T dato;
    private Nodo2 <T> siguiente;

    public Nodo2() {
    }

    public Nodo2(T dato) {
        this.dato = dato;
    }

    public Nodo2(T dato,Nodo2 <T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo2<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo2<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo2{" +
                "dato=" + dato +
                ", siguiente=" + siguiente +
                '}';
    }
}
