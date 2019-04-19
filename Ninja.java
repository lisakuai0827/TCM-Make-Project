    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Ninja here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Ninja extends Characters
    {
        int hp = 20;
        int speed = 5;
        int attackSpeed = 1500;
        
        String proType = "normal";
    
        public void act() 
        {
           keyPressed();
           isDead();
        }
        
        public void attack()
        {
                setImage("NinjaThrowRight.png");
                if(getRotation() == 180)
                    setImage("NinjaThrowLeft.png");
                Shuriken a = new Shuriken();
                getWorld().addObject(a,getX(),getY());
                a.setRotation(getRotation());
                
        }
        
        public void keyPressed(){
            int dx = 0,dy = 0;
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("W")){
                setImage("NinjaUp.png");
                setRotation(-90);
                dy = -speed;
            }
            else if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("S")){
                setImage("NinjaDown.png");
                setRotation(90);
                dy = speed;
            }
            else if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("A")){
                setImage("NinjaLeft.png");
                setRotation(180);
                dx = -speed;
        }
        else if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("D")){
            setImage("NinjaRight.png");
            setRotation(0);
            dx = speed;
        }
        setLocation (getX()+dx,getY()+dy);
        
        switch(hitObject()){
            case "Wall":
            setLocation(getX()-dx,getY()-dy);
            break;
        }
        
        GreenfootImage image = new GreenfootImage(getImage());
        
        if (Greenfoot.isKeyDown("j") || Greenfoot.isKeyDown("J")){
            long currentTime = System.currentTimeMillis();
            
            if(currentTime - startTime >= (2000 - attackSpeed)){
                startTime = System.currentTimeMillis();
                attack();
            }

        }
        
                    
        if (Greenfoot.isKeyDown("k") || Greenfoot.isKeyDown("K")){
            block();
        }
        
        if (Greenfoot.isKeyDown("L") || Greenfoot.isKeyDown("L")){
            ultimate();
        }
    }
    
    public String hitObject(){
        if(isTouching(Wall.class)){
            return "Wall";
        }
        
        else
            return "";
    }
    
    public void isDead(){
        if(hp<=0){
            setImage("NinjaDead.png");
            Greenfoot.stop();
    }
    }

}
