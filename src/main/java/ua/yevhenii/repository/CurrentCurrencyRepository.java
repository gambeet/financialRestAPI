package ua.yevhenii.repository;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrentCurrencyRepository {

    @Autowired
    MongoTemplate template;

    public DBObject findBanksByCity(String city){
        return template.getCollection("cities").findOne(new BasicDBObject("city", city));
    }

    public List findAll(){
        return template.getCollection("cities").find().toArray();
    }

    public List findAllCitiesWithCodes(){
        BasicDBObject query = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        fields.append("_id", "0");
        fields.append("code", "1");
        fields.append("name", "1");
        List<DBObject> cities = template.getCollection("cities").find(query, fields).toArray();
        System.err.println(cities.size());
        return cities;
    }
}
