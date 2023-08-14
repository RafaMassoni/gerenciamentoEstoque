package br.com.estoque.persistences;

import br.com.estoque.Deposito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepositoPersistence {
    Page<Deposito> buscarTodos(Pageable pageable);

    Deposito inserir(Deposito deposito);

    Deposito buscarPorId(Long idDeposito);

    void removerPorId(Long idDeposito);

    Deposito atualizar(Deposito deposito);
}
