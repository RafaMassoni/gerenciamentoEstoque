package br.com.estoque.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EntidadeNaoEncontrada extends ErroRegraNegocio{


    public EntidadeNaoEncontrada() {
        super(HttpStatus.NOT_FOUND,"Entidade não foi encontrada");
    }

    public EntidadeNaoEncontrada(HttpStatus httpStatus, String message) {
        super(httpStatus,message);
    }

}
