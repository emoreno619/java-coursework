/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author taxidriver
 */
public class MoveableObject extends FantasyLand {

    private int health, speed;
    private String direction;
    
    public MoveableObject(String name, String location, String direction, int health, int speed) 
    {
        super(name, location);
        this.direction = direction;
        this.health = health;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "MoveableObject{" + "health=" + health + ", speed=" + speed + ", direction=" + direction + '}';
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
        public String fight()
    {
        String s = "I am fighting!";
        return s;
    }
    
    
}
