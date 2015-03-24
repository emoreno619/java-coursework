/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author taxidriver
 */
class CollectableObject extends FantasyLand {

    private int value;
    private type t;
    public CollectableObject(String name, String location, type t, int value) {
        super(name, location);
        this.value = value;
        this.t = t;
    }

   
   
    enum type {
        POTION, AXE, SWORD, MACE, WAND, BOMB, ARROW
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CollectableObject{" + "value=" + value + ", t=" + t + '}';
    }



    public void setValue(int value) {
        this.value = value;
    }    
}
