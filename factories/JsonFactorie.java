package factories;

import models.JsonElement;
import models.JsonInteger;
import models.JsonString;

public class JsonFactorie {
    public JsonElement createJsonString(String text) {
        return new JsonString(text);
    }

    public JsonElement createJsonInt(int value) {
        return new JsonInteger(value);
    }

    public JsonElement createJsonObject() {
        // TODO hacer xs
        return null;

    }

    public JsonElement createJsonArray() {
        // TODO hacer xs
        return null;

    }
}
