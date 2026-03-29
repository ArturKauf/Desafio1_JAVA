import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Animal[] animais = new Animal[100];
    private static int quantidadeAnimais = 0;

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
        if (quantidadeAnimais >= animais.length) {
            System.out.println("Limite de animais cadastrados atingido.");
            return;
        }

        System.out.println("\n=== INCLUIR ANIMAL ===");

        int id = lerInteiro("Informe o id do animal: ");
        TipoAnimal tipo = lerTipoAnimal();
        float altura = lerFloat("Informe a altura do animal: ");
        float comprimento = lerFloat("Informe o comprimento do animal: ");
        float largura = lerFloat("Informe a largura do animal: ");
        float peso = lerFloat("Informe o peso do animal: ");

        Animal animal = new Animal(id, tipo, altura, comprimento, largura, peso);
        animais[quantidadeAnimais] = animal;
        quantidadeAnimais++;

        System.out.println("Animal cadastrado com sucesso.");
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

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Valor invalido. Digite um numero inteiro.");
            scanner.nextLine();
        }
    }

    private static float lerFloat(String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextFloat()) {
                float valor = scanner.nextFloat();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Valor invalido. Digite um numero.");
            scanner.nextLine();
        }
    }

    private static TipoAnimal lerTipoAnimal() {
        while (true) {
            System.out.println("Escolha o tipo do animal:");
            System.out.println("1 - BOVINO");
            System.out.println("2 - SUINO");
            System.out.println("3 - EQUINO");
            System.out.print("Digite a opcao: ");

            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        return TipoAnimal.BOVINO;
                    case 2:
                        return TipoAnimal.SUINO;
                    case 3:
                        return TipoAnimal.EQUINO;
                    default:
                        System.out.println("Opcao invalida.");
                }
            } else {
                System.out.println("Opcao invalida. Digite um numero inteiro.");
                scanner.nextLine();
            }
        }
    }
}
