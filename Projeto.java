public class Projeto {
    private String nome;
    private String equipeResponsavel;
    private String prazo;
    private String status;

    public Projeto(String nome, String equipeResponsavel, String prazo, String status) {
        this.nome = nome;
        this.equipeResponsavel = equipeResponsavel;
        this.prazo = prazo;
        this.status = status;
    }

    public String getNome() { return nome; }
    public String getEquipeResponsavel() { return equipeResponsavel; }
    public String getPrazo() { return prazo; }
    public String getStatus() { return status; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEquipeResponsavel(String equipeResponsavel) { this.equipeResponsavel = equipeResponsavel; }
    public void setPrazo(String prazo) { this.prazo = prazo; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Projeto: " + nome +
                "\nEquipe: " + equipeResponsavel +
                "\nPrazo: " + prazo +
                "\nStatus: " + status;
    }
}
