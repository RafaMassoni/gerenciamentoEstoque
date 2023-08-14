package br.com.estoque.persistences;


import br.com.estoque.Deposito;
import br.com.estoque.entidades.DepositoEntidade;
import br.com.estoque.exceptions.CampoInvalido;
import br.com.estoque.exceptions.EntidadeNaoEncontrada;
import br.com.estoque.mapper.DepositoEntidadeMapper;
import br.com.estoque.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepositoPersistenceImpl implements DepositoPersistence{

    @Autowired
    private DepositoRepository depositoRepository;

    private final DepositoEntidadeMapper depositoMapper = DepositoEntidadeMapper.INSTANCE;

    @Override
    public Page<Deposito> buscarTodos(Pageable pageable) {

        Page<DepositoEntidade> depositoPage = depositoRepository.findAll(pageable);

        List<Deposito> listaDepositos = depositoPage.stream()
                .map(depositoMapper::toModel)
                .toList();

        return new PageImpl<>(listaDepositos, depositoPage.getPageable(), depositoPage.getTotalElements());
    }

    @Override
    public Deposito inserir(Deposito deposito) {

        DepositoEntidade depositoEntidade = depositoMapper.toEntidade(deposito);
        depositoEntidade.setId(null);

        depositoEntidade = depositoRepository.save(depositoEntidade);
        return depositoMapper.toModel(depositoEntidade);
    }

    @Override
    public Deposito buscarPorId(Long idDeposito) {

        DepositoEntidade depositoEntidade = depositoRepository.findById(idDeposito)
                .orElseThrow(() -> new EntidadeNaoEncontrada(HttpStatus.NOT_FOUND,"Depósito não foi encontrado na base de dados"));

        return depositoMapper.toModel(depositoEntidade);
    }

    @Override
    public void removerPorId(Long idDeposito) {

        if (depositoRepository.existsById(idDeposito)) {
            depositoRepository.deleteById(idDeposito);
        }
        else
        {
            throw new CampoInvalido(HttpStatus.NOT_ACCEPTABLE,"Id do depósito não existe");
        }

    }

    @Override
    public Deposito atualizar(Deposito deposito) {

        if (deposito.getId() == null) {
            throw new CampoInvalido(HttpStatus.NOT_ACCEPTABLE,"Id do depósito não foi informado");
        }

        DepositoEntidade depositoEntidade = depositoMapper.toEntidade(deposito);
        depositoEntidade = depositoRepository.save(depositoEntidade);
        return depositoMapper.toModel(depositoEntidade);
    }
}
