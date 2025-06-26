import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        //Ejemplo de uso de la clase PilaCompleta

        /*List<Object> lista = List.of("Elemento 1", "Elemento 2", "Elemento 3", 24, 42, 3.14, true, 'A', "Elemento 4");
        PilaCompleta pilaCompleta = new PilaCompleta();
        System.out.println("Ingresando Datos: \n");
        pilaCompleta.pushAll(lista);
        pilaCompleta.viewAll();
        System.out.println("\nEliminando Datos: \n");
        pilaCompleta.popAll();
        pilaCompleta.viewAll();*/

        //Ejemplo de uso de la clase HashMapNulos

        /*HashMapNulos hashMapNulos = new HashMapNulos();
        System.out.println("Insertando Valores: \n");
        System.out.println(hashMapNulos.put(1, "Valor 1"));
        System.out.println(hashMapNulos.put(2, null));

        System.out.println("\nMostrando Valores: \n");

        System.out.println("Valor asociado a la clave 1: " +hashMapNulos.get(1));
        System.out.println("Valor asociado a la clave 2: " +hashMapNulos.get(2));*/

        //Ejemplo de uso de metodo addOddElements

        /*List<Object> fuente = List.of("Elemento 1", "Elemento 2", "Elemento 3", 24, 42, 3.14, true, 'A', "Elemento 4");
        List<Object> destino = new ArrayList<>();
        System.out.println("Copiando datos de la fuente al destino: \n");
        Util util = new Util();
        util.addOddElements(fuente, destino);

        System.out.println("Datos en lista destino: \n");
        for (Object elemento : destino) {
            System.out.println(elemento);
        }*/

    }
}