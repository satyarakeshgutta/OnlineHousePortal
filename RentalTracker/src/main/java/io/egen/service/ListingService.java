package io.egen.service;

import io.egen.entity.Listings;

import java.util.List;

public interface ListingService {
     void create(Listings listings);
     List<Listings> getListings();
     List<Listings> findById(String vId);
     //void createAlerts( List<Readings> readings);
}
