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
}
