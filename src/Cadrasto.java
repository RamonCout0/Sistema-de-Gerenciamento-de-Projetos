//import java.util.ArrayList;
//import java.util.List;

public class Cadrasto {
    private String nome;
    private String email;
    private String senha;
    private Studio studio; // Referência à classe Studio
    
    public void Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.studio = null;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public Studio getStudio() { return studio; }
    public void setStudio(Studio studio) { this.studio = studio; }
}