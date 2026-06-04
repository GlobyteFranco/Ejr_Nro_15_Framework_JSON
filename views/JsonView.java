package views;

import java.util.Scanner;

public class JsonView {
    Scanner scanner;

    public JsonView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startProgram() {
        System.out.println("Welcome to the JSON Framework \n Please start entering JSON stuff");
        openJsonEnteringMenu();
    }

    public void openJsonEnteringMenu() {
        System.out.println("\n\nSelect an option... [1]---> Text\n[2]---> Number\n[3]---> Object\n[4]---> Array\n");
    }

    public void insertJsonText() {
        System.out.println("Write the text...\n");
        String text = scanner.nextLine();
        
        // TODO llamar al controller para que haga lo suyo
    }

    public void insertJsonNumber() {
        // TODO hacer y llamar la respectiva funcion del controller

    }

    public void insertJsonObject() {
        // TODO hacer y llamar la respectiva funcion del controller

    }

    public void insertJsonArray() {
        // TODO hacer y llamar la respectiva funcion del controller

    }
}
