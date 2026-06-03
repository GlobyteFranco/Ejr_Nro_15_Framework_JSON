package models;

//TODO hacer una factorie para crear distintos tipos de json basados en la misma interfaz
//TODO validaciones mediante excpeciones si el orden de los elementos Json desembocan en un formato invalido
public class JsonDocument {
    //TODO Hacer una algoritmo de insercin recursiva que valide si estamos insertando en el documento JSON o en otro objeto/ vector Json. Si se da el primer caso insertamos directament el la clase, sino tenemos que ir al ultimo elemento y adentro suyo meterle algo, si nos deja
    // TODO para agregar Objetos y Vectores hacer algoritmos distintos pero en
    // funcion de JsonElement asi los pudeo usar con cualquiera
    JsonElement jsonDocumentContent;

    public JsonDocument() {
    }

    public JsonDocument(JsonElement jsonDocumentContent) {
        this.jsonDocumentContent = jsonDocumentContent;
    }

    public void addJsonObject(JsonElement jsonObject) {

        if (jsonDocumentContent == null) {
            this.jsonDocumentContent = jsonObject;
        } else {
            throw new IllegalStateException("There is already a Json element in this document");
        }
    }

    public String obtainStringifiedJson() {
        return jsonDocumentContent.stringify();
    }

    public JsonElement obtainDocumentJson() {
        return jsonDocumentContent;
    }
}
