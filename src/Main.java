import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static List<Studio> studiosExistentes = new ArrayList<>();
    
    public static void main(String[] args) {
        // SwingUtilities.invokeLater -> interface criada
        SwingUtilities.invokeLater(() -> new TelaInicial());
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
        
        // Adicionando a lógica para os botões
        btnCriarStudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //chama a tela de cadastro e tela de criação de studio
                JOptionPane.showMessageDialog(TelaInicial.this, "Cadastrar Studio clicado!");
                // Por enquanto, vamos manter a lógica no console para simplificar
                // Mais tarde, podemos abrir uma nova janela de cadastro
            }
        });
        
        btnEntrarStudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui vamos chamar a lógica para entrar em um studio
                JOptionPane.showMessageDialog(TelaInicial.this, "Entrar em Studio clicado!");
            }
        });

        setVisible(true);
    }
}