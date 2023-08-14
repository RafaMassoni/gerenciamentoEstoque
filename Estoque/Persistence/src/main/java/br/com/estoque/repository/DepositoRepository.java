package br.com.estoque.repository;

import br.com.estoque.Deposito;
import br.com.estoque.entidades.DepositoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoRepository extends JpaRepository<DepositoEntidade,Long> {
}
