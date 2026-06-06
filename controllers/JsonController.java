package controllers;

import factories.JsonFactory;
import models.JsonDocument;
import models.JsonElement;

public class JsonController {
    JsonDocument jsonDocument;
    JsonFactory jsonFactorie;

    public JsonController(JsonDocument jsonDocument, JsonFactory jsonFactorie) {
        this.jsonDocument = jsonDocument;
        this.jsonFactorie = jsonFactorie;
    }

    public void addString(String text) {
        this.jsonDocument.addJsonObject(jsonFactorie.createJsonString(text));
    }

    public void addInt(int value) {

        this.jsonDocument.addJsonObject(jsonFactorie.createJsonInt(value));
    }

    public void addObject(String text) {
        if (text == null) {

            JsonElement jsonOjectInsertion = jsonFactorie.createEmptyJsonObject();
            jsonDocument.addJsonObject(jsonOjectInsertion);
            jsonDocument.setTargetElement(jsonOjectInsertion);
        } else {
            jsonDocument.addJsonObject(jsonFactorie.createJsonString(text));

        }

    }

    public void addArray() {
        JsonElement jsonArrayInsertion = jsonFactorie.createEmptyJsonArray();
        jsonDocument.addJsonObject(jsonArrayInsertion);
        jsonDocument.setTargetElement(jsonArrayInsertion);
    }

    public String displayJson() {
        return jsonDocument.obtainStringifiedJson();
    }
}
