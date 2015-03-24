/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author taxidriver
 */
public class StationaryObject extends FantasyLand {
    
    private int damagePoints;
    
    public StationaryObject(String name, String location, int damagePoints)
    {
      super(name, location);
        this.damagePoints = damagePoints;
    }

    @Override
    public String toString() {
        return "StationaryObject{" + "damagePoints=" + damagePoints + '}';
    }

    public int getDamagePoints() {
        return damagePoints;
    }


    
    
}
