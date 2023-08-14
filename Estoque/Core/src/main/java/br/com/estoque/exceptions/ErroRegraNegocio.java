package br.com.estoque.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErroRegraNegocio extends RuntimeException{

    private final HttpStatus httpStatus;

    public ErroRegraNegocio(HttpStatus httpStatus,String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
