import java.util.ArrayList;
import java.util.List;

public class Studio {
    private String nome;
    private String equipeResponsavel; // Novo campo
    private List<Usuario> membros;

    // Construtor principal, agora aceita dois argumentos
    public Studio(String nome, String equipeResponsavel) {
        this.nome = nome;
        this.equipeResponsavel = equipeResponsavel;
        this.membros = new ArrayList<>();
    }
    
    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEquipeResponsavel() { return equipeResponsavel; }
    public void setEquipeResponsavel(String equipeResponsavel) { this.equipeResponsavel = equipeResponsavel; }
    
    public List<Usuario> getMembros() { return membros; }
    
    public void adicionarMembro(Usuario usuario) {
        this.membros.add(usuario);
        usuario.setStudio(this);
    }
}