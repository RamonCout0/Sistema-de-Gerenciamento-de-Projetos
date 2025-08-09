import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {
    public TelaCadastro() {
        setTitle("Cadastro de Studio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        // Campos para entrada de dados
        JLabel lblNome = new JLabel("Nome do Studio:");
        JTextField txtNome = new JTextField(20);

        JLabel lblEquipe = new JLabel("Equipe responsável:");
        JTextField txtEquipe = new JTextField(20);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        painel.add(lblNome);
        painel.add(txtNome);
        painel.add(lblEquipe);
        painel.add(txtEquipe);
        painel.add(btnSalvar);
        painel.add(btnCancelar);

        add(painel);

        // Lógica para salvar os dados
        btnSalvar.addActionListener((ActionEvent e) -> {
            String nome = txtNome.getText();
            String equipe = txtEquipe.getText();

            if (nome.isEmpty() || equipe.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                Studio novoStudio = new Studio(nome, equipe);
                Main.adicionarStudio(novoStudio); // Método estático para adicionar Studio
                JOptionPane.showMessageDialog(this, "Studio cadastrado com sucesso!");
                dispose(); // Fecha a janela de cadastro
            }
        });

        // Lógica para cancelar
        btnCancelar.addActionListener((ActionEvent e) -> dispose());

        setVisible(true);
    }
}