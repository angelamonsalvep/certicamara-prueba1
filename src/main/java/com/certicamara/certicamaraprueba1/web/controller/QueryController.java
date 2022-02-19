package com.certicamara.certicamaraprueba1.web.controller;

import com.certicamara.certicamaraprueba1.domain.Query;
import com.certicamara.certicamaraprueba1.domain.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/consultas")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/animals")
    public List<Object> getAnimals() {
        List<Object> animals = consumirAPIexterna();
        Query query = new Query();

        try{
            queryService.save(query);
        } catch (Exception e){
            e.printStackTrace();
        }


        return animals;


    }

    private List<Object> consumirAPIexterna() {
        Object[] animals = null;
        try {
            String url= "https://cat-fact.herokuapp.com/facts/";
            RestTemplate restTemplate = new RestTemplate();

            animals= restTemplate.getForObject(url, Object[].class);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Arrays.asList(Objects.requireNonNull(animals));
    }

}
