import java.time.LocalDate; // Adicione esta linha
import java.util.ArrayList;
import java.util.List;

public class Gerenciamento {
    private static Gerenciamento instancia; 
    private final List<Jogo> jogos = new ArrayList<>();

    // Construtor privado para evitar que outras classes criem instâncias
    private Gerenciamento() {} 

    // Método estático para obter a única instância da classe
    public static Gerenciamento getInstance() { 
        if (instancia == null) {
            instancia = new Gerenciamento();
        }
        return instancia;
    }

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public List<Jogo> listarJogos() {
        return jogos;
    }

    public Jogo buscarJogo(String nome) {
        for (Jogo j : jogos) {
            if (j.getNome().equalsIgnoreCase(nome)) {
                return j;
            }
        }
        return null;
    }

    public boolean excluirJogo(String nome) {
        return jogos.removeIf(j -> j.getNome().equalsIgnoreCase(nome));
    }

    public boolean alterarStatus(String nome, String novoStatus) {
        Jogo jogo = buscarJogo(nome);
        if (jogo != null) {
            jogo.setStatus(novoStatus);
            return true;
        }
        return false;
    }

    public boolean alterarPrazos(String nome, LocalDate novoInicio, LocalDate novoFim) {
        Jogo jogo = buscarJogo(nome);
        if (jogo != null) {
            jogo.setPrazoInicio(novoInicio);
            jogo.setPrazoFim(novoFim);
            return true;
        }
        return false;
    }

    public boolean alterarEquipe(String nome, String novaEquipe) {
        Jogo jogo = buscarJogo(nome);
        if (jogo != null) {
            jogo.setEquipeResponsavel(novaEquipe);
            return true;
        }
        return false;
    }
    
    public List<Jogo> getJogos() {
        return jogos;
    }
}