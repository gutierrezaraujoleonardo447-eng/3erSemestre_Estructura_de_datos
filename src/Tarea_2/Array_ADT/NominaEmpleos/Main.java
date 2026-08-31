package Tarea_2.Array_ADT.NominaEmpleos;

public class Main {
    static void main() {
        String rutaArchivo = "junio.dat";

        NominaICO nomina = new NominaICO(rutaArchivo);

        nomina.leerArchivo();


        System.out.println("---------TRABAJADOR CON MAYOR ANTIGÜEDAD--------------");
        Empleado mayor = nomina.mayorAntiguedad();
        System.out.println(mayor);
        System.out.println("Sueldo a pagar: $" + mayor.calcularSueldo());

        System.out.println("\n--------------------TRABAJADOR CON MENOR ANTIGÜEDAD----------------------\n");
        Empleado menor = nomina.menorAntiguedad();
        System.out.println(menor);
        System.out.println("Sueldo a pagar: $" + menor.calcularSueldo());

        System.out.println("\n-------------NÓMINA DE JUNIO---------------\n");
        nomina.imprimirNomina();
    }
}

