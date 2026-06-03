package models;

//TODO hacer una factorie para crear distintos tipos de json basados en la misma interfaz
//TODO validaciones mediante excpeciones si el orden de los elementos Json desembocan en un formato invalido
public class JsonDocument {
    JsonElement jsonDocumentContent;

    public JsonDocument() {
    }

    public JsonDocument(JsonElement jsonDocumentContent) {
        this.jsonDocumentContent = jsonDocumentContent;
    }

    public void addJsonObject(JsonElement jsonObject) {
        this.jsonDocumentContent = jsonObject;
    }

    public String obtainJson() {
        return jsonDocumentContent.stringify();
    }
}
