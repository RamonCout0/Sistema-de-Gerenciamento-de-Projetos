import java.util.ArrayList;
import java.util.List;

public class Studio {
    private String nome;
    private String equipeResponsavel;
    private final List<Usuario> membros;
    private final List<Projeto> projetos;

    public Studio(String nome, String equipeResponsavel) {
        this.nome = nome;
        this.equipeResponsavel = equipeResponsavel;
        this.membros = new ArrayList<>();
        this.projetos = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public String getEquipeResponsavel() { return equipeResponsavel; }
    public List<Usuario> getMembros() { return membros; }
    public List<Projeto> getProjetos() { return projetos; }

    public void adicionarMembro(Usuario usuario) {
        this.membros.add(usuario);
        usuario.setStudio(this);
    }

    public void adicionarProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public void removerProjeto(Projeto projeto) {
        this.projetos.remove(projeto);
    }

    public void listarProjetos() {
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.");
            return;
        }
        for (int i = 0; i < projetos.size(); i++) {
            System.out.println((i + 1) + ". " + projetos.get(i).getNome() + " (" + projetos.get(i).getStatus() + ")");
        }
    }

    public void relatorioEmAndamento() {
        System.out.println("--- Relatório: Projetos em andamento ---");
        for (Projeto p : projetos) {
            if (p.getStatus().equalsIgnoreCase("Em andamento")) {
                System.out.println(p);
            }
        }
    }
}
