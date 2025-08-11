import java.awt.*;
import javax.swing.*;

public class TelaPrincipalStudio extends JFrame {
    private Studio estudioAtual;

    public TelaPrincipalStudio(Studio estudio) {
        this.estudioAtual = estudio;

        setTitle("Painel de Controle - " + estudio.getNome());
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal usando BorderLayout
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Cabeçalho
        JLabel lblTitulo = new JLabel("Bem-vindo(a) ao " + estudio.getNome(), JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        painelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Painel de botões central
        JPanel painelBotoes = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton btnCriarProjeto = new JButton("Criar novo Projeto");
        JButton btnVerProjetos = new JButton("Ver Projetos");
        JButton btnVerMembros = new JButton("Ver Membros");

        painelBotoes.add(btnCriarProjeto);
        painelBotoes.add(btnVerProjetos);
        painelBotoes.add(btnVerMembros);

        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        // Lógica dos botões
        btnCriarProjeto.addActionListener(e -> {
            TelaCriarJogo telaCriarJogo = new TelaCriarJogo(estudioAtual);
        });

        btnVerProjetos.addActionListener(e -> {
            //Gerenciamento gerenciador = Gerenciamento.getInstance();
            new TelaVerProjetos();
        });

        btnVerMembros.addActionListener(e -> {
            new TelaVerMembros(estudioAtual);
        });

        add(painelPrincipal);
        setVisible(true);
    }
}