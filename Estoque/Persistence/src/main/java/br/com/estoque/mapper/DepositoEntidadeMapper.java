package br.com.estoque.mapper;

import br.com.estoque.Deposito;
import br.com.estoque.entidades.DepositoEntidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface DepositoEntidadeMapper {

    DepositoEntidadeMapper INSTANCE = Mappers.getMapper(DepositoEntidadeMapper.class);



    Deposito toModel(final DepositoEntidade depositoEntidade);

    DepositoEntidade toEntidade(final Deposito deposito);

}
