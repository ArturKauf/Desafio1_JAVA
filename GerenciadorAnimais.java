public class GerenciadorAnimais {
    private Animal[] animais;
    private int quantidadeAnimais;

    public GerenciadorAnimais(int capacidade){
        this.animais = new Animal[capacidade];
        this.quantidadeAnimais = 0;
    }

    // Adiciona um animal, e se conseguir retorna true
    public boolean adicionar(Animal animal){
        if(quantidadeAnimais < animais.length){
            animais[quantidadeAnimais] = animal;
            quantidadeAnimais++;
            return true;
        }
        return false;
    }

    // Função para buscar um animal pelo ID, é util para as opção 2, 3, 4 e 5 do Menu
    public Animal buscarPorId(int id){
        for(int i = 0; i < quantidadeAnimais; i++){
            if(animais[i].getId() == id){
                return animais[i];
            }
        }
        return null;
    }

    // Retorna todos os animais
    public Animal[] getTodos(){
        Animal[] preenchidos = new Animal[quantidadeAnimais];
        System.arraycopy(animais, 0, preenchidos, 0, quantidadeAnimais);
        return preenchidos;
    }
}
