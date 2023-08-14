package br.com.estoque.response;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositoResponse {


    private Long id;
    private String nome;


}
