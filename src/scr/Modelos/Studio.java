package scr.Modelos;
import java.util.ArrayList;
import java.util.List;

public class Studio {
    private String nome;
    private List<Usuario> membros; 

    public Studio(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public List<Usuario> getMembros() { return membros; }
    
    public void adicionarMembro(Usuario usuario) {
        this.membros.add(usuario);
        usuario.setStudio(this);
    }
}