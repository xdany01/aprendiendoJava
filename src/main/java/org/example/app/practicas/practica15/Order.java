package org.example.app.practicas.practica15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private final AtomicInteger nextId = new AtomicInteger(0);
    private int id;
    private List<Product> products;

    public Order() {
        id = nextId.incrementAndGet();
        products = new ArrayList<>();
    }

    public Order(List<Product> products) {
        id = nextId.incrementAndGet();
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Order addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    public double calcularTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.price();
        }
        return total;
    }

    public void showOrder() {
        System.out.println("Id: " + id);
        System.out.println("\tTotal: " + calcularTotal());
        System.out.println("\tProductos: ");
        for (Product product : products) {
            System.out.println("\t\t" + product);
        }
    }
}
