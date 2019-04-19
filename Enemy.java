import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Characters
{
    int hp = 10;
    int speed= 2;
    int attack = 20;
    long startTime1;
    long startTime2;
    boolean isDead= false;
    public void act() 
    {
        if(this.hp > 0){
            if(!spot())
            {
            wander();
            }
            else
            {
            attack();
            }
        }else
        {
            if(!isDead){
            startTime2 = System.currentTimeMillis();
            isDead();
            }else
            {
            long currentTime2 = System.currentTimeMillis();
            if(currentTime2 - startTime2 >=2000)
                getWorld().removeObject(this);
            }
            
        }
    }
        
    
    
    public void attack(){
        if(!getWorld().getObjects(Ninja.class).isEmpty()){
        Ninja player = (Ninja)getWorld().getObjects(Ninja.class).get(0);
        turnTowards(player.getX(),player.getY());
        move(speed);
        long currentTime1 = System.currentTimeMillis();
            if(currentTime1 - startTime1 >= 1000){
                setImage("Enemy1SpotRight.png");
                if(!getNeighbours(10,true,Ninja.class).isEmpty()){ 
                System.out.println(currentTime1);
                System.out.println(startTime1);
                System.out.println(currentTime1 - startTime1 >= 3000);
                startTime1 = System.currentTimeMillis();
                setImage("EnemyAttack.png");
                getWorld().getObjects(Ninja.class).get(0).hp-=attack;
                System.out.println(getWorld().getObjects(Ninja.class).get(0).hp);
                move(-20);
            }else
            {
                move(speed);
            }
            }else
                move(-speed);
        }

    }
    
    public void getHit(int dmg)
    {
        setHp (getHp()-dmg);
        System.out.println(hp);
    }
    
    public void setHp(int varHp)
    {
        hp = varHp;
    }
    
    public int getHp()
    {
        return hp;
    }
    
    public boolean spot()
    {
        if (!getNeighbours(100,true,Ninja.class).isEmpty())
        {
        return true;
        }
        else 
            setImage("Enemy1.png");
        return false;
    }
    public void wander()
    {
        move(speed);
        if(isTouching(Wall.class)||isAtEdge()){
            setRotation(getRotation()+10);
            move(speed);
        }
    }
    public void isDead()
    {
        setImage("EnemyDead.png");
        isDead = true;
    }

}
