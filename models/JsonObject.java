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
    public String stringify(int nivel) {
        StringBuilder sb = new StringBuilder();

        String spacing = "  ".repeat(nivel);
        String insideSpacing = "  ".repeat(nivel + 1);

        sb.append("{\n");

        int processed = 0;
        int total = this.jsonMap.size();

        for (Map.Entry<String, JsonElement> element : this.jsonMap.entrySet()) {
            sb.append(insideSpacing)
                    .append("\"").append(element.getKey()).append("\": ");

            if (element.getValue() != null) {
                sb.append(element.getValue().stringify(nivel + 1));
            } else {
                sb.append("null");
            }

            processed++;

            if (processed < total) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append(spacing).append("}");

        return sb.toString();
    }

    // Primero le pasamos la clave y luego el valor. <String, JsonElement> -->
    // Encapsulados en un JsonElement
    // Los elementos se ingresan siempre como JsonElement (Si es un String
    // simplemente se se transforma a ese objeto )
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JsonObject other = (JsonObject) obj;
        if (jsonMap == null) {
            if (other.jsonMap != null)
                return false;
        } else if (!jsonMap.equals(other.jsonMap))
            return false;
        return true;
    }

    @Override
    public JsonElement checkExistence(JsonElement jsonElement) {
        if (this.equals(jsonElement)) {
            return this;
        } else {
            for (Map.Entry<String, JsonElement> element : jsonMap.entrySet()) {
                if (element.getValue().checkExistence(jsonElement)!=null) {
                    return this;
                }
            }
            return null;
        }
    }
}
