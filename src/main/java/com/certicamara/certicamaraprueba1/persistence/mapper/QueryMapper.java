package com.certicamara.certicamaraprueba1.persistence.mapper;

import com.certicamara.certicamaraprueba1.domain.Query;
import com.certicamara.certicamaraprueba1.persistence.entity.Consulta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "Spring")
public interface QueryMapper {

    @Mappings({
            @Mapping(source = "idConsulta", target = "QueryId"),
            @Mapping(source = "fecha", target = "date")
    })
    Query toQuery(Consulta consulta);

    @InheritInverseConfiguration
    Consulta toConsulta(Query query);

}
