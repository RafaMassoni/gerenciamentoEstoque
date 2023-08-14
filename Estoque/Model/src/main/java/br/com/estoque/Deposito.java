package br.com.estoque;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deposito {

    private Long id;
    private String nome;
}
