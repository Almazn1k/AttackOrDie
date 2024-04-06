package main;

public class GameLogic {
    

    private String info = "-";
    private String command;

    private int player_hp = 20;
    private int player_xp = 80;
    private int player_bal = 0;
    private int player_lvl = 0;
    private int player_armor = 0;

    private int heal_potion = 0;

    private int lvlup = 100;

    private int entity_damage = 4;

    public void show(){
        Game.getGame().action8.setText(Game.getGame().action7.getText());
        Game.getGame().action7.setText(Game.getGame().action6.getText());
        Game.getGame().action6.setText(Game.getGame().action5.getText());
        Game.getGame().action5.setText(Game.getGame().action4.getText());
        Game.getGame().action4.setText(Game.getGame().action3.getText());
        Game.getGame().action3.setText(Game.getGame().action2.getText());
        Game.getGame().action2.setText(Game.getGame().action1.getText());
        Game.getGame().action1.setText(info);
    }

    public void attack(){
            if(player_hp > entity_damage){
                player_hp = player_hp - entity_damage;
                player_xp = player_xp + 20;
                player_bal = player_bal + 5;
                info = "Your attack was succesful!";
                show();                
            }
            else {
                info = "Attack failed! You died";
                player_hp = 0;
                player_xp = 0;
                player_lvl = 0;
                player_bal = 0;
                show();
            }
        }

    public void respawn(){
        if(player_hp <= 0){
            player_hp = 20;
            player_xp = 0;
            player_lvl = 0;
            player_bal = 0;
            info = "You've been respawned";
            show();
        }
        else {
            info = "You can't respawn. Your hp is "+Integer.toString(player_hp);
            show();
        }
    }

    public void shop(){
         info = "THE INGAME SHOP";
         show();
         info = "";
         show();
         info = "1. Heal Potion - 20$";
         show();
         info = "2. Armor - 45$";
         show();
    }

    public void buy(){
        if (command.contains("hp") || command.contains("heal potion") || command.contains("healp")){
            if(player_bal >= 20){
                heal_potion += 1;
                player_bal -= 20;
                info = "You successfully bought 1 Heal Potion";
                show();
            }
            else {
                info = "You haven't any money to buy that";
                show();
            }
        }
        else {
            info = "ERROR: Can't found that item";
            show();
        }
    }

    public void heal(){
        if (heal_potion >= 1){
            heal_potion -= 1;
            player_hp = 20;
            info = "You've been healed";
            show();
        }
        else {
            info = "You haven't any Heal Potions";
            show();
        }
    }

    public void check(){
        if (player_xp == lvlup){
            player_lvl += 1;
            lvlup *= 2;
            player_xp = 0;
        }

        if(player_hp != 0){
            if (command.equals("attack")){
                attack();
            }
            else if(command.equals("shop")){
                shop();
            }
            else if(command.contains("buy")){
                buy();
            }
            else if(command.equals("heal")){
                heal();
            }
            else {
                info = "Command has not found!";
                show();
            }
        }
        else {
            info = "You've been killed. Please respawn";
            show();
        }
        if(command.equals("respawn")){
            respawn();
        }   
    }

    public int getPlayerHp(){
        return player_hp;
    }

    public int getPlayerXp(){
        return player_xp;
    }

    public int getPlayerLvl(){
        return player_lvl;
    }

    public int getPlayerBal(){
        return player_bal;
    }

    public int getEntityDamage(){
        return entity_damage;
    }

    public String getCommand(){
        return command;
    }

    public void setCommand(String cmd){
        command = cmd;
    }

    public String getInfo(){
        return info;
    }

    public void setInfo(String inf1){
        info = inf1;
    }
}
