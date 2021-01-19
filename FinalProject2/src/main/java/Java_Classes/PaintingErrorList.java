/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Classes;
import java.sql.*;

/**
 *
 * @author dilbd
 */
public class PaintingErrorList {

    private boolean serialNumberMissing = false;
    private boolean nameMissing = false;
    private boolean typeMissing = false;
    private boolean priceMissing = false;
    private boolean priceNotNumber = false;
    private boolean numberIllegal = false;
    private boolean dateMissing = false;
    private boolean descriptionMissing = false;
    private boolean priceZero = false;
    private boolean serialNumberIllegal = false;
    private boolean paintingAlreadyExists = false;
    
    private boolean allValid = true;

    public PaintingErrorList(){
     allValid = true;
    }
    // All the setter and getter

    public boolean isAllValid() {
        return allValid;
    }

    public void setAllValid(boolean allValid) {
        this.allValid = allValid;
    }
    
    public void setPriceZero(boolean priceZero) {
        this.priceZero = priceZero;
    }

    public void setSerialNumberIllegal(boolean serialNumberIllegal) {
        this.serialNumberIllegal = serialNumberIllegal;
    }

    public boolean isSerialNumberIllegal() {
        return serialNumberIllegal;
    }

    public boolean isPriceZero() {
        return priceZero;
    }

    public boolean isDateMissing() {
        return dateMissing;
    }

    public void setDateMissing(boolean dateMissing) {
        this.dateMissing = dateMissing;
    }

    public void setDescriptionMissing(boolean descriptionMissing) {
        this.descriptionMissing = descriptionMissing;
    }

    public boolean isDescriptionMissing() {
        return descriptionMissing;
    }


    public boolean isNameMissing() {
        return nameMissing;
    }

    public boolean isSerialNumberMissing() {
        return serialNumberMissing;
    }

    public boolean isTypeMissing() {
        return typeMissing;
    }

    public boolean isPriceMissing() {
        return priceMissing;
    }

    public boolean isPriceNotNumber() {
        return priceNotNumber;
    }

    public boolean isNumberIllegal() {
        return numberIllegal;
    }

    public boolean isPaintingAlreadyExists() {
        return paintingAlreadyExists;
    }

    public void setSerialNumberMissing(boolean serialNumberMissing) {
        this.serialNumberMissing = serialNumberMissing;
    }

    public void setTypeMissing(boolean typeMissing) {
        this.typeMissing = typeMissing;
    }

    public void setPriceMissing(boolean priceMissing) {
        this.priceMissing = priceMissing;
    }

    public void setPriceNotNumber(boolean priceNotNumber) {
        this.priceNotNumber = priceNotNumber;
    }

    public void setNumberIllegal(boolean numberIllegal) {
        this.numberIllegal = numberIllegal;
    }

    public void setPaintingAlreadyExists(boolean paintingAlreadyExists) {
        this.paintingAlreadyExists = paintingAlreadyExists;
    }

    public void setNameMissing(boolean nameMissing) {
        this.nameMissing = nameMissing;
    }

    // This method takes a serialNumber, name, and the arry of paiintings abd determines
    // if that painting already exists in the array.
    public void validatePaintingUnique(PaintingList courses, String serialNumber, String name) {
        if (courses.getPaintingTypes(serialNumber, name) != null) {
            // If so, the related error is set to true, and it is false
            // that all input is valid
            paintingAlreadyExists = true;  
            allValid = false;            
        }
        else {
            paintingAlreadyExists = false;
        }
    }
    
    // This method takes a serialNumber, name, and the arry of paiintings abd determines
    // if that course already exists in the database.
    public void validatePaintingUnique(String serialnumber, String paintingname) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        boolean alreadyExists = false;
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
            // Ceate parameterized query for existing course
            String template = "select * from MyPaintings "
                    + "where serialnumber = ? and paintingname = ?";
            statement = connection.prepareStatement(template);
            
            // Insert serialnumber and paintingname of proposed course into query and perform
            statement.setString(1, serialnumber);
            statement.setString(2, paintingname);           
            results = statement.executeQuery();
            
            // If next returns true, some existing record has same serialnumber and paintingname
            alreadyExists = results.next();
        }     
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
        if (alreadyExists) {
            // If so, the related error is set to true, and false that all input is valid
            paintingAlreadyExists = true;  
            allValid = false;            
        }
        else {
            paintingAlreadyExists = false;
        }
    } 
    
    
    // If the painting name is entered then, 
    // compare the trimmed value with the empty string.
    public void  validateName(String name) {
        if ("".equals(name.trim())) {
            nameMissing = true;
            allValid = false;
        } else {
            nameMissing = false;
        }
    }

    // If the serial number is entered then, 
    // compare the trimmed value with the empty string.
    //also check if matches with the regular expression
    public void validateserialNumber(String serialNumber) {
        if ("".equals(serialNumber.trim())) {
            serialNumberMissing = true;
            allValid = false;
        }
        String SNRegEx = "((19)|(20))\\d\\d-\\d+";
        serialNumber = serialNumber.trim();
        if (!serialNumber.matches(SNRegEx)) {
            serialNumberIllegal = true;
            allValid = false;
        } else {
            serialNumberIllegal = false;
        }
    }

    // If the painting price is entered then, 
    // compare the trimmed value with the empty string.
    //also making sure the price is not equal to zero or less and catching any number format exception
    public void validatePrice(String price) {
        if ("".equals(price.trim())) {
            priceMissing = true;
            allValid = false;
        } else {
            try {
                double givenPrice = Double.parseDouble(price);
                if (givenPrice <= 0.0) {
                    priceZero = true;
                    allValid = false;
                }
            } catch (NumberFormatException ex) {
               priceNotNumber = true;
                 allValid = false;

            }
            priceNotNumber = false;
        }
    }

    // If the painting type is entered then, 
    // compare the trimmed value with the empty string.
    public void validateType(String type) {
        if (type == null || type.equals("select")) {
            typeMissing = true;
            allValid = false;
        } else {
            typeMissing = false;
        }
    }

    // If the painting description is entered then, 
    // compare the trimmed value with the empty string.
    public void validateDescription(String description) {
        if ("".equals(description.trim())) {
            descriptionMissing = true;
            allValid = false;
        } else {
            descriptionMissing = false;
        }
    }
    // If the painting date is entered then, 
    // compare the trimmed value with the empty string.
    public void validateDate(String date) {
        if ("".equals(date.trim())) {
            dateMissing = true;
            allValid = false;
        } else {
           dateMissing = false;
        }
    }
    
    
    
    
    
    
    
}
