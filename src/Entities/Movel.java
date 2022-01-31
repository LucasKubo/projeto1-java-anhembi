package Entities;

public class Movel extends Produto{

    private String tipoDeMaterial;


    public Movel(int codigo, String nome, String fabricante, int quantidade, double valorUnitario, String tipoDeMaterial) {
        super(codigo, nome, fabricante, quantidade, valorUnitario);
        this.tipoDeMaterial = tipoDeMaterial;
    }

    public String getTipoDeMaterial(){
        return tipoDeMaterial;
    }

    public void setTipoDeMaterial(String tipoDeMaterial){
        this.tipoDeMaterial = tipoDeMaterial;
    }

    @Override
    public String imprimir() {
        return "Movel{" +
                "codigo=" + getCodigo() +
                ", nome='" + getNome() + '\'' +
                ", fabricante='" + getFabricante() + '\'' +
                ", quantidade=" + getQuantidade()+
                ", valorUnitario=" + getValorUnitario() +
                ", tipoDeMaterial=" + tipoDeMaterial +
                '}';
    }
}
