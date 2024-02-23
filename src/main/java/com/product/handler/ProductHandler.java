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

    public void findById(int id, List<Product> products) {
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println("Product found:");
                System.out.println(product.toString());
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public Product create(Product product, List<Product> products) {
        System.out.println("3- Criando produto\n");
        products.add(product);
        return product;
    }

    public void update(int id, String attribute, String value, List<Product> products) {for (Product product : products) {
        if (product.getId() == id) {
            switch (attribute.toLowerCase()) {
                case "name":
                    product.setName(value);
                    break;
                case "description":
                    product.setDescription(value);
                    break;
                case "value":
                    try {
                        double doubleValue = Double.parseDouble(value);
                        product.setValue(doubleValue);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Value is not a valid number.");
                    }
                    break;
                default:
                    System.out.println("Error: Invalid attribute.");
                    return;
            }
            System.out.println("Product updated successfully.");
            System.out.println(product.toString());
            return;
        }
    }
        System.out.println("Product not found.");
    }

    public void delete(int id) {
        System.out.println("5- Deletando produto\n");
    }
}
