package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    // TODO : characters => characters
    private Character[] characters = new Character[100];
    private int index = 0;

    public void start() {

        createCharacter(chooseTypeOfCharacterToCreate());
        whatNext();
    }

    private String chooseTypeOfCharacterToCreate() {

        Scanner sc = new Scanner(System.in);
        int choice;
        String str;
        do {
            System.out.println("Step-By-Step Choose the character you want to create 1-Warrior 2-Magician:");
            choice = sc.nextInt();
        }
        while (choice != 1 && choice != 2);

        // TODO : Switch
        if (choice == 1) {
            str = "warrior";
        } else str = "magician";
        return str;
    }

    private void createCharacter(String typeOfCharacterToCreate) {
        int numberEntered;
        try {


            switch (typeOfCharacterToCreate) {
                case "warrior":
                    System.out.println("Type: warrior");
                    Warrior warrior = new Warrior();
                    warrior.setName(askString("Please enter a name: "));

                    warrior.setImage(askString("Please enter an url link to set your image(avatar): "));

                    numberEntered = askInteger("Set Life level", 5, 10);
                    warrior.setLife(numberEntered);

                    String weaponRecord = askString("Please enter a weapon's name : ");


                    numberEntered = askInteger("Please enter a strength for your weapon", 2, 4);
                    Weapon weapon = new Weapon(weaponRecord, numberEntered);
                    warrior.setWeapon(weapon);

                    warrior.setShield(askString("Please enter a name for your Shield: "));

                    numberEntered = askInteger("Set Attack Strength for your warrior", 5, 10);
                    warrior.setAttack(numberEntered);
                    System.out.println("Attack: " + warrior.getAttack());
                    characters[index] = warrior;
                    index++;
                    break;

                case "magician":

                    System.out.println("Type: magician");
                    Magician magician = new Magician();
                    magician.setName(askString("Please enter a name: "));

                    magician.setImage(askString("Please enter an url link to set your image(avatar): "));

                    numberEntered = askInteger("Set Life level", 3, 6);
                    magician.setLife(numberEntered);

                    String spellRecord = askString("Please enter a spell's name : ");
                    numberEntered = askInteger("Please enter a strength for your spell", 2, 4);
                    Spell spell = new Spell(spellRecord, numberEntered);
                    magician.setSpell(spell);

                    magician.setPotion(askString("Please enter a name of potion "));

                    numberEntered = askInteger("Set Attack Strength for your magician", 8, 15);
                    magician.setAttack(numberEntered);

                    characters[index] = magician;
                    index++;
                    break;

            }
        } catch (InputMismatchException e) {
            System.out.println("vous avez une erreur du à une saisie incorrecte, retour au menu");
        }

    }

    // TODO : Rename function
    private String askString(String question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        String str;
        str = sc.nextLine();
        return str;
    }

    // TODO : Rename function
    private Integer askInteger(String question, int min, int max) throws InputMismatchException {

        Scanner sc = new Scanner(System.in);
        int numberEntered = 0;
        do {
            System.out.println(question + " between " + min + " and " + max + ": ");
            numberEntered = sc.nextInt();
        }
        while (numberEntered > max || numberEntered < min);
        return numberEntered;
    }

    private void whatNext() {
        String menu = "What do you want to do Next ?" +
                "\n1_Display character(s)" +
                "\n2_Modify character(s)" +
                "\n3_Create a new character(s)" +
                "\n4_Display List character(s)" +
                // "\n5_Delete Character(s)" +
                "\n5_EXIT";
        int choice;

        do {
            Scanner sc = new Scanner(System.in);

            do {
                System.out.println(menu);
                choice = sc.nextInt();
            }
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);
            Launch(choice);

        }
        while (choice != 5);
        System.out.println("\n" +
                "***********************" + "\n\n" +
                "     Fin du Jeu     " + "\n\n" +
                "**********************" + "\n\n"
        );

    }


    // TODO : Rename function Launch => launch
    private void Launch(int choice) {
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1:
                displayCharacter();
                // whatNext();
                break;

            case 2:

                System.out.println("Please enter id number you wish to modify");
                displayCharacterList();
                int indexCharacterToModify = sc.nextInt();
                System.out.println(indexCharacterToModify);
                int indexFeatureToModify = displayCharacterProps(indexCharacterToModify);
                editCharacter(indexFeatureToModify, indexCharacterToModify);

                break;

            case 3:
                String typeOfCharacterToCreate = chooseTypeOfCharacterToCreate();
                createCharacter(typeOfCharacterToCreate);
                //whatNext();
                break;

            case 4:
                displayCharacterList();
                //whatNext();
                break;
        }
    }

    private void displayCharacter() {

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != null) {
                System.out.println("Id:" + i + "\n" + characters[i] + "\n");
            }
        }
    }

    private void displayCharacterList() {

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != null) {
                System.out.println("id number : " + i + " - " + characters[i].getClass().getSimpleName() + "'s name: " + characters[i].getName() + "\n");
            }
        }
    }

    private int displayCharacterProps(int idChoice) {
        Scanner sc = new Scanner(System.in);
        // sc.nextLine();
        System.out.println("Select what you want to modify for this " +
                characters[idChoice].getClass().getSimpleName() +
                "\n" + characters[idChoice].toStringWithIndex() +
                "\n" +
                "\n0 _ Back to the Menu ");
        int choiceMenu = sc.nextInt();
        System.out.println(choiceMenu);
        return choiceMenu;
    }

    private void editCharacter(int indexFeatureToModify, int indexCharacterToModify) {
        Scanner sc = new Scanner(System.in);

        switch (indexFeatureToModify) {
            case 0:
                whatNext();
                break;
            case 1:
                System.out.println("You want to modify the name: " + characters[indexCharacterToModify].getName());
                characters[indexCharacterToModify].setName(askString("Please Enter a new name"));
                System.out.println("Your new name is: " + characters[indexCharacterToModify].getName());

                break;

            case 2:
                System.out.println("You want to modify the image: " + characters[indexCharacterToModify].getImage());
                characters[indexCharacterToModify].setImage(askString("Please Enter a new URL for your image "));
                System.out.println("Your new image is: " + characters[indexCharacterToModify].getImage());
                break;

            case 3:
                System.out.println("You want to modify the life: " + characters[indexCharacterToModify].getLife());
                if (characters[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    characters[indexCharacterToModify].setLife(askInteger("Set a new Life level", 5, 10));
                } else {
                    characters[indexCharacterToModify].setLife(askInteger("Set a new  Life level", 3, 6));
                }
                System.out.println("Your new life is: " + characters[indexCharacterToModify].getLife());
                break;
            case 4:
                System.out.println("You want to modify the Attack: " + characters[indexCharacterToModify].getAttack());
                if (characters[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    characters[indexCharacterToModify].setLife(askInteger("Set a new Attack Strength for your warrior", 5, 10));
                } else {
                    characters[indexCharacterToModify].setLife(askInteger("Set a new Attack Strength for your magician", 8, 15));
                }
                System.out.println("Your new Attack Strength  is: " + characters[indexCharacterToModify].getLife());
                break;

            case 5:
                if (characters[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    String currentWeaponName = ((Warrior) characters[indexCharacterToModify]).getWeapon().getWeaponName();
                    System.out.println("You want to modify the weapon' name: " + currentWeaponName);
                    String weaponName = (askString("Please Enter a new name:"));
                    ((Warrior) characters[indexCharacterToModify]).getWeapon().setWeaponName(weaponName);
                    System.out.println("Your new weapon's name is: " + ((Warrior) characters[indexCharacterToModify]).getWeapon().getWeaponName());
                    break;
                } else {
                    String currentSpellName = ((Magician) characters[indexCharacterToModify]).getSpell().getSpellName();
                    System.out.println("You want to modify the spell' name: " + currentSpellName);
                    String newSpellName = (askString("Please Enter a new name:"));
                    ((Magician) characters[indexCharacterToModify]).getSpell().setSpellName(newSpellName);
                    System.out.println("Your new spell's name is: " + ((Magician) characters[indexCharacterToModify]).getSpell().getSpellName());
                    break;
                }

            case 6:
                if (characters[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    int currentWeaponAttackLevel = ((Warrior) characters[indexCharacterToModify]).getWeapon().getAttackLevel();
                    System.out.println("You want to modify the weapon's level attack: " + currentWeaponAttackLevel);
                    int newWeaponAttackLevel = askInteger("Please enter a strength for your spell", 2, 4);
                    System.out.println("Your new weapon's level attack is: " + newWeaponAttackLevel);
                } else {
                    int currentSpellAttackLevel = ((Magician) characters[indexCharacterToModify]).getSpell().getAttackLevel();
                    System.out.println("You want to modify the spell's level attack: " + currentSpellAttackLevel);
                    int newSpellAttackLevel = askInteger("Please enter a strength for your spell", 2, 4);
                    System.out.println("Your new spell's level attack is: " + newSpellAttackLevel);
                }
                break;

            case 7:
                if (characters[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    String currentShieldName = ((Warrior) characters[indexCharacterToModify]).getShield();
                    System.out.println("You want to modify the shield' name: " + currentShieldName);
                    String newShieldName = (askString("Please Enter a new name:"));
                    ((Warrior) characters[indexCharacterToModify]).setShield(newShieldName);
                    System.out.println("Your new shield's name is: " + ((Warrior) characters[indexCharacterToModify]).getShield());
                    break;
                } else {
                    characters[indexCharacterToModify].setImage(askString("Please Enter a new spell 's name:"));
                    String currentSpellName = ((Magician) characters[indexCharacterToModify]).getPotion();
                    System.out.println("You want to modify the weapon' name: " + currentSpellName);
                    String newWeaponName = (askString("Please Enter a new name:"));
                    ((Magician) characters[indexCharacterToModify]).setPotion(newWeaponName);
                    System.out.println("Your new weapon's name is: " + ((Magician) characters[indexCharacterToModify]).getPotion());
                    break;
                }
        }
        indexFeatureToModify = displayCharacterProps(indexCharacterToModify);
        editCharacter(indexFeatureToModify, indexCharacterToModify);


    }
}