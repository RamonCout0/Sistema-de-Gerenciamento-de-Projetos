import java.awt.*;
import javax.swing.*;

public class TelaCadastro extends JFrame {

    // Declare todos os JTextFields aqui como campos da classe
    private JTextField txtNomeStudio;
    private JTextField txtEquipeResponsavel;
    private JTextField txtNomeUsuario;
    private JTextField txtEmailUsuario;
    private JTextField txtSenhaUsuario;

    public TelaCadastro() {
        setTitle("Cadastro de Studio e Usuário");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        // Campos do Studio
        painel.add(new JLabel("Dados do Studio:"));
        painel.add(new JLabel("Nome do Studio:"));
        txtNomeStudio = new JTextField(20); // Inicialize aqui, sem a palavra 'private'
        painel.add(txtNomeStudio);

        painel.add(new JLabel("Equipe Responsável:"));
        txtEquipeResponsavel = new JTextField(20);
        painel.add(txtEquipeResponsavel);
        
        painel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Campos do Usuário
        painel.add(new JLabel("Dados do Usuário (Fundador):"));
        painel.add(new JLabel("Nome do Usuário:"));
        txtNomeUsuario = new JTextField(20);
        painel.add(txtNomeUsuario);
        
        painel.add(new JLabel("Email do Usuário:"));
        txtEmailUsuario = new JTextField(20);
        painel.add(txtEmailUsuario);
        
        painel.add(new JLabel("Senha do Usuário:"));
        txtSenhaUsuario = new JTextField(20);
        painel.add(txtSenhaUsuario);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        painel.add(btnSalvar);
        painel.add(btnCancelar);

        add(painel);
        
        // A lógica do ActionListener agora consegue ver as variáveis
        btnSalvar.addActionListener(e -> {
            String nomeStudio = txtNomeStudio.getText();
            String equipe = txtEquipeResponsavel.getText();
            String nomeUsuario = txtNomeUsuario.getText();
            String emailUsuario = txtEmailUsuario.getText();
            String senhaUsuario = txtSenhaUsuario.getText();
            // ... restante da lógica
        });

        btnCancelar.addActionListener(e -> dispose());
        setVisible(true);
    }
}