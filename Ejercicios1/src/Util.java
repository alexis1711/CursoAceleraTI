import java.util.List;

public class Util{

    public void addOddElements(List fuente, List destino){
        for(int i = 0; i < fuente.size(); i++){
            if((i % 2) == 0){
                destino.add(fuente.get(i));
            }
        }
    }

}
