package Tarea_10;

import java.util.ArrayList;


public class Grafo {
    ArrayList<Nodo> nodos = new ArrayList<>();

    public void agregarNodo(String nombre) {
        nodos.add(new Nodo(nombre));
    }

    public Nodo getNodo(String nombre) {
        for (Nodo n : nodos) {
            if (n.nombre.equals(nombre)) {
                return n;
            }
        }
        return null;
    }

    // La arista va en los dos sentidos
    public void agregarArista(String a, String b) {
        Nodo nodoA = getNodo(a);
        Nodo nodoB = getNodo(b);
        nodoA.vecinos.add(nodoB);
        nodoB.vecinos.add(nodoA);
    }
}
