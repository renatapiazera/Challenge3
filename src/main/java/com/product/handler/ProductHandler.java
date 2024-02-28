package main.java.com.product.handler;

import main.java.com.http.HTTP;
import main.java.com.product.Product;
import java.util.List;

public class ProductHandler {

    public ProductHandler() {
    }

    public HTTP listAll(List<Product> products) {
        if (products.isEmpty()) {
            return new HTTP(404, "Not Found", "The requested resource was not found.");
        } else {
            System.out.println(new HTTP(200, "OK", "Request successful."));
            for (Product p : products) {
                System.out.println(p.toString());
            }
        }
        return null;
    }

    public void findById(int id, List<Product> products) {
        if (products.isEmpty()) {
            // Lista vazia, retorna erro 404 em formato JSON
            System.out.println(new HTTP(404, "Not Found", "The requested resource was not found."));
            return;
        } else {
            for (Product product : products) {
                if (product.getId() == id) {
                    // Produto encontrado, imprime as informações
                    System.out.println(new HTTP(200, "OK", "Request successful."));
                    System.out.println("Product found:");
                    System.out.println(product.toString());
                    return;
                }
            }
        }
        // Produto não encontrado, retorna erro 400 em formato JSON
        System.out.println(new HTTP (400, "Invalid request", "Invalid request."));
    }

    public Product create(Product product, List<Product> products) throws DuplicateProductNameException {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(product.getName())) {
                throw new DuplicateProductNameException("The insertion criteria must be adhered to.");
            }
        }
        products.add(product);
        System.out.println(new HTTP(200, "OK", "Request successful."));
        return product;
    }
    // Exceção personalizada para lidar com nomes de produtos duplicados
    public static class DuplicateProductNameException extends Exception {
        public DuplicateProductNameException(String message) {
            super(message);
        }
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

    public void delete(int id, List<Product> products) {
        int index = -1;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            products.remove(index);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
}
