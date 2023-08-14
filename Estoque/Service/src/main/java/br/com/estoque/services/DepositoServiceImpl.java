package br.com.estoque.services;


import br.com.estoque.Deposito;
import br.com.estoque.persistences.DepositoPersistence;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DepositoServiceImpl implements DepositoService{

    @Autowired
    private DepositoPersistence depositoPersistence;

    @Override
    public Page<Deposito> buscarTodos(Pageable pageable) {
        log.debug("Buscar todos depositos");
        return depositoPersistence.buscarTodos(pageable);
    }

    @Override
    public Deposito inserir(Deposito deposito) {
        log.debug("Inserir deposito");
        return depositoPersistence.inserir(deposito);
    }

    @Override
    public Deposito atualizar(Deposito deposito) {
        log.debug("Atualizar deposito");
        return depositoPersistence.atualizar(deposito);
    }


    @Override
    public void removerPorId(Long idDeposito) {
        log.debug("Remover deposito");
        depositoPersistence.removerPorId(idDeposito);

    }

    @Override
    public Deposito buscarPorId(Long idDeposito) {
        log.debug("Buscar deposito por ID");
        return depositoPersistence.buscarPorId(idDeposito);
    }


}
