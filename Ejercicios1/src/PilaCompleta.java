import java.util.List;
import java.util.Stack;

public class PilaCompleta extends Stack {

    public String pushAll(List items){
        for(Object item : items){
            if(item == null){
                throw new NullPointerException("No se puede agregar un elemento nulo a la pila");
            }
            super.push(item);
        }

        return "Todos los elementos han sido agregados a la pila";
    }

    public void popAll(){
        super.clear();
    }

    public void viewAll(){
        System.out.println("Datos en pila: \n");
        if(this.size() == 0){
            System.out.println("La pila esta vacia.");
        }else{
            for(Object elemento : this){
                System.out.println(elemento);
            }
        }
    }

}
