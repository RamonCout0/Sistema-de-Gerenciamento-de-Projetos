package scr.Controles
package scr.Modelos;

pulic void  exibirRelatorioUsuario(Usuario[] usuarios) {
    StringBuilder relatorio = new StringBuilder();
    relatorio.append("Relatório de Usuários:\n");
    
    for (Usuario usuario : usuarios) {
        relatorio.append("Nome: ").append(usuario.getNome()).append("\n");
        relatorio.append("Email: ").append(usuario.getEmail()).append("\n");
        if (usuario.getStudio() != null) {
            relatorio.append("Studio: ").append(usuario.getStudio().getNome()).append("\n");
        } else {
            relatorio.append("Studio: Nenhum\n");
        }
        relatorio.append("-------------------------\n");
    }
    
    System.out.println(relatorio.toString());
}

public void RelatoJogo(Jogo[] jogos){
    System.out.println("=========Relatório de Jogos:======");
    for(Jogo j : jogos) 
}