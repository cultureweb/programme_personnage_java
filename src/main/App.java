package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String typeOfCharacterToCreate = chooseTypeOfCharacterToCreate();
        createCharacter(typeOfCharacterToCreate);

    }

    private static String chooseTypeOfCharacterToCreate() {

        Scanner sc = new Scanner(System.in);

        int choice;
        String str;
        do {
            System.out.println("Step-By-Step Choose your character 1-Magician 2-Warrior:");
            choice = sc.nextInt();
        }
        while (choice != 1 && choice != 2);

        if (choice == 1) {
            str = "magician";
        } else str = "warrior";
        return str;
    }

    private static void createCharacter(String typeOfCharacterToCreate) {
        int number;

        switch (typeOfCharacterToCreate) {
            case "warrior":
                System.out.println("Choice: warrior");
                Warrior warrior = new Warrior();
                System.out.println("Please enter a " + typeOfCharacterToCreate + "'s name: ");
                warrior.setName(recordStringDataFromConsole());
                System.out.println("Name: " + warrior.getName());
                System.out.println("Please enter an url link to set your image(avatar): ");
                warrior.setImage(recordStringDataFromConsole());
                System.out.println("Image: " + warrior.getImage());
                do {
                    System.out.println("Set Life level between 0 and 5: ");
                    number = recordIntegerDataFromConsole();
                }
                while (number > 5 || number < 0);
                warrior.setLife(number);
                System.out.println("Life: " + warrior.getLife());
                break;

            case "magician":
                System.out.println("Choice: magician");
                Magician magician = new Magician();
                System.out.println("Please enter a " + typeOfCharacterToCreate + "'s name: ");
                magician.setName(recordStringDataFromConsole());
                System.out.println("Name: " + magician.getName());
                System.out.println("Please enter an url link to set your image(avatar): ");
                magician.setImage(recordStringDataFromConsole());
                System.out.println("image: " + magician.getImage());
                do {
                    System.out.println("Set Life level between 0 and 5: ");
                    number = recordIntegerDataFromConsole();
                }
                while (number > 5 || number < 0);
                magician.setLife(number);
                System.out.println("Life: " + magician.getLife());
                break;

        }

}

    private static String recordStringDataFromConsole() {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        return str;
    }

    private static Integer recordIntegerDataFromConsole() {
        Scanner sc = new Scanner(System.in);
        int numberEntered;
        numberEntered = sc.nextInt();
        return numberEntered;
    }
}
