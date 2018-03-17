package ua.yevhenii.controller;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.yevhenii.service.CurrentCurrencyService;

@RestController("/")
public class MainController {

    @Autowired
    CurrentCurrencyService service;

    /**
     * @param currency usd. eur, rur, uan, all(to get all currencies)
     * @param city
     * @param bank
     * @return
     */
    @RequestMapping("/banks/{currency}/{city}/{bank}")
    public String get(@PathVariable(name = "currency") String currency,
                      @PathVariable(name = "city") String city,
                      @PathVariable(name = "bank") String bank){

        return "";
    }

    @RequestMapping("/cities")
    public JSONArray cities(){
        return service.getCities();
    }
}
