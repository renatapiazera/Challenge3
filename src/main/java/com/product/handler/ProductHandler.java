package main.java.com.product.handler;

import main.java.com.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductHandler {

    List<Product> products = new ArrayList<Product>();

    public static void list() {
        System.out.println("1- Listando produtos\n");
    }

    public static void findById(int id) {
        System.out.println("2- Buscando produto\n");
    }

    public static void create(String name, String description, double value) {
        System.out.println("3- Criando produto\n");
    }

    public static void update(int id, String attribute, String value) {
        System.out.println("4- Atualizando produto\n");
    }

    public static void delete(int id) {
        System.out.println("5- Deletando produto\n");
    }
}
