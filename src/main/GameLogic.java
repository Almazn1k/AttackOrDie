package main;

public class GameLogic {
    String command, info;

    int player_hp = 20;
    int player_xp = 80;
    int player_bal = 0;
    int player_lvl = 0;

    int lvlup = 100;

    int entity_damage = 4;

    public void attack(){
            if(player_hp > entity_damage){
                player_hp = player_hp - entity_damage;
                player_xp = player_xp + 20;
                player_bal = player_bal + 5;
                info = "Your attack was succesful!";                
            }
            else {
                info = "Attack failed! You'll restart";
                player_hp = 0;
                player_xp = 0;
                player_lvl = 0;
                player_bal = 0;
            }
        }

    public void check(){
        if (player_xp == lvlup){
            player_lvl += 1;
            lvlup *= 2;
            player_xp = 0;
        }

        if (command.equals("attack")){
            attack();
        }
        else {
            info = "Command has not found!";
        }
    }
}
