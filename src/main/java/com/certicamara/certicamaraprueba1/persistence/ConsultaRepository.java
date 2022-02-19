package com.certicamara.certicamaraprueba1.persistence;

import com.certicamara.certicamaraprueba1.domain.Query;
import com.certicamara.certicamaraprueba1.domain.repository.QueryRepository;
import com.certicamara.certicamaraprueba1.persistence.crud.ConsultaCrudRepository;
import com.certicamara.certicamaraprueba1.persistence.entity.Consulta;
import com.certicamara.certicamaraprueba1.persistence.mapper.QueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultaRepository implements QueryRepository {

    @Autowired
    private ConsultaCrudRepository consultaCrudRepository;

    @Autowired
    private QueryMapper mapper;


    @Override
    public Query save(Query query) {
        Consulta consulta = mapper.toConsulta(query);
        return mapper.toQuery(consultaCrudRepository.save(consulta));
    }
}
