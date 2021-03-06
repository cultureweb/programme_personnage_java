package main;

import java.util.ArrayList; // import the ArrayList class
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Class Game
 */
public class Game {

    List<Character> characters = new ArrayList<>(); // Create an ArrayList object
    List<Case> cases = new ArrayList<>();

    // TODO : index => 0
    private int index = 1;

    public void start() {
        // TODO : pour tester  => car si tout fonctionne commenter 1ere ligne et commenter la deuxième ligne
        Character thomas = new Warrior("tom", "image", 5, 5, "sword", 2, "bouclier");
        //createCharacter(chooseTypeOfCharacterToCreate());
        characters.add(thomas);
        whatNext();
    }

    public void createCase() {
        int Choice = askInteger("How many cases for your game", 10, 50);
        System.out.println(Choice);

        for (int index = 0; index < Choice; index++) {
            int randomNumber = 1 + (int)(Math.random() * ((12 - 1) + 1));
              //System.out.println(randomNumber);


            if (randomNumber > 0 && randomNumber < 5) {
                Case neutral = new Case("neutral");
                cases.add(neutral);

            }
            else if (randomNumber > 4 && randomNumber < 10) {
                Case bonus = new Case("bonus");
                cases.add(bonus);

            }
            else if (randomNumber > 9 && randomNumber <= 12){
                Case enemy = new Case("enemy");
                cases.add(enemy);
            }

          System.out.println(""+ index  + cases.get(index) + "\n");
        }
//        for (Case i : cases) {
//
//            System.out.println(i);
//        }

    }

    /**
     * Fonction Choisir entre 1-Warrior ou 2-Magician:
     *
     * @return une String.
     */
    private String chooseTypeOfCharacterToCreate() {
        // TODO : Exeption
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


    /**
     * Crée un personnage selon le type en parametre
     *
     * @param typeOfCharacterToCreate
     */
    private void createCharacter(String typeOfCharacterToCreate) {
        int numberEntered;
        try {


            switch (typeOfCharacterToCreate) {
                case "warrior":

                    String name = askString("Please enter a name: ");
                    String image = askString("Please enter an url link to set your image(avatar): ");
                    int life = askInteger("Set Life level", 5, 10);
                    int attackLevel = askInteger("Please enter a strength for your weapon", 2, 4);
                    String weaponName = askString("Please enter a weapon's name : ");
                    int attack = askInteger("Set Attack Strength for your warrior", 5, 10);
                    String shieldName = askString("Please enter a name for your Shield: ");
                    Character warrior = new Warrior(name, image, life, attackLevel, weaponName, attack, shieldName);
                    characters.add(warrior);
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
                    characters.add(magician);
                    index++;
                    break;

            }
        } catch (InputMismatchException e) {
            System.out.println("vous avez une erreur du à une saisie incorrecte, retour au menu");
        }

    }


    /**
     * @param question
     * @return
     * @throws InputMismatchException
     */
    private String askString(String question) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        String str;
        str = sc.nextLine();
        return str;
    }

    /**
     * Retourne l'adresse du profil du Zero.
     *
     * @return un chiffre entier
     * @throws InputMismatchException Si jamais mauvaise saisie .
     */
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
                "\n5_Delete Character(s)" +
                "\n6_Create Cases" +
                "\n7_EXIT";
        int choice;

