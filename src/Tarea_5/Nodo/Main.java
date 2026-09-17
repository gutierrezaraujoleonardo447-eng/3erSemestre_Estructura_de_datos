package Tarea_5.Nodo;

public class Main {
    static void main() {
        System.out.println("--------------Creación de lista enlazada e impresión del estado inicial-----------\n");
        Nodo <String> head = new Nodo("Al", new Nodo("B", new Nodo("C", new Nodo("De", new Nodo("Mc", new Nodo("Zi"))))));
        System.out.println(head);

        System.out.println("\n--------Impresión del primer dato del primer nodo-------\n");
        System.out.println(head.getDato());

        System.out.println("\n------Impresión del estado completo del ultimo nodo-------\n");
        Nodo cursor = head;
        while (cursor.getSiguiente() != null){
            cursor = cursor.getSiguiente();
        }
        System.out.println(cursor);

        System.out.println("\n----------Insertar nodo con valor de Fe----------\n");
        Nodo actual = head;
        while (!(actual.getDato().equals("De"))){
            actual = actual.getSiguiente();
        }
        Nodo rfMc = actual.getSiguiente();
        Nodo <String> fe = new Nodo<>("Fe", rfMc);
        actual.setSiguiente(fe);
        System.out.println(head);

        System.out.println("\n--------Insertar Nodo con valor de Z-------------\n");
        Nodo tmp = head;
        while(tmp.getSiguiente() != null){
            tmp = tmp.getSiguiente();
        }

        Nodo rfNull =  tmp.getSiguiente();
        Nodo <String> Zz = new Nodo<>("Zz", rfNull);
        tmp.setSiguiente(Zz);
        System.out.println(head);

        System.out.println("\n--------------Insertar nodo con valor de Aa-----------\n");
        Nodo <String> Aa = new Nodo<>("Aa", head);
        head = Aa;
        System.out.println(head);



    }
}
