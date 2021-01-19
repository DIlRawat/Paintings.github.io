/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Classes;

/**
 *
 * @author dilbd
 */
public class PaintingArray {

    PaintingType[] paintings;

    // creating three entity objects and passing some arguments for now
    public PaintingArray() {
        paintings = new PaintingType[4];
        paintings[0] = new PaintingType("2020-4", "Mountain",19.99, "Brush Paint", "09-03-2020", "Mountain Scene");
        paintings[1] = new PaintingType("2020-12", "Lava",14.99, "Pouring Paint", "01-04-2020", "Burning");
        paintings[2] = new PaintingType("2020-8", "Flower",29.99, "Hand Sketched", "03-14-2020", "Nature Scen");
        paintings[3] = new PaintingType("2020-18", "Sky",24.99, "Brush Paint", "11-04-2019", "Sky with flowers");
        
        
    }

    // method that returns the list of entity objects
    public PaintingType[] getPaintings() {
        return paintings;
    }
    public final String[] TYPES = new String[]{"Pouring Paint", "Water Paint", "Sketch"};

    public String[] getTypes() {
        return TYPES;
    }

    // Search the array of current paintings for one with the given
    // serialNumber and name, and return the corresponding object in the array
    public PaintingType getPaintingType(String serialNumber, String name) {
        for (int i = 0; i < paintings.length; i++) {
            PaintingType p = paintings[i];
            if (serialNumber.equals(p.getSerialNumber())
                    && name.equals(p.getName())) {
                return p;
            }
        }
        return null;
    }
}
