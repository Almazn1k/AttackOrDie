package main;

public class Inventory {
    private int player_armor = 0;
    private int heal_potion = 2;

    public int getPotion(){
        return heal_potion;
    }

    public void setPotion(int a){
        heal_potion = a;
    }

    public int getArmor(){
        return player_armor;
    }
    public void setArmor(int a){
        player_armor = a;
    }

}
