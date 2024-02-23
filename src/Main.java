import main.java.com.product.Product;
import main.java.com.product.handler.ProductHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductHandler productHandler = new ProductHandler();

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        int id;
        String name;
        String description;
        double value;
        int maxId = 1;

        while (true) {
            showMenu(); //EXIBE OPÇÕES DO MENU
            int option = Integer.parseInt(sc.nextLine());   //COLETA OPÇÃO DIGITADA PELO USUÁRIO E O
            // Integer.parseInt PEGA TUDO E CONVERTE PRA INTEIRO

            switch(option) {

                case 0:
                    sc.close();
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("--- Registered products ---");
                    productHandler.listAll(products);
                    break;
                case 3:
                    System.out.println("--- Adicionar produto ---");
                    System.out.print("Nome do produto: ");
                    name = sc.nextLine();
                    System.out.println("Descrição: ");
                    description = sc.nextLine();
                    System.out.println("Valor: ");
                    value = Double.parseDouble(sc.nextLine());
                    Product p = new Product(maxId, name, description, value);
                    productHandler.create(p, products);
                    maxId++;
                    System.out.println("Produto criado.");
                    System.out.println(p.toString());
                    break;
                case 4:
                    System.out.println("--- Update product ---");
                    System.out.print("Product ID to be updated: ");
                    int productIdToUpdate = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter the attribute to be updated (name/description/value): ");
                    String attributeToUpdate = sc.nextLine();
                    System.out.print("New value: ");
                    String newValue = sc.nextLine();
                    productHandler.update(productIdToUpdate, attributeToUpdate, newValue, products);
                    break;
            }
        }
    }
    public static void showMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1 - List products");
        System.out.println("2 - Find product by id");
        System.out.println("3 - Create product");
        System.out.println("4 - Update product");
        System.out.println("5 - Delete product");
        System.out.println("0 - Exit");
    }
}