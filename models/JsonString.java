package models;

public class JsonString implements JsonElement {
    private String jsonText;

    public JsonString() {
    }

    public JsonString(String jsonText) {
        this.jsonText = jsonText;
    }

    @Override
    public String stringify(int level) {
        return "\"" + this.jsonText + "\"";
    }

    @Override
    public void insertJsonElement(JsonElement jsonElement) {
        throw new IllegalStateException("The object does not support this type of insertion");
    }

    public String getJsonText() {
        return jsonText;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JsonString other = (JsonString) obj;
        if (jsonText == null) {
            if (other.jsonText != null)
                return false;
        } else if (!jsonText.equals(other.jsonText))
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
