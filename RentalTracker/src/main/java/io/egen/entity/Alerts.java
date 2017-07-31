package io.egen.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alerts.findAll",
                query = "SELECT alerts FROM Alerts alerts "),

        @NamedQuery(name = "Alerts.findById",
                query = "SELECT alerts FROM Alerts alerts WHERE alerts.personId=:person_id"),
})

public class Alerts {

    @Id
    private String alertId;
    private String alertTime;
    private String personId;
    private String priceAlert;
    private String radiusAlert;
    private String locationAlert;

    public Alerts() { this.alertId= UUID.randomUUID().toString(); }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(String alertTime) {
        this.alertTime = alertTime;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPriceAlert() {
        return priceAlert;
    }

    public void setPriceAlert(String priceAlert) {
        this.priceAlert = priceAlert;
    }

    public String getRadiusAlert() {
        return radiusAlert;
    }

    public void setRadiusAlert(String radiusAlert) {
        this.radiusAlert = radiusAlert;
    }

    public String getLocationAlert() {
        return locationAlert;
    }

    public void setLocationAlert(String locationAlert) {
        this.locationAlert = locationAlert;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "alertId='" + alertId + '\'' +
                ", alertTime='" + alertTime + '\'' +
                ", personId='" + personId + '\'' +
                ", priceAlert='" + priceAlert + '\'' +
                ", radiusAlert='" + radiusAlert + '\'' +
                ", locationAlert='" + locationAlert + '\'' +
                '}';
    }
}


