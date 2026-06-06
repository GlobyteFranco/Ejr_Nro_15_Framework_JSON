package models;

import java.util.ArrayList;
import java.util.List;

public class JsonVector implements JsonElement {
    List<JsonElement> jsonElementList = new ArrayList<>();

    public JsonVector() {
    }

    public JsonVector(List<JsonElement> jsonElementList) {
        this.jsonElementList = jsonElementList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JsonVector other = (JsonVector) obj;
        if (jsonElementList == null) {
            if (other.jsonElementList != null)
                return false;
        } else if (!jsonElementList.equals(other.jsonElementList))
            return false;
        return true;
    }

    @Override
    public String stringify(int nivel) {
        StringBuilder sb = new StringBuilder();

        String spacing = "  ".repeat(nivel);
        String insideSpacing = "  ".repeat(nivel + 1);

        sb.append("[\n");

        int processed = 0;
        int total = this.jsonElementList.size();

        for (JsonElement element : this.jsonElementList) {
            sb.append(insideSpacing);

            if (element != null) {
                sb.append(element.stringify(nivel + 1));
            } else {
                sb.append("null");
            }

            processed++;

            if (processed < total) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append(spacing).append("]");

        return sb.toString();
    }

    @Override
    public void insertJsonElement(JsonElement jsonElement) {
        this.jsonElementList.add(jsonElement);
    }

    @Override
    public JsonElement checkExistence(JsonElement jsonElement) {
        if (this.equals(jsonElement)) {
            return this;
        } else {
            for (JsonElement element : jsonElementList) {
                if (element.checkExistence(jsonElement)!=null) {
                    return this;
                }
            }
            return null;

        }

    }

}
