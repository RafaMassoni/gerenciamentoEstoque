package br.com.estoque.mapper;

import br.com.estoque.Deposito;
import br.com.estoque.request.DepositoRequest;
import br.com.estoque.response.DepositoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface DepositoMapper {

    DepositoMapper INSTANCE = Mappers.getMapper(DepositoMapper.class);


    @Mapping(target = "id", ignore = true)
    Deposito toModel(final DepositoRequest depositoRequest);

    DepositoResponse toResponse(final Deposito deposito);

}
