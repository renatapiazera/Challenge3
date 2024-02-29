package main.java.com.product;
// A classe representa um produto com suas características básicas.
public class Product {

    final private int id;  // Identificador único do produto.
    private String name;
    private String description;
    private double value;
    // Construtor que permite a criação de um produto com atributos específicos.
    public Product(int id, String name, String description, double value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
    }
    // Métodos de acesso para obter informações sobre o produto.
    // Retorna o identificador único do produto.
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    // Define um novo nome para o produto.
    public void setName(String name) {
        this.name = name;
    }
    // Define uma nova descrição para o produto.
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    // Define um novo valor monetário para o produto.
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    // Retorna uma representação em formato de string do objeto Product.
    //Formato JSON, conforme solicitado na Regra de Negócio.
    @Override
    public String toString() {
        return "{"
                + "\n  \"id\": " + id
                + ",\n  \"name\": \"" + name
                + "\",\n  \"description\": \"" + description + "\""
                + ",\n  \"value\": " + value + "\n}\n";
    }
}
