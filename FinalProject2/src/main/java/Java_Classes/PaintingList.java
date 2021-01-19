/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Classes;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author dilbd
 */
public class PaintingList {

    // painting list is an array of paitingtype objects
    private ArrayList<PaintingType> paintings;

    public PaintingList() {
        paintings = new ArrayList();
    }

    // method to return list of paintings 
    public ArrayList getPaintings() {
        return paintings;
    }

        // Get the existing paintings from the database and add them to the list
    public void loadPaintings() {
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/PaintingDB", "app", "app");
        }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");
        }
        
        try {
            // Create and execute query statement for all in Courses table,
            // storing links to matching records in ResultSet object results.
            statement = connection.createStatement();
            results = statement.executeQuery("select * from MyPaintings");
            
            // Loop to next record in results, while there is a next record.
            while (results.next()) {
                
                // Get each field of current record (as appropriate type)
                String serialnumber = results.getString("serialnumber");
                String paintingname = results.getString("paintingname");
                String description = results.getString("description");
                String painteddate = results.getString("painteddate");
                double price = results.getDouble("price");
                String paintingtype = results.getString("paintingtype");
                
                
                // Construct a new course object from that data, and add to list
                PaintingType  p = new PaintingType(serialnumber, paintingname, price, 
                                      paintingtype, painteddate, description); 
                paintings.add(p);
            }
        }        
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
    }
    
    // Save new course to database
    public static void savePainting(String serialnumber, String paintingname,
            String price, String paintingtype, String painteddate, String description) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/PaintingDB", "app", "app");
            //connection = DriverManager.getConnection(urlString, "root", "xyzzy1234");
        }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");
        }
        
        try {

            String template = "insert into MyPaintings "
                    + "(serialnumber, paintingname, price, paintingtype, painteddate, description)"
                    + "values (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(template);
            statement.setString(1, serialnumber);
            statement.setString(2, paintingname);
            statement.setDouble(3, Double.parseDouble(price));
            statement.setString(4, paintingtype);
            statement.setString(5, painteddate);
            statement.setString(6, description);
            int changed = statement.executeUpdate();
            System.out.println(changed+" records added");
        }      
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
        
    }
    
    // Construct a new Painting object directly from parameters read in from the form.
    // This requires converting price into double
  
    public void add(String serialnumber, String paintingname, String price,
            String paintingtype, String painteddate, String description) {
        PaintingType p = new PaintingType(serialnumber, paintingname, Double.parseDouble(price),
                paintingtype, painteddate,  description);
        paintings.add(p);
    }

    
    // add a paintingtype into the list 
    public void add(PaintingType t) {
        paintings.add(t);
    }

    // return the size of the paintinglist
    public int getSize() {
        return paintings.size();
    }

    // Search the array of current paintings for one with the given
    // serialNumber and name, and return the corresponding object in the array
    public PaintingType getPaintingTypes(String serialNumber, String name) {
        for (PaintingType p : paintings) {
            if (serialNumber.equals(p.getSerialNumber()) && name.equals(p.getName())) {
                return p;
            }
        }
        return null;
    }

    //delete the paintingtye with the given serialNumber and name form the list
    // it uses the search method above
    public void drop(String serialNumber, String name) {
        PaintingType t = getPaintingTypes(serialNumber, name);
        paintings.remove(t);
    }

    //Takes arraylist as a parameter, iterate through it and gets all the paintingtype 
    // objects and gets the price of each painting then
    //calculate the total cost of all the paintingtype in the list and return 
    // the total price
    public double getTotalPrice(PaintingList Paintings) {
        double price = 0.0;
        for (int i = 0; i < Paintings.getSize(); i++) {
            ArrayList p = Paintings.paintings;
            PaintingType t = (PaintingType) p.get(i);
            price = price + t.getPrice();
        }
        return price;
    }

}
