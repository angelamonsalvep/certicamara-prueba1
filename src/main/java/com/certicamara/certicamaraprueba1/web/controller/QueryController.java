package com.certicamara.certicamaraprueba1.web.controller;

import com.certicamara.certicamaraprueba1.domain.Query;
import com.certicamara.certicamaraprueba1.domain.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/queries")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/people")
    public ResponseEntity<List<Object>> getCats() {
        List<Object> people = consumirAPIexterna();
        Query query = new Query();
        queryService.save(query);
        try{
            queryService.save(query);//se guarda en la base de datos la consulta realizada a la API externa.
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    /**
     * Método que consume una API externa que obtiene un listado de datos(people)
     * @return lista de objetos tipo character
     */
    private List<Object> consumirAPIexterna() {
        Object[] character = null;
        try {
            String url= "https://ghibliapi.herokuapp.com/people";
            RestTemplate restTemplate = new RestTemplate();

            character= restTemplate.getForObject(url, Object[].class);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return Arrays.asList(Objects.requireNonNull(character));
    }

}
