package org.example.app.practicas.practica15;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductFactory {
    private final AtomicInteger nextId = new AtomicInteger(0);

    public Product create(String name, double price) {
        return new Product(nextId.incrementAndGet(), name, price);
    }
}
