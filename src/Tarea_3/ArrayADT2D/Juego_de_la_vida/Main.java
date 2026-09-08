package Tarea_3.ArrayADT2D.Juego_de_la_vida;

public class Main {
    static void main() {
        String rutaArchivo = "JuegoVida.csv";

        JuegoVida juego = new JuegoVida(rutaArchivo);

        System.out.println("GENERACION 0");
        juego.imprimir();

        for (int generacion = 1; generacion <= 10; generacion++) {

            juego.siguienteGeneracion();

            System.out.println();
            System.out.println("GENERACION " + generacion);

            juego.imprimir();
        }
    }
}
