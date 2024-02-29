package main.java.com.http;
// Classe que representa uma resposta HTTP com código de status, status e mensagem.
public class HTTP {

    private int code;
    private String status;
    private String message;
    // Construtor da classe HTTP que inicializa os atributos.
   public HTTP(int code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    // Sobrescrita do método toString para representar a resposta HTTP em formato de string.
    @Override
    public String toString() {
        return "{"
                + "\n  \"code\": " + code
                + ",\n  \"status\": \"" + status
                + "\",\n  \"message\": \"" + message + "\"\n}\n";
    }
}
