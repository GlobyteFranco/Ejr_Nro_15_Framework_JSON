package models;

public class JsonInteger implements JsonElement {
    private Integer jsonInteger;

    public JsonInteger() {
    }

    public JsonInteger(Integer jsonInteger) {
        this.jsonInteger = jsonInteger;
    }

    @Override
    public String stringify() {

        return jsonInteger.toString();
    }

    @Override
    public void insertJsonElement(JsonElement jsonElement) {
        throw new IllegalStateException("The object does not support this type of insertion");
    }

    @Override
    public void insertJsonElementInLastNull(JsonElement jsonElement) {
        throw new IllegalStateException("The object does not support this type of insertion");
    }

}
