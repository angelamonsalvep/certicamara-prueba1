package com.certicamara.certicamaraprueba1.persistence;

import com.certicamara.certicamaraprueba1.persistence.crud.ConsultaCrudRepository;
import com.certicamara.certicamaraprueba1.persistence.entity.Consulta;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultaRepository {
    private ConsultaCrudRepository consultaCrudRepository;

    public Consulta save(Consulta consulta) {
        return consultaCrudRepository.save(consulta);
    }
}
