package Tarea_2.Array_ADT.NominaEmpleos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NominaICO {
    private ArrayADT<Empleado> datos;
    private String rutaArchivo;

    public NominaICO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void leerArchivo() {

        int cantidad = 0;

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(rutaArchivo));

            // Contar los empleados
            br.readLine();

            while (br.readLine() != null) {
                cantidad++;
            }

            br.close();

            datos = new ArrayADT<>(cantidad);

            // Volver a abrir el archivo
            br = new BufferedReader(
                    new FileReader(rutaArchivo));

            // Saltar encabezado
            br.readLine();

            String linea;
            int i = 0;

            while ((linea = br.readLine()) != null) {

                String[] campos = linea.split(",");

                int numTrabajador =
                        Integer.parseInt(campos[0]);

                String nombre = campos[1];

                String paterno = campos[2];

                String materno = campos[3];

                int horasExtra =
                        Integer.parseInt(campos[4]);

                float sueldoBase =
                        Float.parseFloat(campos[5]);

                int anioIngreso =
                        Integer.parseInt(campos[6]);

                Empleado empleado = new Empleado(
                        numTrabajador,
                        nombre,
                        paterno,
                        materno,
                        horasExtra,
                        sueldoBase,
                        anioIngreso
                );

                datos.insertarElemento(i, empleado);

                i++;
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    public Empleado mayorAntiguedad() {

        Empleado mayor = datos.obtenerElemento(0);

        for (int i = 1; i < datos.longitud(); i++) {

            Empleado empleado = datos.obtenerElemento(i);

            if (empleado.getAñoIngreso() <
                    mayor.getAñoIngreso()) {

                mayor = empleado;
            }
        }

        return mayor;
    }

    public Empleado menorAntiguedad() {

        Empleado menor = datos.obtenerElemento(0);

        for (int i = 1; i < datos.longitud(); i++) {

            Empleado empleado = datos.obtenerElemento(i);

            if (empleado.getAñoIngreso()>
                    menor.getAñoIngreso()) {

                menor = empleado;
            }
        }

        return menor;
    }

    public void imprimirNomina() {

        for (int i = 0; i < datos.longitud(); i++) {

            Empleado empleado = datos.obtenerElemento(i);

            System.out.println("----------------------------------------");
            System.out.println(empleado);
            System.out.println("Sueldo a pagar: $" + empleado.calcularSueldo());
        }

        System.out.println("----------------------------------------");
    }
}
