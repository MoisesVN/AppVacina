package br.com.projeto.testeapi.servicos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Método para lidar com exceções de validação que ocorrem quando argumentos de método não são válidos
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Cria um mapa para armazenar os erros
        Map<String, String> errors = new HashMap<>();
        
        // Itera por todos os erros de validação e adiciona o campo e a mensagem de erro ao mapa
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField(); // Nome do campo que falhou na validação
            String errorMessage = error.getDefaultMessage(); // Mensagem de erro associada
            errors.put(fieldName, errorMessage); // Adiciona o campo e a mensagem ao mapa
        });
        
        // Retorna o mapa de erros com status HTTP 400 (Bad Request)
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Método para lidar com exceções de validação de constraint (restrição) diretamente
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        // Cria um mapa para armazenar os erros
        Map<String, String> errors = new HashMap<>();
        
        // Itera por todas as violações de constraint e adiciona o campo e a mensagem de erro ao mapa
        ex.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString(); // Caminho do campo que falhou na validação
            String errorMessage = violation.getMessage(); // Mensagem de erro associada
            errors.put(fieldName, errorMessage); // Adiciona o campo e a mensagem ao mapa
        });
        
        // Retorna o mapa de erros com status HTTP 400 (Bad Request)
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
