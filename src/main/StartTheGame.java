package main;

import java.util.Scanner;

public class StartTheGame {

    private Character[] characterList = new Character[100];
    private int index = 0;
//    private int indexCharacterToModify;
//    private int indexFeatureToModify;





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
                characterList[index] = warrior;
                index++;

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

                numberEntered = askAndRecordIntegerDataFromConsole("Set Attack Strength for your magician", 8, 15);
                magician.setAttack(numberEntered);

                characterList[index] = magician;
                index++;
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
        myStringArray = new String[]{"Display", "Modify", "Create a new", "Display List"};
        int choice;
        do {
            System.out.println("What do you want to do Next ?");
            for (int i = 0; i < myStringArray.length; i++) {
                System.out.println(i + 1 + "_" + myStringArray[i] + " character(s)");
            }
            choice = sc.nextInt();
        }
        while (choice != 1 && choice != 2 && choice != 3 && choice != 4);

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
                displayCharacter(choice);
                whatNext();
                break;

            case 2:

                System.out.println("Please enter id number you wish to modify");
                displayCharacterList();
                int indexCharacterToModify = sc.nextInt();
                System.out.println(indexCharacterToModify);
                int indexFeatureToModify = displayCharacterAndReturnIndexToModify(indexCharacterToModify);
                modifyCharacter(indexFeatureToModify, indexCharacterToModify);

                break;

            case 3:
                String typeOfCharacterToCreate = chooseTypeOfCharacterToCreate();
                createCharacter(typeOfCharacterToCreate);
                whatNext();
                break;

