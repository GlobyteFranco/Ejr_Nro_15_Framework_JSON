package models;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonObject implements JsonElement {
    private Map<String, JsonElement> jsonMap = new LinkedHashMap<String, JsonElement>();

    private String waitingStringKey = "";

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

    // Primero le pasamos la clave y luego el valor. <String, JsonElement> -->
    // Encapsulados en un JsonElement
    @Override
    public void insertJsonElement(JsonElement jsonElement) {

        if (waitingStringKey.trim().isEmpty()) {

            if (jsonElement instanceof JsonString) {
                JsonString claveJsonMap = (JsonString) jsonElement;
                if (claveJsonMap.getJsonText().trim().isEmpty()) {
                    throw new IllegalStateException("Blank space cannot be a key in this program dude");
                }
                waitingStringKey = claveJsonMap.getJsonText();
            } else {

                throw new IllegalArgumentException(
                        "Cannot insert a value if there is not a previous element with a key");
            }
        } else {
            jsonMap.put(waitingStringKey, jsonElement);
            waitingStringKey = "";

        }

    }

    @Override
    public void insertJsonElementInLastNull(JsonElement jsonElement) {
        // *Esta funcion se deberia usar cuando quiero agregar un JsonObject o
        // JsonVector, porque voy a dejar el objeto padre como null para empezar un
        // nuevo algoritmo hijo aparte (solo podemos hacer un objeto a la vez por las
        // limitaciones de la consola) y cuando tengamos el nuevo objeto insertarlo en
        // el ultimo elemento hijo que dejamos para ser insertado. Lo ideal seria poder
        // dejar varias generaciones de objetos null para que la funcion sepa donde
        // ingresar datos o donde puede llegar a hacerlo. El elemento nulo deberia ser
        // el ultimo por generacion
        // TODO 1. Ubicar si hay un elemento nulo
        // TODO 2. Insertar en este
        jsonMap.forEach((key, value) -> {
            if (value == null) {
                jsonMap.replace(key, jsonElement);

            } else {
                value.insertJsonElementInLastNull(jsonElement);
            }
        });
    }
}
