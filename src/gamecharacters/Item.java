package gamecharacters;

public class Item {

    private String name;
    private int armor;
    private int bonus;

    public Item(String name, int armor, int bonus) {
        this.name = name;
        this.armor = armor;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Item upgrade(Item item, Character charac) {
        if (charac.getMoney() > 200) {
            item.setArmor(getArmor() + 2);
            charac.setMoney(charac.getMoney() - 200);
            return item;
        } else {
            System.out.println("Not enought money");
            return item;
        }
    }
}