            case 4:
                displayCharacterList();
                whatNext();
                break;
        }
    }

    private void displayCharacter(int choice) {
        if (choice == 1) {
            for (int i = 0; i < characterList.length; i++) {
                if (characterList[i] != null && characterList[i].getClass().getSimpleName().equals("Warrior")) {
                    System.out.println("Id:" + i + "\n" + characterList[i] + "\n");
                }
            }
        } else {
            for (int i = 0; i < characterList.length; i++) {
                if (characterList[i] != null) {
                    System.out.println("Id:" + i + "\n" + characterList[i] + "\n");
                }
            }
        }
    }

    private void displayCharacterList() {

        for (int i = 0; i < characterList.length; i++) {
            if (characterList[i] != null) {
                System.out.println("id number : " + i + " - " + characterList[i].getClass().getSimpleName() + "'s name: " + characterList[i].getName() + "\n");
            }
        }
    }

    private int displayCharacterAndReturnIndexToModify(int idChoice) {
        Scanner sc = new Scanner(System.in);
       // sc.nextLine();
        System.out.println("Select what you want to modify for this " +
                characterList[idChoice].getClass().getSimpleName() +
                "\n" + characterList[idChoice].toStringWithIndex() +
                "\n"+
                "\n0 _ Back to the Menu ");
        int choiceMenu = sc.nextInt();
        System.out.println(choiceMenu);
        return choiceMenu;
    }

    private void modifyCharacter(int indexFeatureToModify, int indexCharacterToModify) {
        switch (indexFeatureToModify) {
            case 0:
                whatNext();
                break;
            case 1:
                System.out.println("You want to modify the name: " + characterList[indexCharacterToModify].getName());
                characterList[indexCharacterToModify].setName(askAndRecordStringDataFromConsole("Please Enter a new name"));
                System.out.println("Your new name is: " + characterList[indexCharacterToModify].getName());
                displayCharacterAndReturnIndexToModify(indexCharacterToModify);
                break;

            case 2:
                System.out.println("You want to modify the image: " + characterList[indexCharacterToModify].getImage());
                characterList[indexCharacterToModify].setImage(askAndRecordStringDataFromConsole("Please Enter a new URL for your image "));
                System.out.println("Your new image is: " + characterList[indexCharacterToModify].getImage());
                break;

            case 3:
                System.out.println("You want to modify the life: " + characterList[indexCharacterToModify].getLife());
                if (characterList[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    characterList[indexCharacterToModify].setLife(askAndRecordIntegerDataFromConsole("Set a new Life level", 5, 10));
                } else {
                    characterList[indexCharacterToModify].setLife(askAndRecordIntegerDataFromConsole("Set a new  Life level", 3, 6));
                }
                System.out.println("Your new life is: " + characterList[indexCharacterToModify].getLife());
                break;
            case 4:
                System.out.println("You want to modify the Attack: " + characterList[indexCharacterToModify].getAttack());
                if (characterList[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    characterList[indexCharacterToModify].setLife(askAndRecordIntegerDataFromConsole("Set a new Attack Strength for your warrior", 5, 10));
                } else {
                    characterList[indexCharacterToModify].setLife(askAndRecordIntegerDataFromConsole("Set a new Attack Strength for your magician", 8, 15));
                }
                System.out.println("Your new Attack Strength  is: " + characterList[indexCharacterToModify].getLife());
                break;

            case 5:
                if (characterList[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    String currentWeaponName = ((Warrior) characterList[indexCharacterToModify]).getWeapon().getWeaponName();
                    System.out.println("You want to modify the weapon' name: " + currentWeaponName);
                    String weaponName = (askAndRecordStringDataFromConsole("Please Enter a new name:"));
                    ((Warrior) characterList[indexCharacterToModify]).getWeapon().setWeaponName(weaponName);
                    System.out.println("Your new weapon's name is: " + ((Warrior) characterList[indexCharacterToModify]).getWeapon().getWeaponName());
                    break;
                } else {
                   // characterList[indexCharacterToModify].setImage(askAndRecordStringDataFromConsole("Please Enter a new spell 's name:"));
                    String currentSpellName = ((Magician) characterList[indexCharacterToModify]).getSpell().getSpellName();
                    System.out.println("You want to modify the spell' name: " + currentSpellName);
                    String newSpellName = (askAndRecordStringDataFromConsole("Please Enter a new name:"));
                    ((Magician) characterList[indexCharacterToModify]).getSpell().setSpellName(newSpellName);
                    System.out.println("Your new spell's name is: " + ((Magician) characterList[indexCharacterToModify]).getSpell().getSpellName());
                    break;
                }

            case 6:
                if (characterList[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    int currentWeaponAttackLevel = ((Warrior) characterList[indexCharacterToModify]).getWeapon().getAttackLevel();
                    System.out.println("You want to modify the weapon's level attack: " + currentWeaponAttackLevel);
                    int newWeaponAttackLevel = askAndRecordIntegerDataFromConsole("Please enter a strength for your spell", 2, 4);
                    System.out.println("Your new weapon's level attack is: " + newWeaponAttackLevel);
                } else {
                    int currentSpellAttackLevel = ((Magician) characterList[indexCharacterToModify]).getSpell().getAttackLevel();
                    System.out.println("You want to modify the spell's level attack: " + currentSpellAttackLevel);
                    int newSpellAttackLevel = askAndRecordIntegerDataFromConsole("Please enter a strength for your spell", 2, 4);
                    System.out.println("Your new spell's level attack is: " + newSpellAttackLevel);
                }
                break;

            case 7:
                if (characterList[indexCharacterToModify].getClass().getSimpleName().equals("Warrior")) {
                    String currentShieldName = ((Warrior)characterList[indexCharacterToModify]).getShield();
                    System.out.println("You want to modify the shield' name: " + currentShieldName);
                    String newShieldName = (askAndRecordStringDataFromConsole("Please Enter a new name:"));
                    ((Warrior) characterList[indexCharacterToModify]).setShield(newShieldName);
                    System.out.println("Your new shield's name is: " + ((Warrior) characterList[indexCharacterToModify]).getShield());
                    break;
                } else {
                    characterList[indexCharacterToModify].setImage(askAndRecordStringDataFromConsole("Please Enter a new spell 's name:"));
                    String currentSpellName = ((Magician) characterList[indexCharacterToModify]).getPotion();
                    System.out.println("You want to modify the weapon' name: " + currentSpellName);
                    String newWeaponName = (askAndRecordStringDataFromConsole("Please Enter a new name:"));
                    ((Magician) characterList[indexCharacterToModify]).setPotion(newWeaponName);
                    System.out.println("Your new weapon's name is: " + ((Magician) characterList[indexCharacterToModify]).getPotion());
                    break;

                }



        }


    }
}