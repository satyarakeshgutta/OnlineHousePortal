package io.egen.controller;

import io.egen.entity.Listings;
import io.egen.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "listings")
public class ListingsController {

    @Autowired
    private ListingService listingService;

    //@CrossOrigin(origins ="http://localhost:8080/RentalTracker")
    @RequestMapping(method = RequestMethod.POST)
    public void create( @RequestBody Listings listings) {
        listingService.create(listings);
        //readingService.getAlerts(readings);
    }

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Listings> getListings() {
        return listingService.getListings();
    }

    //GET readings by id
    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Listings> findListingsByID(@PathVariable("id") String pId) {
        return listingService.findById(pId);
    }

}