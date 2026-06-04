package models;

//TODO hacer una factorie para crear distintos tipos de json basados en la misma interfaz
//TODO validaciones mediante excpeciones si el orden de los elementos Json desembocan en un formato invalido
public class JsonDocument {
    // TODO Hacer una algoritmo de insercin recursiva que valide si estamos
    // insertando en el documento JSON o en otro objeto/ vector Json. Si se da el
    // primer caso insertamos directament el la clase, sino tenemos que ir al ultimo
    // elemento y adentro suyo meterle algo, si nos deja
    // TODO para agregar Objetos y Vectores hacer algoritmos distintos pero en
    // funcion de JsonElement asi los pudeo usar con cualquiera

    // TODO para insertar de manera recursiva vamos a hacer un algoritmo que
    // mantenga el estado en funcion de elemento nulos. Vamos a hacer una funcion
    // que agregue el elemento correspodiente en el proximo valor nulo que
    // encuentre. Por ende si creamos un objeto que tiene varios objetos, cando lo
    // queremos insertar otro objeto creamos ese valor nulo y al siguiente valor que
    // en teoria iria tambien lo ponemos uno nulo para cuando termine la iteracion
    // del objeto hijo ya se sepa donde poner el sigiuente y asi continuamente.
    // Vamos a ir dejando "pistas" como valores nulos para que el programa guarde el
    // contexto de donde tiene que insertar. Asimismo evetualmente se va a necesitar
    // una funcion que "limpie" de nulos la estructura
    private JsonElement jsonDocumentContent;

    public JsonDocument() {
    }

    public JsonDocument(JsonElement jsonDocumentContent) {
        this.jsonDocumentContent = jsonDocumentContent;
    }

    public void addJsonObject(JsonElement jsonObject) {

        if (jsonDocumentContent == null) {
            this.jsonDocumentContent = jsonObject;
        } else {
            jsonDocumentContent.insertJsonElement(jsonObject);
        }
    }

    public void addInLastNull() {
        // TODO
    }

    public String obtainStringifiedJson() {
        return jsonDocumentContent.stringify();
    }

    public JsonElement obtainDocumentJson() {
        return jsonDocumentContent;
    }
}
