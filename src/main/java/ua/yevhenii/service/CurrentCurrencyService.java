package ua.yevhenii.service;

import com.mongodb.DBObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yevhenii.repository.CurrentCurrencyRepository;

import java.util.List;

@Service
public class CurrentCurrencyService {
    @Autowired
    CurrentCurrencyRepository repository;

    public JSONObject getCityByName(String name){
        JSONObject jsonObject = new JSONObject(repository.findBanksByCity(name).toMap());
        return jsonObject;
    }

    public JSONArray getCities(){
        List<DBObject> allCitiesWitnCodes = repository.findAllCitiesWithCodes();
        JSONArray jsonArray = new JSONArray();
        allCitiesWitnCodes.forEach(item ->{
            jsonArray.add(item.toMap());
        });
        return jsonArray;
        //        JSONObject jsonObject = new JSONObject(repository.findAllCitiesWithCodes())
    }


}
