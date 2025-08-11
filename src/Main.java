import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {
    private static final List<Studio> studiosExistentes = new ArrayList<>();    
    public static void main(String[] args) {
            System.out.println("Programa iniciado.");

            // Criando objetos de Studio
            Studio studio1 = new Studio("Cronologia Astral");
            Gerenciamento gerenciador = new Gerenciamento();
            SwingUtilities.invokeLater(() -> new TelaInicial());
            System.out.println("teste");
        }
        
    public static void adicionarStudio(Studio studio) {
        studiosExistentes.add(studio);
        System.out.println("Studio adicionado: " + studio.getNome());     
    }
    
    public static List<Studio> getStudiosExistentes() {
        return studiosExistentes;
    }
}
class TelaInicial extends JFrame {
    
    public TelaInicial() {
        setTitle("Gerenciamento de Studio de Jogos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        JPanel painel = new JPanel();

        JButton btnCriarStudio = new JButton("Cadastrar um novo Studio");
        JButton btnEntrarStudio = new JButton("Entrar em um Studio existente");

        painel.add(btnCriarStudio);
        painel.add(btnEntrarStudio);

        add(painel);
        
        // Lógica para os botões (uma única vez)
        btnCriarStudio.addActionListener(e -> {
            TelaCadastro telaCadastro = new TelaCadastro();
            telaCadastro.setVisible(true); 
        });

        btnEntrarStudio.addActionListener(e -> {
            // Apenas cria e abre a nova tela, sem a mensagem de JOptionPane
            TelaLoginEstudio telaLogin = new TelaLoginEstudio();
        });

        setVisible(true);
    }
}