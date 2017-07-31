package io.egen.service;

import io.egen.entity.Alerts;

import java.util.List;

public interface AlertService {
     List<Alerts> getAlerts();
     List<Alerts> findAlerts(String personId);
}
