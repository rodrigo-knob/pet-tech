package br.com.fiap.pettech.pet_tech.controller.exception;

public class ControllerNotFoundException extends RuntimeException {
    public ControllerNotFoundException(String message) {
        super(message);
    }
}
