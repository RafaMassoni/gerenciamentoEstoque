package br.com.estoque.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CampoInvalido extends ErroRegraNegocio{


    public CampoInvalido() {
        super(HttpStatus.NOT_ACCEPTABLE,"Campo preenchido de forma incorreta");
    }

    public CampoInvalido(HttpStatus httpStatus, String message) {
        super(httpStatus,message);
    }

}
