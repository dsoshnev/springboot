package ru.dsoshnev.springboot.repository;

import ru.dsoshnev.springboot.model.*;

import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {

}
