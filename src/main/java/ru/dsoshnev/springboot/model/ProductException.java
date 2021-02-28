package ru.dsoshnev.springboot.model;

import java.io.IOException;

public class ProductException extends IOException {

    public ProductException(String message) {
        super(message);
    }
}
