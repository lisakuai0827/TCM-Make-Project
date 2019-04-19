import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shuriken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuriken extends Projectile
{
    int damage = 5;
    int speed = 5;
    int range = 100;

    public void act(){
        move(speed);
        check(damage);
    }
}
