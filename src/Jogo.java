import java.time.LocalDate;

public class Jogo {
    private String nome;
    private String status; // Em desenvolvimento, Concluído, Cancelado
    private LocalDate prazoInicio;
    private LocalDate prazoFim;
    private String equipeResponsavel;

    public Jogo(String nome, LocalDate prazoInicio, LocalDate prazoFim, String equipeResponsavel, String em_desenvolvimento) {
        this.nome = nome;
        this.status = "Em desenvolvimento";
        this.prazoInicio = prazoInicio;
        this.prazoFim = prazoFim;
        this.equipeResponsavel = equipeResponsavel;
    }

    Jogo(String estefania_do_Norte, LocalDate of, LocalDate of0, String nome, String em_desenvolvimento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getPrazoInicio() { return prazoInicio; }
    public void setPrazoInicio(LocalDate prazoInicio) { this.prazoInicio = prazoInicio; }

    public LocalDate getPrazoFim() { return prazoFim; }
    public void setPrazoFim(LocalDate prazoFim) { this.prazoFim = prazoFim; }

    public String getEquipeResponsavel() { return equipeResponsavel; }
    public void setEquipeResponsavel(String equipeResponsavel) { this.equipeResponsavel = equipeResponsavel; }

    @Override
    public String toString() {
        return "Jogo: " + nome + " | Status: " + status + " | Início: " + prazoInicio + " | Fim: " + prazoFim + " | Equipe: " + equipeResponsavel;
    }
}
