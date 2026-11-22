package Tarea_10;

public class Main {
    static void main() {
        Grafo grafo = new Grafo();

        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (String l : letras) {
            grafo.agregarNodo(l);
        }

        // Aristas en orden alfabético
        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("B", "E");
        grafo.agregarArista("C", "F");
        grafo.agregarArista("C", "G");
        grafo.agregarArista("D", "H");
        grafo.agregarArista("E", "H");
        grafo.agregarArista("E", "I");
        grafo.agregarArista("F", "I");
        grafo.agregarArista("F", "J");
        grafo.agregarArista("G", "J");
        grafo.agregarArista("H", "I");
        grafo.agregarArista("I", "J");

        Recorrido recorrido = new Recorrido();
        recorrido.bfs(grafo.getNodo("A"));
        recorrido.dfs(grafo.getNodo("A"));
    }
}