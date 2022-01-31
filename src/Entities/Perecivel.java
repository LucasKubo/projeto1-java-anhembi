package Entities;

import java.time.LocalDate;

public class Perecivel extends Produto {

    private LocalDate validade;
    private boolean refrigerado;

    public Perecivel(int codigo, String nome, String fabricante, int quantidade, double valorUnitario, LocalDate validade, Boolean refrigerado) {
        super(codigo, nome, fabricante, quantidade, valorUnitario);
        this.validade = validade;
        this.refrigerado = refrigerado;
    }

    public LocalDate getValidade(){
        return validade;
    }

    public void setValidade(LocalDate validade){
        this.validade = validade;
    }

    public boolean getRefrigerado(){
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado){
        this.refrigerado = refrigerado;
    }

    @Override
    public String imprimir() {
        return "Perecivel{" +
                "codigo=" + getCodigo() +
                ", nome='" + getNome() + '\'' +
                ", fabricante='" + getFabricante() + '\'' +
                ", quantidade=" + getQuantidade() +
                ", valorUnitario=" + getValorUnitario() +
                ", validade=" + validade +
                ", refriferado=" + refrigerado +
                '}';
    }
}
