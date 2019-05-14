package main;

import java.util.Scanner;

public class StartTheGame {

    private Warrior[] warriorsList = new Warrior[100];
    private Magician[] magiciansList = new Magician[100];
    private int magicianIndex = 0;
    private int warriorIndex = 0;

    public void start() {
        String typeOfCharacterToCreate = chooseTypeOfCharacterToCreate();
        createCharacter(typeOfCharacterToCreate);
        whatNext();
    }

    private String chooseTypeOfCharacterToCreate() {

        Scanner sc = new Scanner(System.in);

        int choice;
        String str;
        do {
            System.out.println("Step-By-Step Choose your character 1-Warrior 2-Magician:");
            choice = sc.nextInt();
        }
        while (choice != 1 && choice != 2);

        if (choice == 1) {
            str = "warrior";
        } else str = "magician";
        return str;
    }

    private void createCharacter(String typeOfCharacterToCreate) {
        int numberEntered;
        String stringEntered;


        switch (typeOfCharacterToCreate) {
            case "warrior":
                System.out.println("Choice: warrior");
                Warrior warrior = new Warrior();
                warrior.setName(askAndRecordStringDataFromConsole("Please enter a name: "));

                warrior.setImage(askAndRecordStringDataFromConsole("Please enter an url link to set your image(avatar): "));

                numberEntered = askAndRecordIntegerDataFromConsole("Set Life level", 5, 10);
                warrior.setLife(numberEntered);

                String weaponRecord = askAndRecordStringDataFromConsole("Please enter a weapon's name : ");
                numberEntered = askAndRecordIntegerDataFromConsole("Please enter a strength for your weapon", 2, 4);
                Weapon weapon = new Weapon(weaponRecord, numberEntered);
                warrior.setWeapon(weapon);

                warrior.setShield(askAndRecordStringDataFromConsole("Please enter a name for your Shield: "));

                numberEntered = askAndRecordIntegerDataFromConsole("Set Attack Strength for your warrior", 5, 10);
                warrior.setAttack(numberEntered);
                System.out.println("Attack: " + warrior.getAttack());
                warriorsList[warriorIndex] = warrior;
                warriorIndex++;

                break;

            case "magician":


                System.out.println("Choice: magician");
                Magician magician = new Magician();
                magician.setName(askAndRecordStringDataFromConsole("Please enter a name: "));

                magician.setImage(askAndRecordStringDataFromConsole("Please enter an url link to set your image(avatar): "));

                numberEntered = askAndRecordIntegerDataFromConsole("Set Life level", 3, 6);
                magician.setLife(numberEntered);

                String spellRecord = askAndRecordStringDataFromConsole("Please enter a spell's name : ");
                numberEntered = askAndRecordIntegerDataFromConsole("Please enter a strength for your spell", 2, 4);
                Spell spell = new Spell(spellRecord, numberEntered);
                magician.setSpell(spell);

                magician.setPotion(askAndRecordStringDataFromConsole("Please enter a name of potion "));

                numberEntered = askAndRecordIntegerDataFromConsole("Set Attack Strength for your magician", 5, 10);
                magician.setAttack(numberEntered);

                magiciansList[magicianIndex] = magician;
                magicianIndex++;
                break;

        }

    }

    private String askAndRecordStringDataFromConsole(String question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        String str;
        str = sc.nextLine();
        return str;
    }

    private Integer askAndRecordIntegerDataFromConsole(String question, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int numberEntered;
        do {
            System.out.println(question + " between " + min + " and " + max + ": ");
            numberEntered = sc.nextInt();
        }
        while (numberEntered > max || numberEntered < min);
        return numberEntered;
    }

    private int whatNext() {

        Scanner sc = new Scanner(System.in);
        String[] myStringArray;
        myStringArray = new String[]{"display", "Modify", "Create a new"};
        int choice;
        do {
            System.out.println("What do you want to do Next ?");
            for (int i = 0; i < myStringArray.length; i++) {
                System.out.println(i + 1 + "_" + myStringArray[i] + " caracter(s)");
            }
            choice = sc.nextInt();
        }
        while (choice != 1 && choice != 2 && choice != 3);

        LaunchMenu(choice);
        return choice;
    }

    private void LaunchMenu(int choice) {
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1:

                do {
                    System.out.println("What do you want to display : 1_warrior  2_magician");
                    choice = sc.nextInt();
                }
                while (choice != 1 && choice != 2);
                if(choice == 1){
                    for (int i = 0; i < warriorsList.length; i++) {
                        if (warriorsList[i] != null) {
                            System.out.println("Warrior Id:" + i + "\n" + warriorsList[i] + "\n");
                        }
                    }
                }
                else{
                    for (int i = 0; i < magiciansList.length; i++) {
                        if (magiciansList[i] != null) {
                            System.out.println("Magician Id:" + i + "\n" +magiciansList[i] + "\n");
                        }
                    }
                }
                whatNext();
                break;

            case 2:

                System.out.println("Sorry, you can't modify the character yet");
                whatNext();
                break;

            case 3:
                String typeOfCharacterToCreate = chooseTypeOfCharacterToCreate();
                createCharacter(typeOfCharacterToCreate);
                whatNext();
                break;
            default:
                System.out.println("choix invalide");
        }
    }

}

