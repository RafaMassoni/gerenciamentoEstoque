package br.com.estoque.services;


import br.com.estoque.Deposito;
import br.com.estoque.DepositoProduto;

public interface DepositoProdutoService {

    DepositoProduto gravar(final DepositoProduto depositoProduto);

    void remover(final Long idDepositoProduto);

}
