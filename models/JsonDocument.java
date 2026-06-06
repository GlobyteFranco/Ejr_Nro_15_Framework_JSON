package models;

//TODO hacer una factorie para crear distintos tipos de json basados en la misma interfaz
//TODO validaciones mediante excpeciones si el orden de los elementos Json desembocan en un formato invalido
public class JsonDocument {
    // TODO Cuando queremos insertar un objeto, lo hacemos como de costumbre y
    // actualizamos el target a este
    private JsonElement jsonDocumentContent;
    private JsonElement jsonElementTarget;

    public JsonDocument() {
    }

    public JsonDocument(JsonElement jsonDocumentContent) {
        this.jsonDocumentContent = jsonDocumentContent;
    }

    public void addJsonObject(JsonElement jsonObject) {// Esto es para agregar datos

        if (jsonDocumentContent == null) {
            this.jsonDocumentContent = jsonObject;
            jsonElementTarget = jsonObject;
        } else {
            jsonElementTarget.insertJsonElement(jsonObject);
        }
    }

    public void setTargetElement(JsonElement jsonElement) {// Esto para cuando queremos bajar el scope
        this.jsonElementTarget = jsonElement;
    }

    public void zoomOutScope() {
        // TODO aca cambiariamos al target por su padre
        JsonElement newElementTarget = jsonDocumentContent.checkExistence(jsonElementTarget);
        if (newElementTarget != null) {
            this.jsonElementTarget = newElementTarget;
        } else {
            throw new IllegalAccessError("Cannot zoom out of the top element");
        }
    }

    public String obtainStringifiedJson() {
        return jsonDocumentContent.stringify(0);
    }

    public JsonElement getJsonDocumentContent() {
        return jsonDocumentContent;
    }

    public JsonElement getJsonElementTarget() {
        return jsonElementTarget;
    }

}
