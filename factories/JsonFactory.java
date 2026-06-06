package factories;

import models.JsonElement;
import models.JsonInteger;
import models.JsonObject;
import models.JsonString;
import models.JsonVector;

public class JsonFactory {
    public JsonElement createJsonString(String text) {
        return new JsonString(text);
    }

    public JsonElement createJsonInt(int value) {
        return new JsonInteger(value);
    }

    public JsonElement createEmptyJsonObject() {
        return new JsonObject();

    }

    public JsonElement createEmptyJsonArray() {
        return new JsonVector();

    }
}
