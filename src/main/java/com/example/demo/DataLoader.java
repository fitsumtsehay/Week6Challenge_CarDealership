package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.HashSet;

@Component

public class DataLoader implements CommandLineRunner{
    @Autowired
    CarCategoryRepository Repository;

    @Autowired
    CarRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        CarCategory sedan = new CarCategory();
        sedan.setType("Sedan");
        Repository.save(sedan);
    }
}