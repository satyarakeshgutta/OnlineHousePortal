package io.egen.repository;

import io.egen.entity.Listings;

import java.util.List;

public interface ListingsRepo {
     void create(Listings listings);
     List<Listings> getAllListings();
     List<Listings> getListingsById(String vin);
     //void createAlerts(List<Alerts> alerts);
     //Listings findby(String Vin);
}
