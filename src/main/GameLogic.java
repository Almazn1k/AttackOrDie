package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

import javax.swing.Timer;

public class GameLogic{
    Inventory inv;

    Timer timer;

    private String info = "-";
    private String command;

    private int heal_potion = 2;

    private int hp_cost = 20;
    private int armor_cost = 45;

    private float p_to_newlvl;

    GameLogic(){
        inv = new Inventory();
    }

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
            Entity.createEntity();
            if(Player.getPlayer().getPlayerHp() > Entity.getEntity().getDamage()){
                Player.getPlayer().dealDamage(Entity.getEntity().getDamage()); 
                Player.getPlayer().setPlayerXp(Player.getPlayer().getPlayerXp() + Entity.getEntity().getXpReward());
                Player.getPlayer().setPlayerBal(Player.getPlayer().getPlayerBal() + Entity.getEntity().getBalReward());
                info = "Your attack was succesful!";                
            }
            else {
                info = "Attack failed! You died";
                Player.getPlayer().setPlayerHp(0);
                Player.getPlayer().setPlayerXp(0);
                Player.getPlayer().setPlayerLvl(0);
                Player.getPlayer().setPlayerBal(0);
            }
            show();
        }

    public void respawn(){
        if(Player.getPlayer().getPlayerHp() <= 0){
            Player.getPlayer().setPlayerHp(20);
            Player.getPlayer().setPlayerXp(0);
            Player.getPlayer().setPlayerLvl(0);
            Player.getPlayer().setPlayerBal(0);
            heal_potion = 2;
            info = "You've been respawned";
        }
        else {
            info = "You can't respawn. Your hp is "+Integer.toString(Player.getPlayer().getPlayerHp());
        }
        show();
    }

    public void shop(){
         info = "THE INGAME SHOP";
         show();
         info = "";
         show();
         info = "1. Heal Potion - "+hp_cost+"$";
         show();
         info = "2. Armor - "+armor_cost+"$";
         show();
    }

    public void buy(){
        if (command.contains("hp") || command.contains("heal potion") || command.contains("healp")){
            if(Player.getPlayer().getPlayerBal() >= 20){
                heal_potion += 1;
                Player.getPlayer().setPlayerBal(Player.getPlayer().getPlayerBal() - hp_cost);
                info = "You successfully bought 1 Heal Potion";
            }
            else {
                info = "You haven't any money to buy that";
            }
            show();
        }
        else {
            info = "ERROR: Can't found that item";
            show();
        }
    }

    public void heal(){
        if (heal_potion >= 1){
            heal_potion -= 1;
            Player.getPlayer().setPlayerHp(Player.getPlayer().getPlayerHp() + 12);
            if(Player.getPlayer().getPlayerHp() > Player.getPlayer().getPlayerMaxHp()){
                Player.getPlayer().setPlayerHp(Player.getPlayer().getPlayerMaxHp());
            }
            info = "You've healed 12 HP";
        }
        else {
            info = "You haven't any Heal Potions";
        }
        show();
    }

    public void levelinfo(){
        info = "Your level: "+Player.getPlayer().getPlayerLvl();
        show();
        info = "XP to new level: "+Player.getPlayer().getPlayerXp()+"/"+Player.getPlayer().getPlayerLvlUp()+" ("+Player.getPlayer().getPlayerPerToNewLvl()+"%)";
        show();
        System.out.println(p_to_newlvl);
    }

    public void inventory(){
        info = "PLAYER'S INVENTORY";
        show();
        info = "Heal Potions: "+heal_potion;
        show();
        info = "Armor Level: "+inv.getArmor();
        show();
    }

    public void load(){
        try {
            BufferedReader bW = new BufferedReader(new FileReader("C:/Users/Acer/Desktop/Java_Projects/Game/AttackorDie/save.txt"));
            String line;
            int c = 0;
			while ((line = bW.readLine()) != null) {
                if (c == 0){
                    Player.getPlayer().setPlayerHp(Integer.parseInt(line));
                }
                if (c == 1){
                    Player.getPlayer().setPlayerXp(Integer.parseInt(line));
                }
                if (c == 2){
                    Player.getPlayer().setPlayerBal(Integer.parseInt(line));
                }
                if (c == 3){
                    Player.getPlayer().setPlayerLvl(Integer.parseInt(line));
                }
                if (c == 4){
                    heal_potion = Integer.parseInt(line);
                }
                if (c == 5){
                    inv.setArmor(Integer.parseInt(line));
                }
                if (c == 6){
                    Player.getPlayer().setPlayerLvlUp(Integer.parseInt(line));
                }
                c++;
				System.out.println(line);
			}
            bW.close();
            info = "Your data has been restored";
            show();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void check(){
        if(command.equals("respawn") && Player.getPlayer().getPlayerHp() == 0){
            respawn();
        }
        else if(Player.getPlayer().getPlayerHp() != 0){
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
            else if(command.equals("respawn")){
                respawn();
            }
            else if(command.equals("levelinfo") || command.equals("li")){
                levelinfo();
            }
            else if(command.equals("inventory") || command.equals("inv") || command.equals("i")){
                inventory();
            }
            else if(command.equals("load")){
                load();
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
        System.out.println(Player.getPlayer().getPlayerHp());
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

    public int getHealPotions(){
        return heal_potion;
    }
}
