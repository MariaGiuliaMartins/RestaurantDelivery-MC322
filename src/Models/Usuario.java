package Models;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class Usuario {

    private static final AtomicInteger counter = new AtomicInteger();

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Sexo sexo;
    private String telefone;
    private Endereco endereco;
    private boolean status;
    private Calendar dataCriacao;

    public Usuario(String nome, String cpf, String email, String senha, Sexo sexo, String telefone, Endereco endereco, boolean status, Calendar dataCriacao) {
        this.id = counter.incrementAndGet();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.telefone = telefone;
        this.endereco = endereco;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public static AtomicInteger getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Models.Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", sexo=" + sexo +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                ", status=" + status +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

}
