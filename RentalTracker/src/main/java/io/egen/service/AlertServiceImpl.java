package io.egen.service;
import io.egen.entity.Alerts;
import io.egen.entity.Listings;
import io.egen.entity.Person;
import io.egen.repository.AlertsRepo;
import io.egen.repository.ListingsRepo;
import io.egen.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertsRepo alertsRepo;

    @Override
    public List<Alerts> getAlerts() {
        List<Alerts> foundAlerts = alertsRepo.findAlerts();
        return foundAlerts;
    }

    @Override
    public List<Alerts> findAlerts(String personId) {
        List<Alerts> foundAlertsbyId = alertsRepo.findAlertsbyId(personId);
        return foundAlertsbyId;
    }

   /* @Autowired
    ListingsRepo listingsRepo;
    PersonRepo personRepo;

    @Override
    @Transactional
    public void create(List<Listings> listings) {
        List<Alerts> alerts = new ArrayList<>();
        for (Listings l : listings) {
            double cur_rent = l.getRent();

            Listings listings_existing = listingsRepo.findbyRent(cur_rent);
            Person person_existing = personRepo.findbyRent(cur_rent);

            //Checks for Alerts
            Alerts newalert = new Alerts();
            if (listings_existing != null && person_existing != null) {

                String address = person_existing.getAddress();
                double distance=0.00;
                try {
                    String[] data_location = getLatLongPositions(address);
                    double user_lat = Double.parseDouble(data_location[0]);
                    double user_long = Double.parseDouble(data_location[1]);

                    distance = find_distance(user_lat,listings_existing.getLatitude(),user_long,listings_existing.getLongitude(),
                            0.00,0.00);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (listings_existing.getRent() <= person_existing.getMaxRent()) {
                    newalert.setPriceAlert("Found a Listing With a Matching Price");
                }
                if (distance < person_existing.getPreferredRadius()) {
                    newalert.setRadiusAlert("Found a Listing with in a"+person_existing.getPreferredRadius()+" KM distance");
                }
            }
            alerts.add(newalert);
        }
        alertsRepo.create(alerts);
    }

    //Distance

    public static double find_distance(double lat1, double lat2, double lon1,
                                  double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    //LAT & LONG

        public String[] getLatLongPositions(String address) throws Exception
        {
            int responseCode = 0;
            String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
            URL url = new URL(api);
            HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
            httpConnection.connect();
            responseCode = httpConnection.getResponseCode();
            if(responseCode == 200)
            {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
                Document document = builder.parse(httpConnection.getInputStream());
                XPathFactory xPathfactory = XPathFactory.newInstance();
                XPath xpath = xPathfactory.newXPath();
                XPathExpression expr = xpath.compile("/GeocodeResponse/status");
                String status = (String)expr.evaluate(document, XPathConstants.STRING);
                if(status.equals("OK"))
                {
                    expr = xpath.compile("//geometry/location/lat");
                    String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
                    expr = xpath.compile("//geometry/location/lng");
                    String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
                    return new String[] {latitude, longitude};
                }
                else
                {
                    throw new Exception("Error from the API - response status: "+status);
                }
            }
            return null;
        }*/
}


