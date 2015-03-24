/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author taxidriver
 */
public class BadGuy extends MoveableObject {
    
    private int meanFactor, defeatPoints;

    public BadGuy(int meanFactor, int defeatPoints, String name, String location, String direction, int health, int speed) {
        super(name, location, direction, health, speed);
        this.meanFactor = meanFactor;
        this.defeatPoints = defeatPoints;
    }

    public int getMeanFactor() {
        return meanFactor;
    }

    public void setMeanFactor(int meanFactor) {
        this.meanFactor = meanFactor;
    }

    public int getDefeatPoints() {
        return defeatPoints;
    }

    public void setDefeatPoints(int defeatPoints) {
        this.defeatPoints = defeatPoints;
    }
    
    
    
}
