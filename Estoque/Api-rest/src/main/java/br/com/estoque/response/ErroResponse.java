package br.com.estoque.response;


import org.springframework.http.HttpStatus;

public record ErroResponse(String titulo,
                           String descricao
) {
}
