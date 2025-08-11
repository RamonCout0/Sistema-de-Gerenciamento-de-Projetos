import javax.swing.*;

public class TelaLoginEstudio extends JFrame {

    public TelaLoginEstudio() {
        setTitle("Entrar em um Studio");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Verifica se há estúdios para exibir
        if (Main.getStudiosExistentes().isEmpty()) { // CHAMADA CORRIGIDA
            JOptionPane.showMessageDialog(this, "Não há studios cadastrados. Crie um primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        JPanel painel = new JPanel();
        
        JLabel lblEscolha = new JLabel("Escolha um Studio:");
        
        // Componente para a lista suspensa
        JComboBox<String> comboStudios = new JComboBox<>();

        // Adiciona os nomes dos estúdios à ComboBox
        for (Studio estudio : Main.getStudiosExistentes()) { // CHAMADA CORRIGIDA
            comboStudios.addItem(estudio.getNome());
        }

        JButton btnEntrar = new JButton("Entrar");

        painel.add(lblEscolha);
        painel.add(comboStudios);
        painel.add(btnEntrar);

        add(painel);

        // Lógica para o botão "Entrar"
        btnEntrar.addActionListener(e -> {
            String nomeStudioSelecionado = (String) comboStudios.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Você entrou no Studio: " + nomeStudioSelecionado);
            dispose();
            // Futuramente, você abrirá a tela principal do Studio aqui
        });

        setVisible(true);
    }
}