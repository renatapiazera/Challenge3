package main.java.com.product.handler;

import main.java.com.http.HTTP;
import main.java.com.product.Product;
import java.util.List;

public class ProductHandler {
    // Construtor padrão da classe ProductHandler
    public ProductHandler() {
    }
    /*
     * Lista todos os produtos.
     * @param products Lista de produtos a serem listados.
     * @return HTTP com o resultado da operação.
     */
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
    /*
     * Busca um produto pelo ID.
     * @param id ID do produto a ser buscado.
     * @param products Lista de produtos onde será realizada a busca.
     */
    public void findById(int id, List<Product> products) {
        if (products.isEmpty()) {
            System.out.println(new HTTP(404, "Not Found", "The requested resource was not found."));
            return;
        } else {
            for (Product product : products) {
                if (product.getId() == id) {
                    System.out.println(new HTTP(200, "OK", "Request successful."));
                    System.out.println("Product found:");
                    System.out.println(product.toString());
                    return;
                }
            }
        }
        System.out.println(new HTTP (400, "Invalid request", "Invalid request."));
    }
    /*
     * Cria um novo produto.
     * @param product Produto a ser criado.
     * @param products Lista de produtos onde será adicionado o novo produto.
     * @return Produto criado.
     * @throws DuplicateName Exceção lançada se já existir um produto com o mesmo nome.
     */
    public Product create(Product product, List<Product> products) throws DuplicateName {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(product.getName())) {
                throw new DuplicateName("The insertion criteria must be adhered to.");
    /*
    O throw é utilizado para explicitamente lançar uma exceção. Quando é encontrado uma condição
    de erro ou situação excepcional no código, é possível usar throw para lançar uma instância
    de uma classe de exceção.
    */
            }
        }
        products.add(product);
        System.out.println(new HTTP(200, "OK", "Request successful."));
        System.out.println(product.toString());
        return product;
    }
    // Exceção personalizada para lidar com nomes de produtos duplicados
    public static class DuplicateName extends Exception {
        public DuplicateName(String message) {
            super(message);
        }
    }
    /*
     * Atualiza um produto.
     * @param id ID do produto a ser atualizado.
     * @param attribute Atributo a ser atualizado (name/description/value).
     * @param value Novo valor para o atributo.
     * @param products Lista de produtos onde será realizado a atualização.
     */
    public void update(int id, String attribute, String value, List<Product> products) {
        for (Product product : products) {
            if (product.getId() == id) {
                switch (attribute.toLowerCase()) {
                    case "name":
                        try {
                            validateName(value);
                            product.setName(value);
                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("Error: " + e.getMessage());
                        }
                        break;
                    case "description":
                        try {
                            validateDescription(value);
                            product.setDescription(value);
                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("Error: " + e.getMessage());
                        }
                        break;
                    case "value":
                        try {
                            double doubleValue = Double.parseDouble(value);
                            validateValue(doubleValue);
                            product.setValue(doubleValue);
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Error: Invalid value format. Please enter a valid number.");
                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("Error: " + e.getMessage());
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Error: Invalid attribute.");
                }
                System.out.println("Product updated successfully.");
                System.out.println(product.toString());
                return;
            }
        }
        throw new IllegalArgumentException("Error: Product not found.");
    }

    // Métodos de validação auxiliares
    private void validateName(String name) {
        if (name.trim().isEmpty() || name.length() < 3) {
            throw new IllegalArgumentException("Name must not be empty and must have at least 3 characters.");
        }
    }

    private void validateDescription(String description) {
        if (description.length() < 10) {
            throw new IllegalArgumentException("Description must have at least 10 characters.");
        }
    }

    private void validateValue(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be a positive number greater than 0.");
        }
    }
    /*
     * Deleta um produto.
     * @param id ID do produto a ser deletado.
     * @param products Lista de produtos onde será realizado a exclusão.
     */
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
