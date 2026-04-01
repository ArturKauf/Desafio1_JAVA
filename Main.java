import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GerenciadorAnimais gerenciador = new GerenciadorAnimais(100);

    public static void main(String[] args) {
        int opcao;

        carregarDadosDeTeste();
        
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

    private static void incluirAnimal(){
        System.out.println("\n=== INCLUIR ANIMAL ===");

        int id;
        while (true) {
            id = lerInteiro("Informe o id do animal: ");
        
            // Verifica se o ID já está cadastrado
            if (gerenciador.buscarPorId(id) == null) {
                break; // Se for null, o ID está livre. Sai do laço.
            } else {
                System.out.println("Erro: ID existente, insira outro.");
            }
        }
        TipoAnimal tipo = lerTipoAnimal();
        float altura = lerFloat("Informe a altura: ");
        float comprimento = lerFloat("Informe o comprimento: ");
        float largura = lerFloat("Informe a largura: ");
        float peso = lerFloat("Informe o peso: ");

        Animal novoAnimal = new Animal(id, tipo, altura, comprimento, largura, peso);

        boolean sucesso = gerenciador.adicionar(novoAnimal);

        if(sucesso){
            System.out.println("Animal cadastrado com sucesso!");
        } else{
            System.out.println("Erro: Limite de armazenamento atingido.");
        }
    }

    private static void consultarAnimal() {
        System.out.println("\n=== CONSULTAR ANIMAL ===");
        int id = lerInteiro("Digite o ID do animal: ");

        Animal animal = gerenciador.buscarPorId(id);

        if(animal != null){
            System.out.println("ID: " + animal.getId());
            System.out.println("Tipo: " + animal.getTipo());
            System.out.println("Status: " + animal.getStatus());
            System.out.println("Peso: " + animal.getPeso() + " kg");
        } else{
            System.out.println("Animal com ID " + id + " não encontrado.");
        }
    }

    private static void avaliarAnimal(){
        System.out.println("\n=== AVALIAR ANIMAL ===");
        int id = lerInteiro("Digite o ID do animal para avaliação: ");

        Animal animal = gerenciador.buscarPorId(id);

        if(animal != null){
            System.out.println("\n--- Ficha Médica/Zootécnica ---");
            System.out.println("Tipo: " + animal.getTipo());
            System.out.println("Peso atual: " + animal.getPeso() + " kg");
            System.out.println("Status: " + animal.getStatus());
            System.out.println("--------------------------------");

            if(animal.getStatus() != StatusAnimal.ATIVO){
                System.out.println("Aviso: A avaliação de peso ideal é feita apenas em animais ATIVOS.");
                return;
            }

            System.out.println("Resultado da Avaliação:");

            switch (animal.getTipo()) {
                case BOVINO:
                    if(animal.getPeso() >= 500.0f){
                        System.out.println("-> Classificação: PRONTO PARA VENDA.");
                    } else{
                        float falta = 500.0f - animal.getPeso();
                        System.out.println("-> Classificação: EM FASE DE ENGORDAR.");
                        System.out.printf("-> Recomendação: faltam %.2f kg para atingir o peso ideal (500kg).\n", falta);
                    }
                    break;
                case SUINO:
                    if(animal.getPeso() >= 100.0f){
                        System.out.println("-> Classificação: PRONTO PARA VENDA");
                    } else{
                        float falta = 100.0f - animal.getPeso();
                        System.out.println("-> Classificação: EM FASE DE ENGORDAR.");
                        System.out.printf("-> Recomendação: faltam %.2f kg para atingir o peso ideal (100kg).\n", falta);
                    }
                    break;
                case EQUINO:
                    System.out.println("-> Classificação: ANIMAL DE TRABALHO / ESPORTE.");
                    System.out.println("-> Recomendação: Manter rotina de cuidados físicos e alimentação balanceada.");
                    break;
            }
        } else{
            System.out.println("Animal não encontrado no sistema.");
        }
    } 

    private static void registrarVenda() {
        System.out.println("\n=== REGISTRAR VENDA ===");
        int id = lerInteiro("Digite o ID do animal vendido: ");

        Animal animal = gerenciador.buscarPorId(id);

        if(animal != null){
            if(animal.getStatus() == StatusAnimal.VENDIDO){
                System.out.println("Erro: Este animal já consta como vendido!");
            } else if(animal.getStatus() == StatusAnimal.PERDIDO){
                System.out.println("Erro: Não é possivel vender um animal registrado como perdido.");
            } else{
                float preco = lerFloat("Informe o valor de venda (R$): ");

                animal.setStatus(StatusAnimal.VENDIDO);
                animal.setPrecoVenda(preco);

                System.out.println("Venda registrada com sucesso!");
            }
        } else{
            System.out.println("Animal não encontrado no sistema.");
        }
    }

    private static void registrarPerda() {
        System.out.println("\n=== REGISTRAR PERDA ===");
        int id = lerInteiro("Digite o ID do animal perdido: ");

        Animal animal = gerenciador.buscarPorId(id);

        if(animal != null){
            if(animal.getStatus() == StatusAnimal.PERDIDO){
                System.out.println("Erro: Este animal já consta como perdido!");
            } else if(animal.getStatus() == StatusAnimal.VENDIDO){
                System.out.println("Erro: Não é possivel registrar perda de um animal já vendido.");
            } else{
                animal.setStatus(StatusAnimal.PERDIDO);
                System.out.println("Perda registrada com sucesso!");
            }
        } else{
            System.out.println("Animal não encontrado no sistema.");
        }
    }

    private static void relatorioAnimaisPorTipo() {
        System.out.println("\n=== RELATÓRIO: ANIMAIS POR TIPO ===");

        TipoAnimal tipoDesejado = lerTipoAnimal();

        Animal[] todos = gerenciador.getTodos();
        boolean encontrou = false;

        System.out.println("\n--------------------------------------");
        System.out.printf("%-5s | %-10s | %-10s | %-10s\n", "ID", "TIPO", "STATUS", "PESO");
        System.out.println("--------------------------------------");

        for(Animal animal : todos){
            if(animal.getTipo() == tipoDesejado){
                System.out.printf("%-5d | %-10s | %-10s | %-5.2f kg\n",
                    animal.getId(),
                    animal.getTipo(),
                    animal.getStatus(),
                    animal.getPeso()
                );
                encontrou = true;
            }
        }
        System.out.println("--------------------------------------");

        if(!encontrou){
            System.out.println("Nenhum animal do tipo " +tipoDesejado + " foi encontrado.");
        }
    }

    private static void relatorioVendas() {
        System.out.println("\n=== RELATÓRIO DE VENDAS ===");

        Animal[] todos = gerenciador.getTodos();
        boolean encontrou = false;
        float totalArrecadado = 0.0f; //variável para somar o dinheiro

        System.out.println("\n--------------------------------------");
        System.out.printf("%-5s | %-10s | %-10s | %-10s | %-15s\n", "ID", "TIPO", "PESO", "STATUS", "PREÇO(R$)");
        System.out.println("--------------------------------------");

        for(Animal animal : todos){
            if(animal.getStatus() == StatusAnimal.VENDIDO){
                System.out.printf("%-5d | %-10s | %-7.2f kg | %-10s | R$ %-10.2f\n",
                    animal.getId(),
                    animal.getTipo(),
                    animal.getPeso(),
                    animal.getStatus(),
                    animal.getPrecoVenda()
                );
                totalArrecadado += animal.getPrecoVenda();
                encontrou = true;
            }
        }
        System.out.println("--------------------------------------");

        if(!encontrou){
            System.out.println("Nenhuma venda registrada até o momento.");
        } else{
            System.out.printf("TOTAL ARRECADADO: R$ %.2f\n", totalArrecadado);
        }
    }

    private static void relatorioPerdas() {
        System.out.println("\n=== RELATÓRIO DE PERDAS ===");

        Animal[] todos = gerenciador.getTodos();
        boolean encontrou = false;

        System.out.println("\n--------------------------------------");
        System.out.printf("%-5s | %-10s | %-10s | %-10s\n", "ID", "TIPO", "PESO", "STATUS");
        System.out.println("--------------------------------------");

        for(Animal animal : todos){
            if(animal.getStatus() == StatusAnimal.PERDIDO){
                System.out.printf("%-5d | %-10s | %-7.2f kg | %-10s\n",
                    animal.getId(),
                    animal.getTipo(),
                    animal.getPeso(),
                    animal.getStatus()
                );
                encontrou = true;
            }
        }
        System.out.println("--------------------------------------");

        if(!encontrou){
            System.out.println("Nenhuma perda registrada até o momento.");
        } 
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

    private static void carregarDadosDeTeste(){
        System.out.println("Carregando dados de teste...");
        
        gerenciador.adicionar(new Animal(1, TipoAnimal.BOVINO, 1.5f, 2.0f, 0.8f, 600.5f));
        gerenciador.adicionar(new Animal(2, TipoAnimal.BOVINO, 1.6f, 2.1f, 0.9f, 650.0f));
        gerenciador.adicionar(new Animal(3, TipoAnimal.SUINO, 0.8f, 1.2f, 0.5f, 110.0f));
        gerenciador.adicionar(new Animal(4, TipoAnimal.EQUINO, 1.7f, 2.3f, 0.7f, 450.0f));
        gerenciador.adicionar(new Animal(5, TipoAnimal.SUINO, 0.7f, 1.1f, 0.6f, 95.5f));
        
        System.out.println("5 animais carregados com sucesso!\n");
    }
}
