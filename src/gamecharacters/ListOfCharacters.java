package gamecharacters;

import java.util.ArrayList;
import java.util.List;

public class ListOfCharacters implements Elementals {

    private List<Character> listCharacters = new ArrayList();

    /**
     * It is our group of characters In a team where the party contains 2 or
     * more of the same type of elemental character, each character of that
     * given type earns a 10% bonus in attack power and health. If a party
     * member has a greater elemental type, partners with a weaker elemental
     * type earn 10% bonus in defense and skill points for each partner with a
     * stronger element.
     */
    public ListOfCharacters() {
        int water = 0;
        int fire = 0;
        int earth = 0;
        int thunder = 0;
        int wind = 0;
        for (Character c : listCharacters) {
            switch (c.getElementalStrength()) {
                case WATER:
                    water++;
                    break;
                case FIRE:
                    fire++;
                    break;
                case EARTH:
                    earth++;
                    break;
                case THUNDER:
                    thunder++;
                    break;
                case WIND:
                    wind++;
                    break;
                default:
                    break;
            }
        }
        if (water >= 2) {
            for (Character chara : listCharacters) {
                if (chara.getElementalStrength().equals(WATER)) {
                    chara.setHealthPoints(chara.getHealthPoints() + (int) (chara.getHealthPoints() * 0.1));
                    chara.setAttack(chara.getAttack() + (int) (chara.getAttack() * 0.1));
                }
            }
        }
        if (fire >= 2) {
            for (Character chara : listCharacters) {
                if (chara.getElementalStrength().equals(FIRE)) {
                    chara.setHealthPoints(chara.getHealthPoints() + (int) (chara.getHealthPoints() * 0.1));
                    chara.setAttack(chara.getAttack() + (int) (chara.getAttack() * 0.1));
                }
            }
        }
        if (earth >= 2) {
            for (Character chara : listCharacters) {
                if (chara.getElementalStrength().equals(EARTH)) {
                    chara.setHealthPoints(chara.getHealthPoints() + (int) (chara.getHealthPoints() * 0.1));
                    chara.setAttack(chara.getAttack() + (int) (chara.getAttack() * 0.1));
                }
            }
        }
        if (thunder >= 2) {
            for (Character chara : listCharacters) {
                if (chara.getElementalStrength().equals(THUNDER)) {
                    chara.setHealthPoints(chara.getHealthPoints() + (int) (chara.getHealthPoints() * 0.1));
                    chara.setAttack(chara.getAttack() + (int) (chara.getAttack() * 0.1));
                }
            }
        }
        if (wind >= 2) {
            for (Character chara : listCharacters) {
                if (chara.getElementalStrength().equals(WIND)) {
                    chara.setHealthPoints(chara.getHealthPoints() + (int) (chara.getHealthPoints() * 0.1));
                    chara.setAttack(chara.getAttack() + (int) (chara.getAttack() * 0.1));
                }
            }
        }
        checkOnPower();
    }

    /**
     * If a party member has a greater elemental type, partners with a weaker
     * elemental type earn 10% bonus in defense and skill points for each
     * partner with a stronger element.
     */
    public void checkOnPower() {
        for (Character chara : listCharacters) {
            for (Character secondChara : listCharacters) {
                if (chara.getElementalStrength().equals(secondChara.getElementalWeaker())) {
                    chara.setArmor((int) (chara.getArmor() * 1.1));
                    chara.setSkillPoints(chara.getSkillPoints() + (int) (chara.getSPEED_GETTING_SKILL_POINTS() * 0.1));
                }
            }
        }
    }

    public List<Character> getListCharacters() {
        return listCharacters;
    }

    public void setListCharacters(List<Character> listCharacters) {
        this.listCharacters = listCharacters;
    }

}
