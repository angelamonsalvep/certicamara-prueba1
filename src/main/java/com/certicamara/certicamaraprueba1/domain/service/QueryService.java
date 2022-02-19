package com.certicamara.certicamaraprueba1.domain.service;

import com.certicamara.certicamaraprueba1.domain.Query;
import com.certicamara.certicamaraprueba1.domain.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    @Autowired
    private QueryRepository queryRepository;

    public Query save(Query query) {
        return queryRepository.save(query);
    }

}
