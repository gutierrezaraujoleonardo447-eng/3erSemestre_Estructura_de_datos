package Práctica.Examen;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Comparator;

public class Main {

    // Clase auxiliar para almacenar empleado y prioridad
    static class EmpleadoPrioridad {
        Empleado empleado;
        int prioridad;

        public EmpleadoPrioridad(int prioridad, Empleado empleado) {
            this.prioridad = prioridad;
            this.empleado = empleado;
        }

        @Override
        public String toString() {
            return "Prioridad: " + prioridad + " - " + empleado;
        }
    }

    public static void main(String[] args) {

        // Crear empleados de prueba
        Empleado e1 = new Empleado(
                1001, "Carlos", "Lopez", "Garcia", 5, 10000.0, 2020);

        Empleado e2 = new Empleado(
                1002, "Ana", "Perez", "Ramirez", 3, 12000.0, 2019);

        Empleado e3 = new Empleado(
                1003, "Pedro", "Hernandez", "Ruiz", 2, 9500.0, 2022);

        Empleado e4 = new Empleado(
                1004, "Maria", "Sanchez", "Torres", 4, 11000.0, 2021);


        // ==================================================
        // 1. ARREGLO DE JAVA
        // ==================================================

        System.out.println("\n===== 1. ARREGLO =====");

        Empleado[] empleados = new Empleado[3];

        // Insertar
        empleados[0] = e1;
        empleados[1] = e2;
        empleados[2] = e3;

        // Obtener
        System.out.println("Elemento en indice 1: " + empleados[1]);

        // Longitud
        System.out.println("Longitud: " + empleados.length);

        // Recorrer
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Indice " + i + ": " + empleados[i]);
        }

        // Actualizar
        empleados[1] = e4;
        System.out.println("Actualizado indice 1: " + empleados[1]);

