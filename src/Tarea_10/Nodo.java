package Tarea_10;
import java.util.ArrayList;


public class Nodo {
    String nombre;
    ArrayList<Nodo> vecinos = new ArrayList<>();

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return nombre;
    }
}
