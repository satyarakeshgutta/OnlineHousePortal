package io.egen.repository;
import io.egen.entity.Alerts;

import java.util.List;

public interface AlertsRepo {
    void create(List<Alerts> alerts);
    List<Alerts> findAlerts();
    List<Alerts> findAlertsbyId(String pid);
}
