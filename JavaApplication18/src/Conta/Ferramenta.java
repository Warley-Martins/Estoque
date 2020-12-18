package Conta;
public class Ferramenta {
    private String descricao;
    private double preco;
    public Ferramenta(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}



