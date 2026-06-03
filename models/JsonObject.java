package models;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonObject implements JsonElement {
    private Map<String, JsonElement> jsonMap = new LinkedHashMap<String, JsonElement>();

    public JsonObject() {
    }

    public JsonObject(Map<String, JsonElement> jsonMap) {
        this.jsonMap = jsonMap;
    }

    @Override
    public String stringify() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        jsonMap.forEach((key, value) -> stringBuilder.append(key + ":" + value.stringify() + ",\n"));
        stringBuilder.append("\n}");

        return stringBuilder.toString();
    }

    public void addJsonElement(String jsonKey, JsonElement jsonElement) {
        jsonMap.put(jsonKey, jsonElement);
    }

    // TODO usar el metodo de estado implicito. A continuacion mi explicacion a
    // Gemini que satisface la del metodo: lo que voy a hacer es, para evitar
    // agregar estado innecesario al JsonObject, hacer que el metodo valide si el
    // elemento final del mapa tiene un valor nulo. De ser el caso significa que lo
    // que le pasaron tiene que pisarlo. De no tener el ultimo elemento un valor
    // nulo, significa que lo que le pasaron es la clave, por lo que habria que
    // validar que sea un string (lo que haria es un casting) y de estar bien lo
    // insertaria como un nuevo elemento del mapa con su clave y valor nulo. En el
    // caso de querer ingresar algo que no sea un String como clave tiraria alguna
    // excepcion. A priori la de IllegalArgumentException me parece bien.
    @Override
    public void insertJsonElement(JsonElement jsonElement) {// *El jsonElement puede ser o un String como clave o un
                                                            // JsonElement cualquiera para insertar como valor
        if (jsonMap.isEmpty()) {
            if (jsonElement instanceof JsonString) {
                JsonString claveJsonMap = (JsonString) jsonElement;
                jsonMap.put(claveJsonMap.getJsonText(), null);
            } else {

                throw new IllegalArgumentException(
                        "Cannot insert a value if there is not a previous element with a key");
            }
        } else {// TODO de haber un elemento puede ser que sea uno con clave y sin valor
                // esperandolo o un elemento completo. Para el primer caso se aceptaria
                // cualquier JsonElement y se agregaria como valor y para el segundo solamente
                // un elemento JsonString


        }

    }
}
