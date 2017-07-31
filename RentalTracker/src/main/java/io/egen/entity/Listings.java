
package io.egen.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Listings.findByRent",
                query = "SELECT listings FROM Listings listings WHERE listings.rent=:person_maxRent"),

        @NamedQuery(name = "Listings.findAll",
                query = "SELECT listings FROM Listings listings ")
})

public class Listings {

    @Id
    private String Listing_Id;
    private String property_Manager;
    private String contactNo;
    private double latitude;
    private double longitude;
    private boolean recreation;
    private boolean publicTransport;
    private double rent;

    public Listings() { this.Listing_Id = UUID.randomUUID().toString();}

    public String getProperty_Manager() {
        return property_Manager;
    }

    public void setProperty_Manager(String property_Manager) {
        this.property_Manager = property_Manager;
    }

    public String getContact_No() {return contactNo;}

    public void setContact_No(String contact_No) {this.contactNo = contactNo;}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    public boolean isRecreation() {
        return recreation;
    }

    public void setRecreation(boolean recreation) {
        this.recreation = recreation;
    }

    public boolean isPublicTransport() {
        return publicTransport;
    }

    public void setPublicTransport(boolean publicTransport) {
        this.publicTransport = publicTransport;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Listings{" +
                "Listing_Id='" + Listing_Id + '\'' +
                ", Property_Manager='" + property_Manager + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", recreation=" + recreation +
                ", publicTransport=" + publicTransport +
                ", rent=" + rent +
                '}';
    }
}

