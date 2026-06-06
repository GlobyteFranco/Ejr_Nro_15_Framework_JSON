import java.util.Scanner;

import controllers.JsonController;
import factories.JsonFactory;
import models.JsonDocument;
import views.JsonView;

public class App {
    public static void main(String[] args) {
        System.out.println("Comenzando JSON Framework...");
        JsonView jsonView = new JsonView(new Scanner(System.in),
                new JsonController(new JsonDocument(), new JsonFactory()));
                jsonView.startProgram();
    }
}