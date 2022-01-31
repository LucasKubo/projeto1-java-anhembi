package Entities;

public class Eletronico extends Produto{
    private String voltagem;
    private double potencia;
    private String classEficiencia;

    public Eletronico(int codigo, String nome, String fabricante, int quantidade, double valorUnitario, String voltagem, double potencia, String classEficiencia){
        super(codigo, nome, fabricante, quantidade, valorUnitario);
        this.voltagem = voltagem;
        this.potencia = potencia;
        this.classEficiencia = classEficiencia;
    }




    @Override
    public String imprimir() {
        return "Eletronico{" +
                "codigo=" + getCodigo() +
                ", nome='" + getNome() + '\'' +
                ", fabricante='" + getFabricante() + '\'' +
                ", quantidade=" + getQuantidade()+
                ", valorUnitario=" + getValorUnitario() +
                ", voltagem='" + voltagem + '\'' +
                ", potencia=" + potencia +
                ", classEficiencia='" + classEficiencia + '\'' +
                '}';
    }
}
