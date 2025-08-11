import java.awt.*;
import java.util.List;
import javax.swing.*;

public class TelaVerProjetos extends JFrame {

    public TelaVerProjetos() { // Construtor sem parâmetro
        
        setTitle("Projetos do Studio");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new BorderLayout());
        JTextArea areaProjetos = new JTextArea();
        areaProjetos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaProjetos);
        painel.add(scrollPane, BorderLayout.CENTER);

        // Pega a instância única do Gerenciamento
        Gerenciamento gerenciador = Gerenciamento.getInstance();       
        // Preenche o JTextArea com a lista de jogos
        List<Jogo> listaJogos = gerenciador.getJogos();
        if (listaJogos.isEmpty()) {
            areaProjetos.setText("Nenhum projeto cadastrado ainda.");
        } else {
            for (Jogo jogo : listaJogos) {
                areaProjetos.append(jogo.toString() + "\n");
            }
        }

        add(painel);
        setVisible(true);
    }
}