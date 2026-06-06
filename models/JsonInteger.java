package models;

public class JsonInteger implements JsonElement {
    private Integer jsonInteger;

    public JsonInteger() {
    }

    public JsonInteger(Integer jsonInteger) {
        this.jsonInteger = jsonInteger;
    }

    @Override
    public String stringify(int level) {

        return jsonInteger.toString();
    }

    @Override
    public void insertJsonElement(JsonElement jsonElement) {
        throw new IllegalStateException("The object does not support this type of insertion");
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JsonInteger other = (JsonInteger) obj;
        if (jsonInteger == null) {
            if (other.jsonInteger != null)
                return false;
        } else if (!jsonInteger.equals(other.jsonInteger))
            return false;
        return true;
    }

    @Override
    public JsonElement checkExistence(JsonElement jsonElement) {
        if (this.equals(jsonElement)) {
            return this;
        } else {
            return null;
        }
    }

    

   

}
