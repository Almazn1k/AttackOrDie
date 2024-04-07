package main;

public class Player {
    private static Player player;

    private int player_max_hp = 20;
    private int player_hp = player_max_hp;
    private int player_xp = 0;
    private int player_bal = 0;
    private int player_lvl = 0;
    private int lvlup = 100;
    private float p_to_newlvl;

    private Player(){

    }

    public static void createPlayer(){
        player = new Player();
    }

    public static Player getPlayer(){
        return player;
    }

    public int getPlayerHp(){
        return player_hp;
    }

    public int getPlayerXp(){
        return player_xp;
    }

    public int getPlayerLvlUp(){
        return lvlup;
    }

    public String getPlayerPerToNewLvl(){
        if (p_to_newlvl % 1.0 != 0){
            return String.format("%s", p_to_newlvl);
        }
        else{
            return String.format("%.0f", p_to_newlvl);
        }
    }

    public int getPlayerLvl(){
        return player_lvl;
    }

    public int getPlayerBal(){
        return player_bal;
    }

    public int getPlayerMaxHp(){
        return player_max_hp;
    }

    public void setPlayerHp(int a){
        player_hp = a;
    }

    public void setPlayerXp(int a){
        player_xp = a;
    }

    public void setPlayerBal(int a){
        player_bal = a;
    }

    public void setPlayerLvlUp(int a){
        lvlup = a;
    }

    public void setPlayerLvl(int a){
        player_lvl = a;
    }

    public void setPlayerMaxHp(int a){
        player_max_hp = a;
    }

    public void dealDamage(int a){
        player_hp -= a;
    }

    public boolean checkLvlUp(){
        if (getPlayerXp() >= getPlayerLvlUp()){
            setPlayerLvl(getPlayerLvl() + 1);
            setPlayerLvlUp(getPlayerLvlUp()*2);
            setPlayerXp(0);
            return true;
        }
       else {
            return false;
       }
    }

    public void setPToNewLvl(float a){
        p_to_newlvl = a;
    }
}
