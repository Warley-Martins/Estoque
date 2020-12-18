package Conta;
public class Registro {
    private static int quantidadeRegistros = 0;
    private int id;
    private Ferramenta ferramenta;
    private int quantidadeFerramentas;
    public Registro(Ferramenta ferramenta, int quantidadeFerramentas) {
        quantidadeRegistros++;
        this.id = quantidadeRegistros;
        this.ferramenta = ferramenta;
        this.quantidadeFerramentas = quantidadeFerramentas;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Ferramenta getFerramenta() {
        return ferramenta;
    }
    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }
    public int getQuantidadeFerramentas() {
        return quantidadeFerramentas;
    }
    public void setQuantidadeFerramentas(int quantidadeFerramentas) {
        this.quantidadeFerramentas = quantidadeFerramentas;
    }
}


