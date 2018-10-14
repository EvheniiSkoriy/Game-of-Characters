package gamecharacters;

import java.util.ArrayList;

public class Character implements Elementals {

    private String name;
    private String type;
    private int healthPoints;
    private int skillPoints;
    private ArrayList<Item> listItems;
    private ArrayList<Techniques> listTechniques;
    private int attack;
    private int armor;
    private String elementalStrength;
    private int money;
    private int xp;
    private int level;
    private double xpForLevel;
    private String elementalWeaker;
    public int SPEED_GETTING_SKILL_POINTS;
    private ArrayList bonuses;

    /**
     *
     * @param name - name of character
     * @param type - type of character
     * @param listItems - list of items
     * @param listTechniques - list of techniques
     * @param attack - attack of character
     * @param elementalStrength - character strenhth element
     * @param elementalWeaker - character weaker element
     */
    public Character(String name, String type, ArrayList<Item> listItems, ArrayList<Techniques> listTechniques, int attack, String elementalStrength, String elementalWeaker) {
        this.SPEED_GETTING_SKILL_POINTS = 10;
        this.level = 1;
        this.name = name;
        this.type = type;
        this.healthPoints = 500;
        this.skillPoints = 0;
        this.listItems = listItems;
        this.listTechniques = listTechniques;
        this.attack = attack;
        this.elementalStrength = elementalStrength;
        bonuses = new ArrayList();
        this.money = 0;
        this.xp = 0;
        this.armor = 0;
        this.xpForLevel = Math.pow(this.healthPoints / 20, 2);
        for (Item it : listItems) {
            this.armor += it.getArmor();
        }
        switch (elementalStrength) {
            case WATER:
                this.elementalWeaker = WIND;
                break;
            case WIND:
                this.elementalWeaker = THUNDER;
                break;
            case FIRE:
                this.elementalWeaker = WATER;
                break;
            case EARTH:
                this.elementalWeaker = FIRE;
                break;
            case THUNDER:
                this.elementalWeaker = EARTH;
                break;
        }

    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList getBonuses() {
        return bonuses;
    }

    public void setBonuses(ArrayList bonuses) {
        this.bonuses = bonuses;
    }

    public int getSPEED_GETTING_SKILL_POINTS() {
        return SPEED_GETTING_SKILL_POINTS;
    }

    public void setSPEED_GETTING_SKILL_POINTS(int SPEED_GETTING_SKILL_POINTS) {
        this.SPEED_GETTING_SKILL_POINTS = SPEED_GETTING_SKILL_POINTS;
    }

    public String getElementalWeaker() {
        return elementalWeaker;
    }

    public double getXpForLevel() {
        return xpForLevel;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public ArrayList<Item> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<Item> listItems) {
        this.listItems = listItems;
    }

    public ArrayList<Techniques> getListTechniques() {
        return listTechniques;
    }

    public void setListTechniques(ArrayList<Techniques> listTechniques) {
        this.listTechniques = listTechniques;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getElementalStrength() {
        return elementalStrength;
    }

    public void setElementalStrength(String elementalStrength) {
        this.elementalStrength = elementalStrength;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * this character attack other character (health-(attack-armor))
     *
     * @param men - character that will have a damage
     */
    public void attack(Character men) {
        men.setHealthPoints(men.getHealthPoints() - (getAttack() - men.getArmor()));
        setSkillPoints(men.getSkillPoints() + (int) SPEED_GETTING_SKILL_POINTS);
        setMoney(getMoney() + 100);
        setXp(getXp() + 50);
    }

    /**
     * this character attack other character with Technique(health-attack)
     *
     * @param men - character that will have a damage
     * @param t - technique that will use
     */
    public void attackTechniques(Character men, Techniques t) {
        men.setHealthPoints(men.getHealthPoints() - t.getAttack());
        setSkillPoints(men.getSkillPoints() + (int) SPEED_GETTING_SKILL_POINTS);
        setMoney(getMoney() + 100);
        setXp(getXp() + 70);
    }

    /**
     * check if xp that cheracter have > then xp that need for level-->level up
     * ,in other cases nothing
     */
    public void checkOnLevel() {
        if (getXp() > getXpForLevel()) {
            setLevel(getLevel() + 1);
            setXp(getXp() - (int) getXpForLevel());
            setHealthPoints(getHealthPoints() + 200);

        }
    }

    @Override
    public String toString() {
        return "Character{" + "name=" + name + ", type=" + type + ", healthPoints=" + healthPoints + ", skillPoints=" + skillPoints + ", attack=" + attack + ", armor=" + armor + ", elementalStrength=" + elementalStrength + ", money=" + money + ", xp=" + xp + ", level=" + level + ", elementalWeaker=" + elementalWeaker + '}';
    }

}
