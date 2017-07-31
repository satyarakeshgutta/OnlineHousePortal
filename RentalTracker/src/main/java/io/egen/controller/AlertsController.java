package io.egen.controller;

import io.egen.entity.Alerts;
import io.egen.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "alerts")
public class AlertsController {

   @Autowired
    private AlertService alertService;

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> getAlerts() {
        return alertService.getAlerts();
    }

    //GET Alerts by id
    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> findOne(@PathVariable("id") String pId) {
        return alertService.findAlerts(pId);
    }
}
