public class Avaliacao {

    private float nota;
    private String descricao;

    public Avaliacao(float nota, String descricao) {
        this.nota = nota;
        this.descricao = descricao;
    }

    public Avaliacao(float nota) {
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "nota=" + nota +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
