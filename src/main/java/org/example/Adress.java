package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@ToString
@EqualsAndHashCode
    
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
    /**
     * Checks if the postal code is valid
     * A valid postal code: Isnt null, must be 6 digits, must be CDCDCD
     * @param postalCode the postal code in question
     * @return true if its a valid postal code, false if it isnt
     */
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
    /**
     * This creates the Address
     * If postal code isnt valid, the fields are null
     * @param streetNo street number
     * @param street street name
     * @param city city name
     * @param province Canadian province
     * @param postalCode postal code
     */
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
    //Getters
    /**
     * Gets all fields
     * @return the values stored in address
     */
    public int getStreetNo() {
        return streetNo;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public Province province() {
        return province;
    }
    public String getPostalCode() {
        return postalCode;
    }

    //Setters
    /**
     * Sets all fields
     * Updates the values stored in Address
     */
    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setProvince(Province province) {
        this.province = province;
    }
    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        }
    }
    //toString Method
    /**
     * returns the entire address with all fields
     * @return the address
     */
    @Override
    public String toString() {
        return streetNo + " " + street + ", " + city + " " + province + " " + postalCode;
    }
    //Equals Method
    /**
     *
     * @param obj   the reference object with which to compare.
     * @return true if the obj shows the same address, false if it doesnt
     */
    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Address other = (Address) obj;

        return  streetNo == other.streetNo &&
                street.equals(other.street) &&
                city.equals(other.city) &&
                province == other.province &&
                postalCode.equals(other.postalCode);
        
    }
}
