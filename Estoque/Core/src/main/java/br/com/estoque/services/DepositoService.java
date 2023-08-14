package br.com.estoque.services;


import br.com.estoque.Deposito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface DepositoService {

    Page<Deposito> buscarTodos(Pageable pageable);

    Deposito inserir(final Deposito deposito);

    Deposito atualizar(final Deposito deposito);

    void removerPorId(final Long idDeposito);


    Deposito buscarPorId(Long idDeposito);
}
