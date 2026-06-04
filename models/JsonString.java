package models;

public class JsonString implements JsonElement {
    private String jsonText;

    public JsonString() {
    }

    public JsonString(String jsonText) {
        this.jsonText = jsonText;
    }

    @Override
    public String stringify() {
        return this.jsonText;
    }

    @Override
    public void insertJsonElement(JsonElement jsonElement) {
        throw new IllegalStateException("The object does not support this type of insertion");
    }

    public String getJsonText() {
        return jsonText;
    }

    @Override
    public void insertJsonElementInLastNull(JsonElement jsonElement) {
        
    }

}
