package com.encapsulation;

public class Main {
    public static void main(String[] args) {
        Player player=new Player();
        player.name="vignesh";
        player.health=100;
        player.weapon="M-54";
        int damage=10;
        player.loseHealth(damage);
        System.out.println(player.healthRemaining());
        damage=11;
        player.loseHealth(damage);
        System.out.println(player.healthRemaining());
    }
}
