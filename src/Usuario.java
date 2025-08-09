public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Studio studio;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.studio = null;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public Studio getStudio() { return studio; }
    public void setStudio(Studio studio) { this.studio = studio; }
}