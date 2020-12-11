import java.util.concurrent.atomic.AtomicInteger;

public class Endereco {

    private static final AtomicInteger counter = new AtomicInteger();

    private int id;
    private String cep;
    private Estado estado;
    private String logradouro;
    private String bairro;
    private String cidade;
    private int numero;

    public Endereco(String cep, Estado estado, String logradouro, String bairro, String cidade, int numero) {
        this.id = counter.incrementAndGet();
        this.cep = cep;
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
    }

    public static AtomicInteger getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", estado=" + estado +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", numero=" + numero +
                '}';
    }
}
