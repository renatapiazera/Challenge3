package main.java.com.product.handler;

import main.java.com.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductHandler {

    public ProductHandler() {
    }

    public void listAll(List<Product> products) {
        for (Product p: products) {
            System.out.println(p.toString());
        }
    }

    public void findById(int id) {
        System.out.println("2- Buscando produto\n");
    }

    public Product create(Product product, List<Product> products) {
        System.out.println("3- Criando produto\n");
        products.add(product);
        return product;
    }

    public void update(int id, String attribute, String value) {
        System.out.println("4- Atualizando produto\n");
    }

    public void delete(int id) {
        System.out.println("5- Deletando produto\n");
    }
}
