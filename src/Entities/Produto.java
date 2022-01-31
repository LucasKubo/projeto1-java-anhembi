package Entities;

public abstract class Produto {
    private int codigo;
    private String nome;
    private String fabricante;
    private int quantidade;
    private double valorUnitario;

    public Produto(int codigo, String nome, String fabricante, int quantidade, double valorUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double vender(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
            return quantidade * valorUnitario;
        }
        return -1;
    }

    public void comprar(int quantidade) {
        this.quantidade += quantidade;
    }

    public String imprimir() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                '}';
    }

}
