package models;

public interface JsonElement {
    public String stringify();

    public void insertJsonElement(JsonElement jsonElement);

    public void insertJsonElementInLastNull(JsonElement jsonElement);

}