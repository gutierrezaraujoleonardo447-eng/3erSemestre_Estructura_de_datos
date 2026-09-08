package Tarea_3.ArrayADT2D.Juego_de_la_vida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JuegoVida {
    private ArrayADT2D<Integer> tablero;

    public JuegoVida(String rutaArchivo) {
        tablero = leerArchivo(rutaArchivo);
    }

    private ArrayADT2D<Integer> leerArchivo(String rutaArchivo) {

        ArrayADT2D<Integer> resultado = new ArrayADT2D<>(10, 10);

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            String linea;
            int i = 0;

            while ((linea = br.readLine()) != null && i < 10) {

                String[] valores = linea.split(",");

                for (int j = 0; j < valores.length && j < 10; j++) {
                    resultado.insertarElemento(i, j, Integer.parseInt(valores[j].trim()));
                }
                i++;
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        return resultado;
    }

    public int contarVecinosVivos(int fila, int columna) {

        int vecinosVivos = 0;

        for (int i = fila - 1; i <= fila + 1; i++) {

            for (int j = columna - 1; j <= columna + 1; j++) {

                if (i >= 0 && i < tablero.obtrenerFilas() &&
                        j >= 0 && j < tablero.obtenerColumnas()) {

                    if (!(i == fila && j == columna)) {

                        if (tablero.obtenerElemento(i, j) == 1) {
                            vecinosVivos++;
                        }
                    }
                }
            }
        }

        return vecinosVivos;
    }

    public void siguienteGeneracion() {

        ArrayADT2D<Integer> nuevaGeneracion =
                new ArrayADT2D<>(tablero.obtrenerFilas(), tablero.obtenerColumnas());

        for (int i = 0; i < tablero.obtrenerFilas(); i++) {

            for (int j = 0; j < tablero.obtenerColumnas(); j++) {

                int vecinos = contarVecinosVivos(i, j);

                int estadoActual = tablero.obtenerElemento(i, j);

                if (estadoActual == 1) {

                    if (vecinos == 2 || vecinos == 3) {
                        nuevaGeneracion.insertarElemento(i, j, 1);
                    } else {
                        nuevaGeneracion.insertarElemento(i, j, 0);
                    }

                } else {

                    if (vecinos == 3) {
                        nuevaGeneracion.insertarElemento(i, j, 1);
                    } else {
                        nuevaGeneracion.insertarElemento(i, j, 0);
                    }
                }
            }
        }

        tablero = nuevaGeneracion;
    }

    public void imprimir() {
        tablero.imprimir();
    }
}
