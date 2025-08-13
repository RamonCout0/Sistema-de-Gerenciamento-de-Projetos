import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Studio> estudiosExistentes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        Usuario usuarioPadrao = new Usuario("Admin", "admin@studio.com", "senha123");
        Studio studioPadrao = new Studio("Studio dos Criadores", "Equipe A");
        studioPadrao.adicionarMembro(usuarioPadrao);
        studioPadrao.adicionarProjeto(new Projeto("Jogo Exemplo", "Equipe A", "2025-12-31", "Em andamento"));
        estudiosExistentes.add(studioPadrao);

        System.out.println("Bem-vindo(a) ao sistema de gerenciamento de Studio de Jogos!");

        while (usuarioLogado == null) {
            exibirMenuInicial();
        }

        exibirMenuStudio();
    }

    public static void exibirMenuInicial() {
        System.out.println("\nVocê deseja:");
        System.out.println("1. Criar um novo Studio");
        System.out.println("2. Entrar em um Studio existente");
        System.out.println("3. Sair do Sistema");
        System.out.print("Digite sua escolha: ");

        String escolha = scanner.nextLine();

        if (escolha.equals("1")) {
            criarStudio();
        } else if (escolha.equals("2")) {
            entrarStudio();
        } else if (escolha.equals("3")){
            System.out.println("~~ Saindo ~~");
            System.exit(0);
        }
         else {
            System.out.println("Opção inválida. Tente novamente."); // Validação de dados
        }
    }

    public static void criarStudio() {
        System.out.println("\n--- Criar novo Studio ---");
        System.out.print("Nome do Studio: ");
        String nomeStudio = scanner.nextLine();
        System.out.print("Equipe Responsável: ");
        String equipe = scanner.nextLine();
        System.out.print("Seu nome: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Seu email: ");
        String emailUsuario = scanner.nextLine();
        System.out.print("Sua senha: ");
        String senhaUsuario = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nomeUsuario, emailUsuario, senhaUsuario);
        Studio novoStudio = new Studio(nomeStudio, equipe);
        novoStudio.adicionarMembro(novoUsuario);
        estudiosExistentes.add(novoStudio);

        System.out.println("Studio e usuário criados com sucesso!");
        usuarioLogado = novoUsuario;
    }

    public static void entrarStudio() {
        if (estudiosExistentes.isEmpty()) {
            System.out.println("\nNão há studios cadastrados. Por favor, crie um primeiro.");
            return;
        }

        System.out.println("\n--- Entrar em Studio existente ---");
        System.out.println("Studios disponíveis:");
        for (int i = 0; i < estudiosExistentes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiosExistentes.get(i).getNome());
        }
        System.out.print("Escolha o número do Studio: ");

        try {
            int escolha = Integer.parseInt(scanner.nextLine());
            Studio studioEscolhido = estudiosExistentes.get(escolha - 1);

            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            for (Usuario membro : studioEscolhido.getMembros()) {
                if (membro.getEmail().equals(email) && membro.getSenha().equals(senha)) {
                    System.out.println("Login bem-sucedido! Bem-vindo(a), " + membro.getNome() + "!");
                    usuarioLogado = membro;
                    return;
                }
            }
            System.out.println("Email ou senha incorretos.");

        } catch (Exception e) {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public static void exibirMenuStudio() {
        while (true) {
            System.out.println("\n--- Menu Principal do Studio ---");
            System.out.println("Bem-vindo(a), " + usuarioLogado.getNome() + "!");
            System.out.println("Você está no Studio: " + usuarioLogado.getStudio().getNome());
            System.out.println("1. Listar Jogos");
            System.out.println("2. Criar Jogo");
            System.out.println("3. Ver detalhes de um Jogo");
            System.out.println("4. Gerar relatório de Jogos em Andamento");
            System.out.println("5. Sair do Sistema");
            System.out.print("Escolha: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    usuarioLogado.getStudio().listarProjetos();
                    break;
                case "2":
                    criarProjeto();
                    break;
                case "3":
                    verProjeto();
                    break;
                case "4":
                    usuarioLogado.getStudio().relatorioEmAndamento();
                    break;
                case "5":
                    System.out.println("~~ Saindo ~~");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void criarProjeto() {
        System.out.print("Nome do projeto: ");
        String nome = scanner.nextLine();
        System.out.print("Equipe responsável: ");
        String equipe = scanner.nextLine();
        System.out.print("Prazo (DD-MM-AAAA): ");
        String prazo = scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();

        Projeto novoProjeto = new Projeto(nome, equipe, prazo, status);
        usuarioLogado.getStudio().adicionarProjeto(novoProjeto);
        System.out.println("Projeto criado com sucesso!");
    }

    public static void verProjeto() {
        Studio studio = usuarioLogado.getStudio();
        studio.listarProjetos();
        System.out.print("Escolha o número do Jogo para ver detalhes: ");
        try {
            int escolha = Integer.parseInt(scanner.nextLine());
            Projeto projeto = studio.getProjetos().get(escolha - 1);
            System.out.println(projeto);
            System.out.println("1. Editar");
            System.out.println("2. Excluir");
            System.out.println("3. Voltar");
            String opcao = scanner.nextLine();
            if (opcao.equals("1")) {
                System.out.print("Novo nome: ");
                projeto.setNome(scanner.nextLine());
                System.out.print("Nova equipe: ");
                projeto.setEquipeResponsavel(scanner.nextLine());
                System.out.print("Novo prazo: ");
                projeto.setPrazo(scanner.nextLine());
                System.out.print("Novo status: ");
                projeto.setStatus(scanner.nextLine());
                System.out.println("Jogo atualizado!");
            } else if (opcao.equals("2")) {
                studio.removerProjeto(projeto);
                System.out.println("Jogo removido.");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida.");
        }
    }
}
