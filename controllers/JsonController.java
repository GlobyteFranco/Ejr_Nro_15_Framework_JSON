package controllers;

import factories.JsonFactorie;
import models.JsonDocument;

public class JsonController {
    JsonDocument jsonDocument;
    JsonFactorie jsonFactorie;

    public JsonController(JsonDocument jsonDocument, JsonFactorie jsonFactorie) {
        this.jsonDocument = jsonDocument;
        this.jsonFactorie = jsonFactorie;
    }

    public void addString(String text) {
        this.jsonDocument.addJsonObject(jsonFactorie.createJsonString(text));
    }

    public void addInt(int value) {

        this.jsonDocument.addJsonObject(jsonFactorie.createJsonInt(value));
    }

    public void addObject() {// TODO Tenemos que hacer una version del object que entienda el view y
                             // pasarsela por parametros solamente de tipos primitivos

    }

    public void addArray() {// TODO Idem

    }
}
