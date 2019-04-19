
    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Projectile here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Projectile extends Actor
    {
        public void check(int dmg)
        {
            if(hitEnemy(dmg)||atEdge()||hitWall())
            {
                getWorld().removeObject(this);
            }

            
        }
        
        public boolean hitWall(){
            try{
           if(isTouching(Wall.class))
           {
               return true;
           }
           else 
               return false;
           }catch(Exception e){
               return false;
            }
        }
        
        public boolean atEdge(){
      
           try{
           if(isAtEdge())
           {
               return true;
           }
           else 
               return false;
           }catch(Exception e){
               return false;
            }
        }
        
        public boolean hitEnemy(int dmg){
        try{
           if(isTouching(Enemy.class)){
           Enemy c = (Enemy) getOneIntersectingObject(Enemy.class);
               if(c!= null)
               {
               c.getHit(dmg);
               return true;
               }
           }
           else
            return false;
        return false;
        }catch(Exception e){
               return false;
            }
        }
        
    }

