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
public class PaintingType {

    private String type = "";
    private String name = "";
    private String description = "";
    private String paintedDate = "";
    private String serialNumber = "";
    private double price = 0;

    // Constructor that takes input and assign the value to the member variables
    public PaintingType(String serialNumber, String name, double price, String type, String paintedDate, String description) {
        this.type = type;
        this.name = name;
        this.paintedDate = paintedDate;
        this.description = description;
        this.serialNumber = serialNumber;
        this.price = price;
    }

// Constructor that takes no arugument // Empty constructor
    public PaintingType() {
    }

//Getters for each variables
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPaintedDate() {
        return paintedDate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

//Setters for each variables
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPaintedDate(String paintedDate) {
        this.paintedDate = paintedDate;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