        // Buscar
        boolean encontrado = false;

        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].equals(e2)) {
                System.out.println("Empleado encontrado en indice " + i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("e2 no se encuentra en el arreglo");
        }


        // ==================================================
        // 2. ARREGLO BIDIMENSIONAL
        // ==================================================

        System.out.println("\n===== 2. ARREGLO 2D =====");

        Empleado[][] empleados2D = new Empleado[2][3];

        // Insertar
        empleados2D[0][0] = e1;
        empleados2D[0][1] = e2;
        empleados2D[0][2] = e3;
        empleados2D[1][0] = e4;
        empleados2D[1][1] = e1;
        empleados2D[1][2] = e2;

        // Obtener
        System.out.println("Elemento [0][1]: " + empleados2D[0][1]);

        // Filas y columnas
        System.out.println("Filas: " + empleados2D.length);
        System.out.println("Columnas de la primera fila: "
                + empleados2D[0].length);

        // Recorrer y buscar
        for (int fila = 0; fila < empleados2D.length; fila++) {
            for (int columna = 0;
                 columna < empleados2D[fila].length;
                 columna++) {

                System.out.println("[" + fila + "][" + columna + "]: "
                        + empleados2D[fila][columna]);

                if (empleados2D[fila][columna].equals(e3)) {
                    System.out.println("e3 encontrado en ["
                            + fila + "][" + columna + "]");
                }
            }
        }

        // Actualizar
        empleados2D[1][2] = e4;
        System.out.println("Nuevo valor de [1][2]: "
                + empleados2D[1][2]);


        // ==================================================
        // 3. CONJUNTOS
        // ==================================================

        System.out.println("\n===== 3. CONJUNTOS =====");

        Set<Empleado> conjuntoA = new HashSet<>();
        Set<Empleado> conjuntoB = new HashSet<>();

        // Agregar
        conjuntoA.add(e1);
        conjuntoA.add(e2);
        conjuntoA.add(e3);

        conjuntoB.add(e2);
        conjuntoB.add(e3);
        conjuntoB.add(e4);

        // Longitud
        System.out.println("Longitud A: " + conjuntoA.size());

        // Contiene
        System.out.println("A contiene e1: " + conjuntoA.contains(e1));

        // Intentar agregar un elemento repetido
        conjuntoA.add(e1);
        System.out.println("Longitud A tras repetir e1: "
                + conjuntoA.size());

        // Eliminar
        conjuntoA.remove(e1);
        System.out.println("A contiene e1 tras eliminarlo: "
                + conjuntoA.contains(e1));

        // Equals: comprobar conjuntos con los mismos elementos
        Set<Empleado> conjuntoC = new HashSet<>();
        conjuntoC.add(e2);
        conjuntoC.add(e3);

        System.out.println("A es igual a C: " + conjuntoA.equals(conjuntoC));

        // Subconjunto: todos los elementos de B están en A
        System.out.println("B es subconjunto de A: "
                + conjuntoA.containsAll(conjuntoB));

        // Unión: A U B
        Set<Empleado> union = new HashSet<>(conjuntoA);
        union.addAll(conjuntoB);
        System.out.println("Union: " + union);

        // Intersección: elementos comunes
        Set<Empleado> interseccion = new HashSet<>(conjuntoA);
        interseccion.retainAll(conjuntoB);
        System.out.println("Interseccion: " + interseccion);

        // Diferencia: A - B
        Set<Empleado> diferencia = new HashSet<>(conjuntoA);
        diferencia.removeAll(conjuntoB);
        System.out.println("Diferencia A - B: " + diferencia);


        // ==================================================
        // 4. LISTA LIGADA
        // ==================================================

        System.out.println("\n===== 4. LISTA LIGADA =====");

        LinkedList<Empleado> lista = new LinkedList<>();

        // esta_vacia
        System.out.println("Esta vacia: " + lista.isEmpty());

        // Agregar al final
        lista.add(e1);
        lista.add(e2);
        lista.add(e3);

        // agregar_al_final
        lista.addLast(e4);

        // agregar_al_inicio
        lista.addFirst(e4);

        System.out.println("Lista: " + lista);
        System.out.println("Tamanio: " + lista.size());

        // Agregar despues de una referencia
        int posicionReferencia = lista.indexOf(e2);

        if (posicionReferencia != -1) {
            lista.add(posicionReferencia + 1, e3);
        }

        System.out.println("Despues de agregar despues de e2: " + lista);

        // Buscar: regresa la posición de la primera coincidencia
        int posicion = lista.indexOf(e3);
        System.out.println("Primera posicion de e3: " + posicion);

        // Actualizar la primera coincidencia de e3 por e1
        posicion = lista.indexOf(e3);

        if (posicion != -1) {
            lista.set(posicion, e1);
        }

        System.out.println("Lista despues de actualizar: " + lista);

        // Eliminar el primero
        if (!lista.isEmpty()) {
            Empleado primero = lista.removeFirst();
            System.out.println("Eliminado del inicio: " + primero);
        }

        // Eliminar el final
        if (!lista.isEmpty()) {
            Empleado ultimo = lista.removeLast();
            System.out.println("Eliminado del final: " + ultimo);
        }

        // transversal: recorrer
        System.out.println("Recorrido de la lista:");

        for (Empleado empleado : lista) {
            System.out.println(empleado);
        }

        System.out.println("Tamanio final: " + lista.size());
        System.out.println("Esta vacia: " + lista.isEmpty());


        // ==================================================
        // 5. LISTA DOBLEMENTE LIGADA
        // ==================================================

        System.out.println("\n===== 5. LISTA DOBLEMENTE LIGADA =====");

        // LinkedList de Java tiene enlaces en ambos sentidos
        LinkedList<Empleado> listaDoble = new LinkedList<>();

        listaDoble.addLast(e1);
        listaDoble.addLast(e2);
        listaDoble.addLast(e3);

        System.out.println("Recorrido hacia adelante:");

        for (Empleado empleado : listaDoble) {
            System.out.println(empleado);
        }

        System.out.println("Recorrido hacia atras:");

        for (int i = listaDoble.size() - 1; i >= 0; i--) {
            System.out.println(listaDoble.get(i));
        }

        System.out.println("Primer elemento: " + listaDoble.getFirst());
        System.out.println("Ultimo elemento: " + listaDoble.getLast());


        // ==================================================
        // 6. COLA NORMAL
        // ==================================================

        System.out.println("\n===== 6. COLA NORMAL =====");

        Queue<Empleado> cola = new LinkedList<>();

        // estaVacia
        System.out.println("Esta vacia: " + cola.isEmpty());

        // encolar
        cola.offer(e1);
        cola.offer(e2);
        cola.offer(e3);

        // longitud
        System.out.println("Longitud: " + cola.size());

        // frente: consultar sin sacar
        System.out.println("Frente: " + cola.peek());
        System.out.println("Longitud tras consultar: " + cola.size());

        // desEncolar: sacar el frente
        System.out.println("Desencolado: " + cola.poll());
        System.out.println("Cola despues de desencolar: " + cola);

        // Mostrar estado y vaciar
        while (!cola.isEmpty()) {
            System.out.println("Sale de la cola: " + cola.poll());
        }

        System.out.println("Esta vacia al final: " + cola.isEmpty());


        // ==================================================
        // 7. COLA DE PRIORIDAD SIN LIMITE DE NIVELES
        // ==================================================

        System.out.println("\n===== 7. COLA DE PRIORIDAD =====");

        // Prioridad numérica mayor = sale primero
        PriorityQueue<EmpleadoPrioridad> colaPrioridad =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                (EmpleadoPrioridad ep) -> ep.prioridad
                        ).reversed()
                );

        // encolar(prioridad, empleado)
        colaPrioridad.offer(new EmpleadoPrioridad(1, e1));
        colaPrioridad.offer(new EmpleadoPrioridad(3, e2));
        colaPrioridad.offer(new EmpleadoPrioridad(2, e3));
        colaPrioridad.offer(new EmpleadoPrioridad(3, e4));

        System.out.println("Longitud: " + colaPrioridad.size());
        System.out.println("Esta vacia: " + colaPrioridad.isEmpty());

        // desencolar según prioridad
        while (!colaPrioridad.isEmpty()) {
            System.out.println("Sale: " + colaPrioridad.poll());
        }


        // ==================================================
        // 8. COLA DE PRIORIDAD ACOTADA: NIVELES 1 A 3
        // ==================================================

        System.out.println("\n===== 8. COLA DE PRIORIDAD ACOTADA =====");

        int niveles = 3;

        PriorityQueue<EmpleadoPrioridad> colaAcotada =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                (EmpleadoPrioridad ep) -> ep.prioridad
                        ).reversed()
                );

        // Solo se aceptan prioridades del 1 al 3
        agregarAcotado(colaAcotada, niveles, 1, e1);
        agregarAcotado(colaAcotada, niveles, 3, e2);
        agregarAcotado(colaAcotada, niveles, 2, e3);
        agregarAcotado(colaAcotada, niveles, 4, e4); // inválida

        System.out.println("Longitud: " + colaAcotada.size());
        System.out.println("Esta vacia: " + colaAcotada.isEmpty());

        while (!colaAcotada.isEmpty()) {
            System.out.println("Sale: " + colaAcotada.poll());
        }


        // ==================================================
        // 9. PILA
        // ==================================================

        System.out.println("\n===== 9. PILA =====");

        Stack<Empleado> pila = new Stack<>();

        // isEmpty
        System.out.println("Esta vacia: " + pila.isEmpty());

        // push: agregar al tope
        pila.push(e1);
        pila.push(e2);
        pila.push(e3);

        // length
        System.out.println("Longitud: " + pila.size());

        // peek: consultar sin sacar
        System.out.println("Tope: " + pila.peek());
        System.out.println("Longitud despues de peek: " + pila.size());

        // pop: sacar del tope
        System.out.println("Sale del tope: " + pila.pop());

        System.out.println("Pila actual: " + pila);

        // Vaciar la pila
        while (!pila.isEmpty()) {
            System.out.println("Sale del tope: " + pila.pop());
        }

        System.out.println("Esta vacia al final: " + pila.isEmpty());
    }


    // Metodo auxiliar para validar los niveles de prioridad
    public static void agregarAcotado(
            PriorityQueue<EmpleadoPrioridad> cola,
            int niveles,
            int prioridad,
            Empleado empleado) {

        if (prioridad >= 1 && prioridad <= niveles) {
            cola.offer(new EmpleadoPrioridad(prioridad, empleado));
        } else {
            System.out.println("Prioridad invalida: " + prioridad
                    + ". Los niveles permitidos son del 1 al " + niveles);
        }
    }
}

