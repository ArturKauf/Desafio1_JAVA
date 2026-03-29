public class Animal {
    private final int id;
    private TipoAnimal tipo;
    private float altura;
    private float comprimento;
    private float largura;
    private float peso;
    private StatusAnimal status;
    private float precoVenda;

    public Animal(int id, TipoAnimal tipo, float altura, float comprimento, float largura, float peso) {
        this.id = id;
        this.tipo = tipo;
        this.altura = altura;
        this.comprimento = comprimento;
        this.largura = largura;
        this.peso = peso;
        this.status = StatusAnimal.ATIVO;
        this.precoVenda = 0.0f;
    }

    public int getId() {
        return this.id;
    }

    public TipoAnimal getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getComprimento() {
        return this.comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return this.largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public StatusAnimal getStatus() {
        return this.status;
    }

    public void setStatus(StatusAnimal status) {
        this.status = status;
    }

    public float getPrecoVenda() {
        return this.precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }
}
