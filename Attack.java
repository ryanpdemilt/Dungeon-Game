package com.mygdx.space.utils;

import com.mygdx.space.entities.Enemy;
import com.mygdx.space.entities.Entity;

public class Attack {
    private String attackName;
    private int damage;
    private int manaCost;
    private int cooldown;
    private boolean onCooldown;
    private int cooldownTimer;
    public Attack(String name, int d){
        attackName = name;
        damage = d;
        manaCost = 0;
        cooldown = 0;
        cooldownTimer = cooldown;
    }
    public Attack(String name, int d, int m, int c){
        attackName = name;
        damage = d;
        manaCost = m;
        cooldown = c;
        cooldownTimer = cooldown;
    }
    public void use(Entity e){
        if(!checkCooldown()){
            e.damage(getDamage());
            if(cooldown != 0){
                startCooldown();
            }
        }
    }
    public String getName(){
        return attackName;
    }
    public void setName(String name){
        attackName = name;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int d){
        damage = d;
    }
    public int getManaCost(){
        return manaCost;
    }
    public void setManaCost(int d){
        manaCost = d;
    }
    public int getCooldown(){
        return cooldown;
    }
    public void setCooldown(int d){
        cooldown = d;
    }
    public int getCooldownTime(){
        return cooldown - cooldownTimer;
    }
    public boolean checkCooldown(){
        if(cooldownTimer != cooldown){
            return true;
        } else {
            return false;
        }
    }
    private void startCooldown(){
        cooldownTimer = 0;
    }
    public void updateCooldown(){
        cooldownTimer++;
    }
}
