/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;



public class FantasyLand {

    
    private String name, location;
    
    public FantasyLand(String name, String location)
    {
        
        this.name = name;
        this.location = location;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "FantasyLand{" + "name=" + name + ", location=" + location + '}';
    }
    
   
}
