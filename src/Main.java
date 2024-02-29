import main.java.com.http.HTTP;
import main.java.com.product.Product;
import main.java.com.product.handler.ProductHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Cria um objeto ProductHandler para lidar com operações de produtos
        ProductHandler productHandler = new ProductHandler();
        // Lista que armazenará os produtos
        List<Product> products = new ArrayList<>();

        String name;
        String description;
        double value;
        int maxId = 1;
        // Loop principal do programa que exibe um menu e realiza operações com base na escolha do usuário
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
                    // Lista todos os produtos registrados
                    System.out.println("--- Registered products ---");
                    HTTP listMessage = productHandler.listAll(products);
                    System.out.println(listMessage);
                    break;
                case 2:
                    // Procura um produto pelo ID
                    System.out.println("--- Search product by ID ---");
                    System.out.print("Enter ID: ");
                    int productIdToFind = Integer.parseInt(sc.nextLine());
                    productHandler.findById(productIdToFind, products);
                    break;
                case 3:
                    // Adiciona um novo produto
                    System.out.println("--- Add product ---");
                    System.out.print("Product's name: ");
                    name = sc.nextLine();

                    // Verifica se o nome tem pelo menos 3 caracteres
                    if (name.length() < 3) {
                        System.out.println(new HTTP(403, "Forbidden", "The insertion criteria must be adhered to."));
                        System.out.println("Error: Enter a valid name.");
                        continue; // Volta para o início do loop para mostrar o menu novamente
                    }
                    // Bloco try-catch para lidar com exceções durante a entrada do usuário
                    try {
                        System.out.print("Description (The description must contain at least 10 characters): ");
                        description = sc.nextLine();

                        // Verifica se a descrição tem pelo menos 10 caracteres
                        if (description.length() < 10) {
                            System.out.println(new HTTP(403, "Forbidden", "The insertion criteria must be adhered to."));
                            System.out.println("Error: Enter a valid description with at least 10 characters.");
                            continue; // Volta para o início do loop para mostrar o menu novamente
                        }

                        // Verifica se o valor é um número positivo
                        System.out.print("Value: ");
                        value = Double.parseDouble(sc.nextLine());
                        if (value <= 0) {
                            System.out.println(new HTTP(403, "Forbidden", "The insertion criteria must be adhered to."));
                            System.out.println("Error: Enter a valid value.");
                            continue;
                        }
                        // Cria um novo produto e o adiciona à lista de produtos
                        Product p = new Product(maxId, name, description, value);
                        productHandler.create(p, products);
                        maxId++;
                    } catch (ProductHandler.DuplicateProductNameException e) {
                        // Captura a exceção se um produto com o mesmo nome já existir
                        System.out.println(new HTTP(403, "Forbidden", e.getMessage()));
                        System.out.println("Error: Product with the same name already exists.");
                        continue;
                    } catch (NumberFormatException e) {
                        // Captura a exceção se o valor não for um número
                        System.out.println(new HTTP(403, "Forbidden", "The insertion criteria must be adhered to."));
                        System.out.println("Error: Enter a valid value.");
                        continue;
                    }
                    break;


                case 4:
                    // Atualiza as informações de um produto
                    System.out.println("--- Update product ---");
                    System.out.print("Product ID to be updated: ");
                    int productIdToUpdate = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter the attribute to be updated (name/description/value): ");
                    String attributeToUpdate = sc.nextLine();
                    System.out.print("New value: ");
                    String newValue = sc.nextLine();
                    productHandler.update(productIdToUpdate, attributeToUpdate, newValue, products);
                    break;
                case 5:
                    // Exclui um produto
                    System.out.println("--- Delete product ---");
                    System.out.print("Product ID to be deleted: ");
                    int idDelete = Integer.parseInt(sc.nextLine());
                    productHandler.delete(idDelete, products);
                    break;
            }
        }
    }
    // Método auxiliar para exibir o menu
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