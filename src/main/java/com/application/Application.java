package main.java.com.application; //local onde está este código

import main.java.com.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {

    static Scanner sc = new Scanner(System.in);

    public static void run() {
        while (true) {
            showMenu(); //EXIBE OPÇÕES DO MENU
            int option = Integer.parseInt(sc.nextLine());   //COLETA OPÇÃO DIGITADA PELO USUÁRIO E O
                                                            // Integer.parseInt PEGA TUDO E CONVERTE PRA INTEIRO
            menu(option);
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

    public static void menu(int option) {
        List<Product> products = new ArrayList<>();
        Product product = new Product();

        switch(option) {

            case 0:
                sc.close();
                System.exit(0);
                break;
            case 1:
                break;

        }
    }
}
