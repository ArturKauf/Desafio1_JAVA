import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();
            executarOpcao(opcao);
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU DE ANIMAIS ===");
        System.out.println("1 - Incluir animal");
        System.out.println("2 - Consultar animal");
        System.out.println("3 - Avaliar animal");
        System.out.println("4 - Registrar venda");
        System.out.println("5 - Registrar perda");
        System.out.println("6 - Relatorio animais por tipo");
        System.out.println("7 - Relatorio vendas");
        System.out.println("8 - Relatorio perdas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static int lerOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.print("Opcao invalida. Digite um numero: ");
            scanner.nextLine();
        }

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                incluirAnimal();
                break;
            case 2:
                consultarAnimal();
                break;
            case 3:
                avaliarAnimal();
                break;
            case 4:
                registrarVenda();
                break;
            case 5:
                registrarPerda();
                break;
            case 6:
                relatorioAnimaisPorTipo();
                break;
            case 7:
                relatorioVendas();
                break;
            case 8:
                relatorioPerdas();
                break;
            case 0:
                System.out.println("Encerrando o sistema...");
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    private static void incluirAnimal() {
        System.out.println("Opcao selecionada: Incluir animal");
    }

    private static void consultarAnimal() {
        System.out.println("Opcao selecionada: Consultar animal");
    }

    private static void avaliarAnimal() {
        System.out.println("Opcao selecionada: Avaliar animal");
    }

    private static void registrarVenda() {
        System.out.println("Opcao selecionada: Registrar venda");
    }

    private static void registrarPerda() {
        System.out.println("Opcao selecionada: Registrar perda");
    }

    private static void relatorioAnimaisPorTipo() {
        System.out.println("Opcao selecionada: Relatorio animais por tipo");
    }

    private static void relatorioVendas() {
        System.out.println("Opcao selecionada: Relatorio vendas");
    }

    private static void relatorioPerdas() {
        System.out.println("Opcao selecionada: Relatorio perdas");
    }
}
