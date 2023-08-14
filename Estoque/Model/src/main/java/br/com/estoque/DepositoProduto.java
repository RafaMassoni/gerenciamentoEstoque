package br.com.estoque;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositoProduto {

    private Long idDeposito;
    private Long idProduto;

    private Integer quantidade;
}
