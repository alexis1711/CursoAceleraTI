import java.util.HashMap;

public class HashMapNulos extends HashMap {

    @Override
    public Object put(Object key, Object value){
        if(value == null){
            return "El valor no puede ser nulo";
        }
        super.put(key, value);
        return "clave: " + key + ", valor: " + value + " agregado correctamente";
    }

    @Override
    public Object get(Object key){
        Object value = super.get(key);
        if(value == null){
            value = "";
        }
        return value;
    }

}
