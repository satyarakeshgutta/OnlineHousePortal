package io.egen.entity;

import javax.persistence.*;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.UUID;


@Entity
@NamedQueries({
                @NamedQuery(name = "Person.findById",
                    query = "SELECT person FROM Person person WHERE person.pId=:person_id"),
                @NamedQuery(name = "Person.findByRent",
                    query = "SELECT person FROM Person person WHERE person.maxRent<=:person_rent"),
                @NamedQuery(name = "Person.findAll",
                    query = "SELECT person FROM Person person ")

              })

public class Person {

    @Id
    private String pId;
    private String fName;
    private String lName;
    private String phoneNo;
    private String address;
    private int preferredRadius ;
    private boolean publicTransport;
    private boolean recreation;
    private double maxRent;

    public Person(){ this.pId = UUID.randomUUID().toString(); }

    public String getpId() { return pId; }

    public void setpId(String pId) { this.pId = pId; }
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPreferredRadius() {
        return preferredRadius;
    }

    public void setPreferredRadius(int preferredRadius) {
        this.preferredRadius = preferredRadius;
    }

    public boolean isPublicTransport() {
        return publicTransport;
    }

    public void setPublicTransport(boolean publicTransport) {
        this.publicTransport = publicTransport;
    }

    public boolean isRecreation() {
        return recreation;
    }

    public void setRecreation(boolean recreation) {
        this.recreation = recreation;
    }

    public double getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(double maxRent) {
        this.maxRent = maxRent;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phoneNo=" + phoneNo +
                ", address='" + address + '\'' +
                ", preferredRadius=" + preferredRadius +
                ", publicTransport=" + publicTransport +
                ", recreation=" + recreation +
                ", maxRent=" + maxRent +
                '}';
    }
}
