package com.certicamara.certicamaraprueba1.web.controller;

import com.certicamara.certicamaraprueba1.domain.Query;
import com.certicamara.certicamaraprueba1.domain.dto.Character;
import com.certicamara.certicamaraprueba1.domain.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/queries")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/character")
    public ResponseEntity<String> getCharacter() {
        String nameCharacter = depurarDatostoString();
        Query query = new Query();
        queryService.save(query);
        try{
            queryService.save(query);//se guarda en la base de datos la consulta realizada a la API externa.
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(nameCharacter, HttpStatus.OK);
    }


    @GetMapping("/people")
    public ResponseEntity<List<Character>> getPeople() {
        List<Character> listaDepurada = depurarDatostoLista();
        Query query = new Query();
        queryService.save(query);
        try{
            queryService.save(query);//se guarda en la base de datos la consulta realizada a la API externa.
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(listaDepurada, HttpStatus.OK);
    }


    /**
     * Método que crea un objeto tipo Character desde una lista .
     * @return un String con el nombre del Character
     */
    private String depurarDatostoString() {
        List<Character> characterList = consumirAPIExterna();
        Character character;
        character = characterList.get(1);
        return character.getName();

    }

    /**
     * Método que llena una lista de objetos tipo Character con datos depurados
     * @return lista de objetos tipo character
     */
    private List<Character> depurarDatostoLista() {
        List<Character> characterList = consumirAPIExterna();
        List<Character> listaDepurada = new ArrayList<>();

        int i;
        for(i = 0; i < characterList.size(); i++) {
            Character character;
            character = characterList.get(i);
            listaDepurada.add(character);
        }
         return listaDepurada;
    }


    /**
     * Método que consume una API externa que obtiene un listado de datos(people)
     * @return lista de objetos tipo character
     */
    public List<Character> consumirAPIExterna(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Character[]> response =
                restTemplate.getForEntity(
                        "https://ghibliapi.herokuapp.com/people",
                        Character[].class);
        Character[] characters = response.getBody();
        return Arrays.asList(Objects.requireNonNull(characters));
    }


}
