package Tarea_3.ArrayADT2D.Ajedrez;

public class Tablero {

    private ArrayADT2D<Character> piezas;

    public Tablero() {

        piezas = new ArrayADT2D<>(8, 8);

        // Primero llenamos todas las casillas vacías
        piezas.rellenar(' ');

        // Piezas negras
        piezas.insertarElemento(0, 0, '♜');
        piezas.insertarElemento(0, 1, '♞');
        piezas.insertarElemento(0, 2, '♝');
        piezas.insertarElemento(0, 3, '♛');
        piezas.insertarElemento(0, 4, '♚');
        piezas.insertarElemento(0, 5, '♝');
        piezas.insertarElemento(0, 6, '♞');
        piezas.insertarElemento(0, 7, '♜');

        // Peones negros
        for (int j = 0; j < 8; j++) {
            piezas.insertarElemento(1, j, '♟');
        }

        // Peones blancos
        for (int j = 0; j < 8; j++) {
            piezas.insertarElemento(6, j, '♙');
        }

        // Piezas blancas
        piezas.insertarElemento(7, 0, '♖');
        piezas.insertarElemento(7, 1, '♘');
        piezas.insertarElemento(7, 2, '♗');
        piezas.insertarElemento(7, 3, '♕');
        piezas.insertarElemento(7, 4, '♔');
        piezas.insertarElemento(7, 5, '♗');
        piezas.insertarElemento(7, 6, '♘');
        piezas.insertarElemento(7, 7, '♖');
    }

    public void imprimir() {

        for (int i = 0; i < 8; i++) {

            System.out.print((8 - i) + " ");

            for (int j = 0; j < 8; j++) {
                System.out.print(piezas.obtenerElemento(i, j) + " ");
            }

            System.out.println();
        }
    }
}