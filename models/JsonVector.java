package models;

import java.util.ArrayList;
import java.util.List;

public class JsonVector implements JsonElement {
    List<JsonElement> jsonElementList = new ArrayList<>();

    public JsonVector() {
    }

    public JsonVector(List<JsonElement> jsonElementList) {
        this.jsonElementList = jsonElementList;
    }

    @Override
    public String stringify() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        this.jsonElementList.forEach(element -> stringBuilder.append(element.stringify() + ",\n"));
        stringBuilder.append("]");
        return stringBuilder.toString();

    }

    @Override
    public void insertJsonElement(JsonElement jsonElement) {
        this.jsonElementList.add(jsonElement);
    }

    

}
