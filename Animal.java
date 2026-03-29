public class Animal {
    private final int id;
    private TipoAnimal tipo; // Enum
    private float altura;
    private float comprimento;
    private float largura;
    private float peso;
    private StatusAnimal status; // Enum
    private float precoVenda;
}
    // Construtor
    public Animal(int id, TipoAnimal tipo, double altura, double comprimento, double largura, double peso) {
        this.id = id;
        this.tipo = tipo;
        this.altura = altura;
        this.comprimento = comprimento;
        this.largura = largura;
        this.peso = peso;
        this.status = StatusAnimal.ATIVO;
        this.precoVenda = 0.0;
    }

    // Getters e Setters
    public void getId(){ // Sem setter do id para não ser alterado
        return this.id;
    }
    
    public void getTipo(){
        return this.tipo;
    }

    public void setTipo(TipoAnimal tipo){
        this.tipo = tipo;
    }

    public void getAltura(){
        return this.altura;
    }

    public void setAltura(float altura){
        this.altura = altura;
    }

    public void getComprimento(){
        return this.comprimento;
    }

    public void setComprimento(float comprimento){
        this.comprimento = comprimento;
    }
    
    public void getLargura(){
        return this.largura;
    }

    public void setLargura(float largura){
        this.largura = largura;
    }
    
    public void getPeso(){
        return this.peso;
    }

    public void setPeso(float peso){
        this.peso = peso;
    }

    public void getStatus(){
        return this.status;
    }

    public void setStatus(StatusAnimal status){
        this.status = status;
    }

    public void getPrecoVenda(){
        return this.precoVenda;
    }

    public void setPrecoVenda(float precoVenda){
        this.precoVenda = precoVenda;
    }