package models;

interface JsonElement {
    public String stringify();

    // TODO encarar el problema como hicimos con los tags del ejercicio anterior.
    // Todos los objetos que implementen la interfaz pueden insertarse un elemento
    // json o devolver una excepcion de no poder hacerlo
    public void insertJsonElement(JsonElement jsonElement);

    // TODO devolver la ultima referencia a un objeto JsonElement o NULL si no la
    // tiene
}