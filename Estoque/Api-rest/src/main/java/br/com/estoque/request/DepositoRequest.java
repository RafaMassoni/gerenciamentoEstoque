package br.com.estoque.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositoRequest {


    @NotBlank(message = "Nome do depósito deve ser preenchido")
    private String nome;


}
