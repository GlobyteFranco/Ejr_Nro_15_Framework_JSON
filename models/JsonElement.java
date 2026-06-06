package models;

public interface JsonElement {
    public String stringify(int level);

    public void insertJsonElement(JsonElement jsonElement);

    public JsonElement checkExistence(JsonElement jsonElement);
}