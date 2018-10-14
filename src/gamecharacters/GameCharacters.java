package gamecharacters;

import java.util.ArrayList;

public class GameCharacters implements Elementals {

    static ListOfCharacters first = new ListOfCharacters();
    static ListOfCharacters second = new ListOfCharacters();

    public static void main(String[] args) {
        ArrayList<Item> itemEng = new ArrayList();
        ArrayList<Techniques> itemTech = new ArrayList();
        first.getListCharacters().add(new Character("Engineer", "Android", itemEng, itemTech, 5, THUNDER, EARTH));
        first.getListCharacters().add(new Character("Engineer", "Android", itemEng, itemTech, 8, THUNDER, EARTH));
        first.getListCharacters().add(new Character("Engineer", "Android", itemEng, itemTech, 9, THUNDER, EARTH));
        first.getListCharacters().add(new Character("Soldier", "Commander", itemEng, itemTech, 5, FIRE, WATER));
        ArrayList<Item> itemEng1 = new ArrayList();
        ArrayList<Techniques> itemTech1 = new ArrayList();
        second.getListCharacters().add(new Character("Huntress", "Assassin", itemEng1, itemTech1, 15, WIND, THUNDER));
        second.getListCharacters().add(new Character("Huntress", "Assassin", itemEng1, itemTech1, 23, WIND, THUNDER));
        ArrayList<Item> itemEng2 = new ArrayList();
        ArrayList<Techniques> itemTech2 = new ArrayList();
        second.getListCharacters().add(new Character("Beastmaster", "Swordsman ", itemEng2, itemTech2, 40, EARTH, FIRE));
        second.getListCharacters().add(new Character("Beastmaster", "Swordsman ", itemEng2, itemTech2, 33, EARTH, FIRE));
        second.getListCharacters().add(new Character("Healer", "Mariner  ", itemEng1, itemTech1, 7, WATER, WIND));
        for (Character c : first.getListCharacters()) {
            System.out.println(c);
        }
        System.out.println("------");
        for (Character c : second.getListCharacters()) {
            System.out.println(c);
        }
        System.out.println("BEGIN");
        while (!first.getListCharacters().isEmpty() || !second.getListCharacters().isEmpty()) {
            if (first.getListCharacters().isEmpty()) {
                System.out.println("--------------");
                break;
            }
            for (int i = 0; i < first.getListCharacters().size(); i++) {
                if (second.getListCharacters().isEmpty()) {
                    System.out.println("--------------");
                    break;
                }
                first.getListCharacters().get(i).attack(second.getListCharacters().get(0));
                if (second.getListCharacters().get(0).getHealthPoints() <= 0) {
                    second.getListCharacters().remove(0);
                }

            }
            System.out.println("SECOND TEAM");
            if (second.getListCharacters().isEmpty()) {
                System.out.println("--------------");
                break;
            }
            for (Character c : second.getListCharacters()) {
                System.out.println(c);
            }

            for (int i = 0; i < second.getListCharacters().size(); i++) {
                if (first.getListCharacters().isEmpty()) {
                    System.out.println("--------------");
                    break;
                }
                second.getListCharacters().get(i).attack(first.getListCharacters().get(0));
                second.getListCharacters().get(i).checkOnLevel();;
                if (first.getListCharacters().get(0).getHealthPoints() <= 0) {
                    first.getListCharacters().remove(0);
                }

            }
            System.out.println("FIRST TEAM");
            for (Character c : first.getListCharacters()) {
                System.out.println(c);
            }
        }

        if (!first.getListCharacters().isEmpty()) {
            System.out.println("First team win:CONGRATULATION");
        } else if (!second.getListCharacters().isEmpty()) {
            System.out.println("Second team win:CONGRATULATION");
        }

    }

}
