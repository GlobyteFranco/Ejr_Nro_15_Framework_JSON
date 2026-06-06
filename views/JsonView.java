package views;

import java.util.Scanner;

import controllers.JsonController;

public class JsonView {
    Scanner scanner;
    JsonController jsonController;

    public JsonView(Scanner scanner, JsonController jsonController) {
        this.scanner = scanner;
        this.jsonController = jsonController;
    }

    public void startProgram() {
        System.out.println("Welcome to the JSON Framework \n Please start entering JSON stuff");
        openJsonEnteringMenu(false);
    }

    public void openJsonEnteringMenu(boolean isKeysObject) {
        while (true) {
            if (!isKeysObject) {
                System.out.println(
                        "\n\nSelect an option... \n\n[1]---> Number\n[2]---> Text\n[3]---> Object\n[4]---> Array\n[5]---> Display JSON\n[6]---> Zoom Out Scope\n[7]---> Quit");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        insertJsonNumber();
                        displayJson();
                        break;
                    case 2:
                        insertJsonText();
                        displayJson();
                        break;
                    case 3:
                        insertJsonObject();
                        displayJson();
                        break;
                    case 4:
                        insertJsonArray();
                        displayJson();
                        break;
                    case 5:
                        displayJson();
                        break;
                    case 6:
                        // TODO Convertir al target de hijo a padre
                        break;
                    case 7:
                        endProgram();
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("\n[1]---> Enter Key\n[2]---> Quit");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        insertJsonText();
                        displayJson();
                        break;
                    case 2:
                        endProgram();

                        break;

                    default:
                        break;
                }
            }

        }

    }

    public void displayJson() {
        System.out.println("Displaying JSON...\n\n" + jsonController.displayJson());

    }

    public void endProgram() {
        System.out.println("Thanks for playing!!!");
        System.exit(0);
    }

    public void insertJsonObject() {
        String text;
        jsonController.addObject(null);
        while (true) {
            System.out.println("Select keys value\n");
            text = scanner.nextLine();
            jsonController.addObject(text);

            System.out.println("Select the type of object to insert \n");
            openJsonEnteringMenu(false);
        }

    }

    public void insertJsonText() {
        System.out.println("Write the text...\n");
        String text = scanner.nextLine();
        jsonController.addString(text);
    }

    public void insertJsonNumber() {
        System.out.println("Write the number...\n");
        int number = Integer.parseInt(scanner.nextLine());
        jsonController.addInt(number);

    }

    public void insertJsonArray() {
        while (true) {

            System.out.println("Select the elements to insert in the array");
            jsonController.addArray();
            openJsonEnteringMenu(false);
        }

    }
}
