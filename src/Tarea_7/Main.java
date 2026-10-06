package Tarea_7;

import Tarea_7.Lista.ListaLigadaADT;
import Tarea_7.Perro.Perro;

public class Main {
    static void main() {
        ListaLigadaADT<Perro> lista = new ListaLigadaADT<>();

        System.out.println("\n ----------------Prueba de si esta vacia-----------------\n");
        System.out.println(lista.estaVacia());


        Perro perro1 = new Perro("Labrador", 3, true);
        Perro perro2 = new Perro("Chihuahua", 5, true);
        Perro perro3 = new Perro("Pastor Aleman", 2, false);
        Perro perro4 = new Perro("Husky", 4, true);
        Perro perro5 = new Perro("Pug", 6, false);

        System.out.println("\n---------Agregar al final------------\n");
        lista.agregar(perro1);
        lista.agregar(perro2);
        lista.agregar(perro3);
        lista.transversal();

        System.out.println("\n-------Tamaño lista---------\n");
        System.out.println(lista.getTamanio());



        System.out.println("\n-------Agregando al inicio---------\n");
        lista.agregarAlInicio(perro4);
        lista.transversal();

        System.out.println("\n-------Agregando despues de ---------\n");
        lista.agregarDespuesDe(perro2, perro5);
        lista.transversal();


        System.out.println("\n-------Buscar---------\n");
        int posicion = lista.buscar(perro2);
        System.out.println(posicion);

        System.out.println("\n-------Actualizar---------\n");

        Perro perroNuevo = new Perro("Bulldog", 1, true);
        lista.actualizar(perro2, perroNuevo);
        lista.transversal();


        System.out.println("\n-------Eliminar el primero---------\n");
        lista.eliminarElPrimero();
        lista.transversal();

        System.out.println("\n-------Eliminar el final---------\n");
        lista.eliminarElFinal();
        lista.transversal();


        System.out.println("\n-------Comprobar Tamaño---------\n");
        System.out.println(lista.getTamanio());


        System.out.println("\n-------Comprobar si esta vacia---------\n");
        System.out.println(lista.estaVacia());
    }
}
