package at.ac.fhcampuswien.fhmarketplace.model;

public class Address {
    public String city;
    public String zip;
    public String street;
    public String houseNr;

    public Address(String city, String zip, String street, String houseNr) {
        super();
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.houseNr = houseNr;
    }
}
