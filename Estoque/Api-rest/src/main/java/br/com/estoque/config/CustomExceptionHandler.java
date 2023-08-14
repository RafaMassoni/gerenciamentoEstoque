package br.com.estoque.config;

import br.com.estoque.exceptions.CampoInvalido;
import br.com.estoque.exceptions.ErroRegraNegocio;
import br.com.estoque.response.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ErroRegraNegocio.class)
    public ResponseEntity<Object> campoInvalido(ErroRegraNegocio ex, WebRequest request) {
        ErroResponse errorResponse = getErroResponse(ex, request);
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ex.printStackTrace();
        ErroResponse errorResponse = getErroResponse(ex, request);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private static ErroResponse getErroResponse(Exception ex, WebRequest request) {
        // Criar um objeto de resposta personalizado para o erro
        return new ErroResponse(
                ex.getMessage(),
                request.getDescription(false));
    }
}