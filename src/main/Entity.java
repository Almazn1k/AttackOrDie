package main;

public class Entity {
    private static Entity entity;

    private int damage;
    private int bal_reward;
    private int xp_reward;

    private Entity(){
        this.damage = EntityData.damage;
        this.bal_reward = EntityData.bal_reward;
        this.xp_reward = EntityData.xp_reward;
    }

    public static void createEntity(){
        entity = new Entity();
    }

    public static Entity getEntity(){
        return entity;
    }

    public int getDamage(){
        return damage;
    }

    public int getXpReward(){
        return xp_reward;
    }

    public int getBalReward(){
        return bal_reward;
    }

    static class EntityData{
        private static int damage = 4;
        private static int bal_reward = 5;
        private static int xp_reward = 20;

        public static void setDamage(int a){
            damage = a;
        }
        public static void setBalReward(int a){
            bal_reward = a;
        }
        public static void setXpReward(int a){
            xp_reward = a;
        }
    }
}
