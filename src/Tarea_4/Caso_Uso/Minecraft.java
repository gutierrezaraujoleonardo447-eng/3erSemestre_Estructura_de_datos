package Tarea_4.Caso_Uso;

import Tarea_4.ConjuntoADT.ConjuntoADT;

public class Minecraft {
    static void main() {

        // PRUEBA 1: Crear el conjunto de biomas

        ConjuntoADT<String> biomasDescubiertos = new ConjuntoADT<>();

        System.out.println("-------------BIOMAS DESCUBIERTOS----------------");


        // Agregamos los biomas descubiertos
        biomasDescubiertos.agregarElemento("Desierto");
        biomasDescubiertos.agregarElemento("Taiga");
        biomasDescubiertos.agregarElemento("Pantano");

        // Intentamos agregar Desierto nuevamente.
        // El conjunto no debe permitir elementos repetidos.
        biomasDescubiertos.agregarElemento("Desierto");

        System.out.println(biomasDescubiertos);
        System.out.println();



        // PRUEBA 2: Consultar la longitud del conjunto

        // Comprueba cuántos biomas diferentes hay en el conjunto.
        System.out.println("PRUEBA DE LONGITUD");
        System.out.println("Cantidad de biomas: " + biomasDescubiertos.longitud());
        System.out.println();



        // PRUEBA 3: Comprobar si contiene un elemento

        // Comprueba si el jugador ya descubrió el bioma "Desierto".
        System.out.println("PRUEBA DE CONTIENE");
        System.out.println("¿Descubrió el Desierto? " + biomasDescubiertos.contieneElemento("Desierto"));

        // Comprueba si el jugador descubrió un bioma que no está en el conjunto.
        System.out.println("¿Descubrió la Jungla? " + biomasDescubiertos.contieneElemento("Jungla"));
        System.out.println();


        // PRUEBA 4: Eliminar un bioma

        // Elimina el bioma "Pantano" de los biomas descubiertos.
        biomasDescubiertos.eliminarElemento("Pantano");

        System.out.println("PRUEBA DE ELIMINAR");
        System.out.println("Después de eliminar Pantano:");
        System.out.println(biomasDescubiertos);
        System.out.println();



        // PRUEBA 5: Crear otro conjunto de biomas

        // Representa los biomas descubiertos por otro jugador.
        ConjuntoADT<String> biomasJugador2 = new ConjuntoADT<>();

        biomasJugador2.agregarElemento("Desierto");
        biomasJugador2.agregarElemento("Jungla");
        biomasJugador2.agregarElemento("Taiga");

        System.out.println("BIOMAS DEL JUGADOR 2");
        System.out.println(biomasJugador2);
        System.out.println();



        // PRUEBA 6: Equals

        // Comprueba si ambos jugadores tienen exactamente
        // los mismos biomas descubiertos.
        System.out.println("PRUEBA DE EQUALS");
        System.out.println("¿Los conjuntos son iguales? " + biomasDescubiertos.equals(biomasJugador2));
        System.out.println();



        // PRUEBA 7: Subconjunto

        // Comprueba si todos los biomas del jugador 1
        // también fueron descubiertos por el jugador 2.
        System.out.println("PRUEBA DE SUBCONJUNTO");
        System.out.println("¿Los biomas del jugador 1 son subconjunto " + "de los del jugador 2? " + biomasDescubiertos.esSubConjunto(biomasJugador2));
        System.out.println();


        // PRUEBA 8: Unión

        // Crea un nuevo conjunto con todos los biomas
        // descubiertos por ambos jugadores, sin repetirlos.
        ConjuntoADT<String> union = biomasDescubiertos.union(biomasJugador2);

        System.out.println("PRUEBA DE UNION");
        System.out.println("Biomas descubiertos entre ambos jugadores:");
        System.out.println(union);
        System.out.println();



        // PRUEBA 9: Intersección

        // Crea un nuevo conjunto con los biomas que
        // ambos jugadores tienen descubiertos.
        ConjuntoADT<String> interseccion =
                biomasDescubiertos.interseccion(biomasJugador2);

        System.out.println("PRUEBA DE INTERSECCION");
        System.out.println("Biomas descubiertos por ambos jugadores:");
        System.out.println(interseccion);
        System.out.println();



        // PRUEBA 10: Diferencia
        // Crea un nuevo conjunto con los biomas que
        // tiene el jugador 1 pero que no tiene el jugador 2.
        ConjuntoADT<String> diferencia =
                biomasDescubiertos.diferencia(biomasJugador2);

        System.out.println("PRUEBA DE DIFERENCIA");
        System.out.println("Biomas que tiene el jugador 1 y no el jugador 2:");
        System.out.println(diferencia);
        System.out.println();
    }

}
