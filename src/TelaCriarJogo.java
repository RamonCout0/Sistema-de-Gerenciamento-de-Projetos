import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.*;

public class TelaCriarJogo extends JFrame {
    private Studio estudioAtual;

    private JTextField txtNome, txtEquipe, txtPrazoInicio, txtPrazoFim;
    private JComboBox<String> comboStatus;
    private Gerenciamento gerenciador = Gerenciamento.getInstance();

    public TelaCriarJogo(Studio estudio) {
        this.estudioAtual = estudio;

        setTitle("Criar novo Projeto");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Campos de entrada
        add(new JLabel("Nome do Projeto:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Equipe Responsável:"));
        txtEquipe = new JTextField();
        add(txtEquipe);

        add(new JLabel("Status:"));
        comboStatus = new JComboBox<>(new String[]{"Em desenvolvimento", "Concluído", "Cancelado"});
        add(comboStatus);
        
        add(new JLabel("Prazo de Início (AAAA-MM-DD):"));
        txtPrazoInicio = new JTextField();
        add(txtPrazoInicio);

        add(new JLabel("Prazo de Fim (AAAA-MM-DD):"));
        txtPrazoFim = new JTextField();
        add(txtPrazoFim);

        JButton btnSalvar = new JButton("Salvar Projeto");
        add(btnSalvar);
        
        JButton btnCancelar = new JButton("Cancelar");
        add(btnCancelar);

        // Lógica do botão Salvar
        btnSalvar.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                String equipe = txtEquipe.getText();
                String status = (String) comboStatus.getSelectedItem();
                LocalDate prazoInicio = LocalDate.parse(txtPrazoInicio.getText());
                LocalDate prazoFim = LocalDate.parse(txtPrazoFim.getText());

                if (nome.isEmpty() || equipe.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nome e Equipe são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Cria o objeto Jogo e adiciona ao gerenciador
                Jogo novoJogo = new Jogo(nome, status, prazoInicio, prazoFim, equipe);
                gerenciador.adicionarJogo(novoJogo);

                JOptionPane.showMessageDialog(this, "Projeto '" + nome + "' criado com sucesso!");
                dispose(); // Fecha a janela após salvar
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Formato de data inválido. Use AAAA-MM-DD.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Lógica do botão Cancelar
        btnCancelar.addActionListener(e -> dispose());
        
        setVisible(true);
    }
}