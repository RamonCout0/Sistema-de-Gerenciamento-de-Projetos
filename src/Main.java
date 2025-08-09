import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {
    private static final List<Studio> studiosExistentes = new ArrayList<>();    
    public static void main(String[] args) {
            System.out.println("Programa iniciado.");

            // Criando objetos de Studio
            Studio studio1 = new Studio("Cronologia Astral");

            // Criando um objeto de Jogo, usando o nome de um dos studios criados
            // Corrigindo o erro em Studio.getNome()
          // Em Main.java, corrija a linha 16 para passar apenas 4 argumentos
Jogo jogo1 = new Jogo("Estefania do Norte",
                     LocalDate.of(2025, 8, 9),
                     LocalDate.of(2025, 9, 5),
                     "Em desenvolvimento"); // Removi studio1.getNome()
            // Criando uma instância de Gerenciamento para poder usar seus métodos
            // Corrigindo o erro em Gerenciamento.adicionarJogo()
            Gerenciamento gerenciador = new Gerenciamento();
            gerenciador.adicionarJogo(jogo1);

            SwingUtilities.invokeLater(() -> new TelaInicial());
            System.out.println("teste");
        }
        
    public static void adicionarStudio(Studio studio) {
        studiosExistentes.add(studio);
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
            new TelaCadastro(); 
            // Você pode adicionar um JOptionPane de confirmação aqui se quiser
        });
        
        btnEntrarStudio.addActionListener(e -> {
            JOptionPane.showMessageDialog(TelaInicial.this, "Entrar em Studio!");
            // tela para o login
        });

        setVisible(true);
    }
}