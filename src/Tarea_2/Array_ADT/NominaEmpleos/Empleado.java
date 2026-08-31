package Tarea_2.Array_ADT.NominaEmpleos;

public class Empleado {
    private int numTrabajador;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int horasExtra;
    private float sueldoBase;
    private int añoIngreso;

    public Empleado() {
    }

    public Empleado(int numTrabajador, String nombre, String apellidoPaterno, String apellidoMaterno, int horasExtra, float sueldoBase, int añoIngreso) {
        this.numTrabajador = numTrabajador;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.añoIngreso = añoIngreso;
    }

    public int getNumTrabajador() {
        return numTrabajador;
    }

    public void setNumTrabajador(int numTrabajador) {
        this.numTrabajador = numTrabajador;
    }

    public String getNombres() {
        return nombre;
    }

    public void setNombres(String nombres) {
        this.nombre = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public float getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(float sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numTrabajador=" + numTrabajador +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", horasExtra='" + horasExtra + '\'' +
                ", sueldo=" + sueldoBase +
                ", añoIngreso=" + añoIngreso +
                '}';
    }

    public float calcularSueldo(){
        int antiguedad = 2026 - añoIngreso;
        float pagoHorasExtra = horasExtra * 276.5f;
        float prestacionAntiguedad = sueldoBase * 0.03f * antiguedad;
        return sueldoBase + pagoHorasExtra + prestacionAntiguedad;
    }
}
