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

    @Override
    public void insertJsonElement(JsonElement jsonElement) {
        throw new IllegalAccessError();
    }
}
