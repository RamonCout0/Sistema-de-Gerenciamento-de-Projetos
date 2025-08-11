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
        // No ActionListener do botão "Entrar" em TelaLoginEstudio
        btnEntrar.addActionListener(e -> {
            String nomeStudioSelecionado = (String) comboStudios.getSelectedItem();

            // Encontra o objeto Studio correspondente
            Studio estudioSelecionado = Main.encontrarStudioPorNome(nomeStudioSelecionado);
            
            if (estudioSelecionado != null) {
                // Cria a tela principal do estúdio, que já se torna visível no construtor
                new TelaPrincipalStudio(estudioSelecionado); 
                
                // Fecha a tela de login apenas após a tela principal ter sido criada
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao encontrar o Studio.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}