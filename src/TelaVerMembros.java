import java.awt.*;
import java.util.List;
import javax.swing.*;

public class TelaVerMembros extends JFrame {
    private Studio estudioAtual;

    public TelaVerMembros(Studio estudio) {
        this.estudioAtual = estudio;
        
        setTitle("Membros do Studio - " + estudio.getNome());
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new BorderLayout());
        
        // Pega a lista de membros do objeto Studio
        List<Usuario> membros = estudioAtual.getMembros();
        
        // Cria um modelo para o JList e adiciona os nomes dos membros
        DefaultListModel<String> listaModelo = new DefaultListModel<>();
        if (membros.isEmpty()) {
            listaModelo.addElement("Nenhum membro cadastrado ainda.");
        } else {
            for (Usuario usuario : membros) {
                listaModelo.addElement(usuario.getNome());
            }
        }
        
        JList<String> listaMembros = new JList<>(listaModelo);
        listaMembros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(listaMembros);
        painel.add(scrollPane, BorderLayout.CENTER);
        
        add(painel);
        setVisible(true);
    }
}