        do {
            Scanner sc = new Scanner(System.in);

            do {
                System.out.println(menu);
                choice = sc.nextInt();
            }
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7);
            Launch(choice);

        }
        while (choice != 7);
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
                break;

            case 4:
                displayCharacterList();
                break;
            case 5:
                //Delete Method
                System.out.println("Please enter id number you wish to delete");
                int indexCharacterToDelete = sc.nextInt();
                System.out.println(indexCharacterToDelete);
                indexCharacterToDelete = displayCharacterProps(indexCharacterToDelete);
                characters.remove(indexCharacterToDelete);
                break;
            case 6:
                createCase();
        }
    }

    private void displayCharacter() {
//        for (Character i : characters) {
//            System.out.println(i);
//        }
        for (int i = 0; i < characters.size(); i++) {
            //  if (characters[i] != null) {
            System.out.println("Id:" + i + "\n" + characters.get(i) + "\n");
            //}
        }
    }

    private void displayCharacterList() {
        for (int i = 0; i < characters.size(); i++) {
            System.out.println("id number : " + i + " - " + characters.get(i).getClass().getSimpleName() + "'s name: " + characters.get(i).getName() + "\n");
        }
    }

    private int displayCharacterProps(int idChoice) {
        Scanner sc = new Scanner(System.in);
        // sc.nextLine();
        System.out.println("Select what you want to modify for this " +
                characters.get(idChoice).getClass().getSimpleName() +
                "\n" + characters.get(idChoice).toStringWithIndex() +
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
                System.out.println("You want to modify the name: " + characters.get(indexCharacterToModify).getName());
                characters.get(indexCharacterToModify).setName(askString("Please Enter a new name"));
                System.out.println("Your new name is: " + characters.get(indexCharacterToModify).getName());

                break;

            case 2:
                System.out.println("You want to modify the image: " + characters.get(indexCharacterToModify).getImage());
                characters.get(indexCharacterToModify).setImage(askString("Please Enter a new URL for your image "));
                System.out.println("Your new image is: " + characters.get(indexCharacterToModify).getImage());
                break;

            case 3:
                System.out.println("You want to modify the life: " + characters.get(indexCharacterToModify).getLife());
                if (characters.get(indexCharacterToModify) instanceof Warrior) {
                    characters.get(indexCharacterToModify).setLife(askInteger("Set a new Life level", 5, 10));
                } else {
                    characters.get(indexCharacterToModify).setLife(askInteger("Set a new  Life level", 3, 6));
                }
                System.out.println("Your new life is: " + characters.get(indexCharacterToModify).getLife());
                break;
            case 4:
                System.out.println("You want to modify the Attack: " + characters.get(indexCharacterToModify).getAttack());
                if (characters.get(indexCharacterToModify).getClass().getSimpleName().equals("Warrior")) {
                    characters.get(indexCharacterToModify).setLife(askInteger("Set a new Attack Strength for your warrior", 5, 10));
                } else {
                    characters.get(indexCharacterToModify).setLife(askInteger("Set a new Attack Strength for your magician", 8, 15));
                }
                System.out.println("Your new Attack Strength  is: " + characters.get(indexCharacterToModify).getLife());
                break;

            case 5:
                if (characters.get(indexCharacterToModify).getClass().getSimpleName().equals("Warrior")) {
                    String currentWeaponName = ((Warrior) characters.get(indexCharacterToModify)).getWeapon().getWeaponName();
                    System.out.println("You want to modify the weapon' name: " + currentWeaponName);
                    String weaponName = (askString("Please Enter a new name:"));
                    ((Warrior) characters.get(indexCharacterToModify)).getWeapon().setWeaponName(weaponName);
                    System.out.println("Your new weapon's name is: " + ((Warrior) characters.get(indexCharacterToModify)).getWeapon().getWeaponName());
                    break;
                } else {
                    String currentSpellName = ((Magician) characters.get(indexCharacterToModify)).getSpell().getSpellName();
                    System.out.println("You want to modify the spell' name: " + currentSpellName);
                    String newSpellName = (askString("Please Enter a new name:"));
                    ((Magician) characters.get(indexCharacterToModify)).getSpell().setSpellName(newSpellName);
                    System.out.println("Your new spell's name is: " + ((Magician) characters.get(indexCharacterToModify)).getSpell().getSpellName());
                    break;
                }

            case 6:
                if (characters.get(indexCharacterToModify).getClass().getSimpleName().equals("Warrior")) {
                    int currentWeaponAttackLevel = ((Warrior) characters.get(indexCharacterToModify)).getWeapon().getAttackLevel();
                    System.out.println("You want to modify the weapon's level attack: " + currentWeaponAttackLevel);
                    int newWeaponAttackLevel = askInteger("Please enter a strength for your spell", 2, 4);
                    System.out.println("Your new weapon's level attack is: " + newWeaponAttackLevel);
                } else {
                    int currentSpellAttackLevel = ((Magician) characters.get(indexCharacterToModify)).getSpell().getAttackLevel();
                    System.out.println("You want to modify the spell's level attack: " + currentSpellAttackLevel);
                    int newSpellAttackLevel = askInteger("Please enter a strength for your spell", 2, 4);
                    System.out.println("Your new spell's level attack is: " + newSpellAttackLevel);
                }
                break;

            case 7:
                if (characters.get(indexCharacterToModify).getClass().getSimpleName().equals("Warrior")) {
                    String currentShieldName = ((Warrior) characters.get(indexCharacterToModify)).getShield();
                    System.out.println("You want to modify the shield' name: " + currentShieldName);
                    String newShieldName = (askString("Please Enter a new name:"));
                    ((Warrior) characters.get(indexCharacterToModify)).setShield(newShieldName);
                    System.out.println("Your new shield's name is: " + ((Warrior) characters.get(indexCharacterToModify)).getShield());
                    break;
                } else {
                    characters.get(indexCharacterToModify).setImage(askString("Please Enter a new spell 's name:"));
                    String currentSpellName = ((Magician) characters.get(indexCharacterToModify)).getPotion();
                    System.out.println("You want to modify the weapon' name: " + currentSpellName);
                    String newWeaponName = (askString("Please Enter a new name:"));
                    ((Magician) characters.get(indexCharacterToModify)).setPotion(newWeaponName);
                    System.out.println("Your new weapon's name is: " + ((Magician) characters.get(indexCharacterToModify)).getPotion());
                    break;
                }
        }
        indexFeatureToModify = displayCharacterProps(indexCharacterToModify);
        editCharacter(indexFeatureToModify, indexCharacterToModify);


    }
}