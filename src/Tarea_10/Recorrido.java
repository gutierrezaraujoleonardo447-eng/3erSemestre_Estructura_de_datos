package Tarea_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Recorrido {
    public void bfs(Nodo inicio) {
        System.out.println("===== BFS =====");
        ArrayList<Nodo> visitados = new ArrayList<>();
        LinkedList<Nodo> cola = new LinkedList<>();
        cola.add(inicio);
        int paso = 1;

        while (!cola.isEmpty()) {
            Nodo actual = cola.removeFirst(); // sale el primero
            visitados.add(actual);

            for (Nodo vecino : actual.vecinos) {
                if (!visitados.contains(vecino) && !cola.contains(vecino)) {
                    cola.add(vecino);
                }
            }

            System.out.println("Paso " + paso + " | Actual: " + actual
                    + " | Visitados: " + visitados + " | Cola: " + cola);
            paso++;
        }
        System.out.println("Secuencia BFS: " + visitados + "\n");
    }

    public void dfs(Nodo inicio) {
        System.out.println("===== DFS =====");
        ArrayList<Nodo> visitados = new ArrayList<>();
        ArrayList<Nodo> noVisitados = new ArrayList<>();
        noVisitados.add(inicio);
        int paso = 1;

        while (!noVisitados.isEmpty()) {
            Nodo actual = noVisitados.remove(noVisitados.size() - 1); // sale el último
            visitados.add(actual);

            for (Nodo vecino : actual.vecinos) {
                if (!visitados.contains(vecino) && !noVisitados.contains(vecino)) {
                    noVisitados.add(vecino);
                }
            }

            System.out.println("Paso " + paso + " | Visitado: " + visitados
                    + " | No visitado: " + noVisitados);
            paso++;
        }
        System.out.println("Secuencia DFS: " + visitados + "\n");
    }
}
