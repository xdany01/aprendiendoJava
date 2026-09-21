package org.example.app.practicas.practica15;

import org.example.app.helpful.Logger;

public class Practica15 {
    public void testVenta() {
        ProductFactory factory = new ProductFactory();

        Product manzana = factory.create("Manzana", 10.0);
        Product pera = factory.create("Pera", 8.0);
        Product banana = factory.create("Banana", 12.0);
        Product sandia = factory.create("Sandia", 15.0);

        Order order = new Order();
        order.addProduct(manzana)
                .addProduct(pera)
                .addProduct(banana)
                .addProduct(sandia);

        Logger.title("Sistema de ventas");
        order.showOrder();
    }
}
