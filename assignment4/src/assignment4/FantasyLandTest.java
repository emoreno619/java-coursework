/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import assignment4.CollectableObject.type;
import java.util.ArrayList;

/**
 *
 * @author taxidriver
 */
public class FantasyLandTest {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
    ArrayList<StationaryObject> stationaryList = new ArrayList<StationaryObject>();    
    
    stationaryList.add(new StationaryObject("Tree", "Forest", 1000));
    stationaryList.add(new StationaryObject("Rock", "Forest", 10000));
    stationaryList.add(new StationaryObject("Vine", "Forest", 1));
    
    ArrayList<CollectableObject> collectableList = new ArrayList<CollectableObject>();
    ArrayList<CollectableObject> collectableList2 = new ArrayList<CollectableObject>();
    ArrayList<MoveableObject> moveableList = new ArrayList<MoveableObject>();
    
    moveableList.add(new GoodGuy(500, 2, collectableList, "Zoro", "Forest", "N", 125, 1000));
    moveableList.add(new MoveableObject("Damsel in Distress", "Forest", "W", 10, 1));
    moveableList.add(new GoodGuy(100, 89, collectableList2, "Sidekick", "Forest", "S", 50, 500));
    
    moveableList.add(new BadGuy(250, 5000, "Evil Scientist", "Forest", "S", 500, 150));
    
  
    
    
   collectableList.add(new CollectableObject("Axe of Kings", "Forest", type.AXE, 9999999));
   collectableList.add(new CollectableObject("Wand de la Bruja", "Forest", type.WAND, 4999));
   collectableList2.add(new CollectableObject("Sword of Sidekicks", "Forest", type.SWORD, 10));
   collectableList2.add(new CollectableObject("Insta-Hero", "Forest", type.POTION, 399));
    
   for (StationaryObject i : stationaryList )
    {
        System.out.println(i);
        System.out.println(i.getDamagePoints());
        System.out.println(i.getName());
        System.out.println(i.getLocation());
        System.out.println();
        
    }
   
    for (CollectableObject i : collectableList )
    {
        System.out.println(i.getName());
        System.out.println(i.getLocation());
        System.out.println(i);
        

        System.out.println();
    }
    
    
    
    for (MoveableObject i : moveableList)
    {
        System.out.println(i.getName());
        System.out.println(i.getLocation());
        System.out.println(i);
        System.out.println(i.fight());
        System.out.println(i.getDirection());    
        System.out.println(i.getSpeed());
        System.out.println(i.getHealth());
        System.out.println();
    }
    
    for (CollectableObject i : collectableList2 )
    {
        System.out.println(i.getName());
        System.out.println(i.getLocation());
        System.out.println(i);
        
        System.out.println();
            
    }
    }
}
