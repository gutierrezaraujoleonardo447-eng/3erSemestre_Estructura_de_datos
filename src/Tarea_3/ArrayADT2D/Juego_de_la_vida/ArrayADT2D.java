package Tarea_3.ArrayADT2D.Juego_de_la_vida;

import java.util.Arrays;

public class ArrayADT2D<T> {
    private int fila;
    private int columna;
    private Object[][] datos;

    public ArrayADT2D(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.datos = new Object[fila][columna];
    }

    public T obtenerElemento(int indiceFila, int indiceColumna){
        if(indiceFila >= 0 && indiceColumna >= 0 && indiceFila < fila && indiceColumna < columna) {
            return (T) datos[indiceFila][indiceColumna];
        }
        else{
            System.out.println("El indice esta fuera del rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void insertarElemento(int indiceFila, int indiceColumna, T elemento){
        if(indiceFila >= 0 && indiceColumna >= 0 && indiceFila < fila && indiceColumna < columna){
            datos[indiceFila][indiceColumna]= elemento;
        }
        else{
            System.out.println("El indice esta fuera del rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int obtrenerFilas(){
        return fila;
    }

    public int obtenerColumnas(){
        return columna;
    }

    public void rellenar(T elemento){
        for(int i = 0; i < fila; i ++){
            for(int j = 0; j < columna; j++){
                datos[i][j] = elemento;
            }
        }
    }

    public void imprimir(){
        System.out.println("[");
        for(int i = 0; i < fila; i++){
            for(int j = 0; j < columna; j++){
                System.out.print(datos[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        return "ArrayADT2D{" +
                "fila=" + fila +
                ", columna=" + columna +
                ", datos=" + Arrays.deepToString(datos) +
                '}';
    }
}
