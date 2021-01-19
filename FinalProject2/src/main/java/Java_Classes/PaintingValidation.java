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
public class PaintingValidation {

    // If the painting name is entered then, 
    // compare the trimmed value with the empty string.
    public static boolean validateName(String name,
            PaintingErrorList errors) {
        if ("".equals(name.trim())) {
            errors.setNameMissing(true);
            return false;
        } else {
            return true;
        }
    }

    // If the serial number is entered then, 
    // compare the trimmed value with the empty string.
    //also check if matches with the regular expression
    public static boolean validateserialNumber(String serialNumber, PaintingErrorList errors) {
        if ("".equals(serialNumber.trim())) {
            errors.setSerialNumberMissing(true);
            return false;
        }
        String SNRegEx = "((19)|(20))\\d\\d-\\d+";
        serialNumber = serialNumber.trim();
        if (!serialNumber.matches(SNRegEx)) {
            errors.setSerialNumberIllegal(true);
            return false;
        } else {
            return true;
        }
    }

    // If the painting price is entered then, 
    // compare the trimmed value with the empty string.
    //also making sure the price is not equal to zero or less and catching any number format exception
    public static boolean validatePrice(String price, PaintingErrorList errors) {
        if ("".equals(price.trim())) {
            errors.setPriceMissing(true);
            return false;
        } else {
            try {
                double givenPrice = Double.parseDouble(price);
                if (givenPrice <= 0.0) {
                    errors.setPriceZero(true);
                    return false;
                }
            } catch (NumberFormatException ex) {
                errors.setPriceNotNumber(true);
                return false;

            }
            return true;
        }
    }

    // If the painting type is entered then, 
    // compare the trimmed value with the empty string.
    public static boolean validateType(String type, PaintingErrorList errors) {
        if (type == null || type.equals("select")) {
            errors.setTypeMissing(true);
            return false;
        } else {
            return true;
        }
    }

    // If the painting description is entered then, 
    // compare the trimmed value with the empty string.
    public static boolean validateDescription(String description,
            PaintingErrorList errors) {
        if ("".equals(description.trim())) {
            errors.setDescriptionMissing(true);
            return false;
        } else {
            return true;
        }
    }
    // If the painting date is entered then, 
    // compare the trimmed value with the empty string.
    public static boolean validateDate(String date,
            PaintingErrorList errors) {
        if ("".equals(date.trim())) {
            errors.setDateMissing(true);
            return false;
        } else {
            return true;
        }
    }
}
