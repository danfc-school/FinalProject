package org.example;

public class Address{
    // Fields
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        QC, ON, AB, BC, MB, NB, NL, NT, NU, PE, SK, YT
    }
    //Helper Method to check if the postcode is valid
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() !=6 ) {
            return false;
        }
        //For Loop
        for (int i = 0; i < 6; i++) {
            char c = postalCode.charAt(i);
            if (i % 2 == 0) {
                if (!Character.isLetter(c)) {
                    return false;
                }
            }
            else {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;
    }
    //Constructor
    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if(isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode;
        }
        else {
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }
}
