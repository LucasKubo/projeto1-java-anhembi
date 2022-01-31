package Application;

import Entities.Eletronico;
import Entities.GerenciarProdutos;
import Entities.Movel;
import Entities.Perecivel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        GerenciarProdutos gcp = new GerenciarProdutos();
        int opcao;
        do {
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Listar eletrônicos");
            System.out.println("5 - Listar perecíveis");
            System.out.println("6 - Listar móveis");
            System.out.println("7 - Listar por estoque mínimo");
            System.out.println("8 - Estoque vázio");
            System.out.println("9 - Listar por fabricante");
            System.out.println("10 - Listar por validade");
            System.out.println("11 - Vender produto");
            System.out.println("12 - Comprar produto");
            System.out.println("13 - Listar tudo");
            System.out.println("14 - Sair");
            System.out.print("Digite uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("==========================");
                    System.out.println("1- Eletrônico ");
                    System.out.println("2- Perecível ");
                    System.out.println("3- Móvel ");
                    System.out.print("Escolha o tipo de produto: ");
                    int tipoProduto = scan.nextInt();

                    switch (tipoProduto) {
                        case 1:
                            System.out.println("==========================");
                            System.out.print("Digite o código:");
                            int codigo = scan.nextInt();
                            scan.nextLine();

                            System.out.print("Nome: ");
                            String nome = scan.nextLine();

                            System.out.print("Fabricante: ");
                            String fabricante = scan.next();

                            System.out.print("Quantidade: ");
                            int quantidade = scan.nextInt();

                            System.out.print("Valor unitário: ");
                            double valorUnitario = scan.nextDouble();
                            scan.nextLine();

                            System.out.print("Voltagem: ");
                            String voltagem = scan.nextLine();

                            System.out.print("Potência: ");
                            int potencia = scan.nextInt();
                            scan.nextLine();

                            System.out.print("Eficiência: ");
                            String classEficiencia = scan.next();
                            System.out.println("==========================");

                            gcp.adicionar(new Eletronico(codigo, nome, fabricante, quantidade, valorUnitario, voltagem, potencia, classEficiencia));
                            break;
                        case 2:
                            System.out.println("==========================");
                            System.out.print("Digite o código:");
                            codigo = scan.nextInt();
                            scan.nextLine();

                            System.out.print("Nome: ");
                            nome = scan.nextLine();

                            System.out.print("Fabricante: ");
                            fabricante = scan.next();

                            System.out.print("Quantidade: ");
                            quantidade = scan.nextInt();

                            System.out.print("Valor unitário: ");
                            valorUnitario = scan.nextDouble();
                            scan.nextLine();

                            System.out.print("Validade: ");
                            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate validade = LocalDate.parse(scan.next(), formatador);

                            System.out.print("Ele é refrigerado ? (true, false) ");
                            boolean refrigerado = scan.nextBoolean();
                            System.out.println("==========================");

                            gcp.adicionar(new Perecivel(codigo, nome, fabricante, quantidade, valorUnitario, validade, refrigerado));
                            break;
                        case 3:
                            System.out.println("==========================");
                            System.out.print("Digite o código:");
                            codigo = scan.nextInt();
                            scan.nextLine();

                            System.out.print("Nome: ");
                            nome = scan.nextLine();

                            System.out.print("Fabricante: ");
                            fabricante = scan.next();

                            System.out.print("Quantidade: ");
                            quantidade = scan.nextInt();

                            System.out.print("Valor unitário: ");
                            valorUnitario = scan.nextDouble();
                            scan.nextLine();

                            System.out.print("Tipo de material: ");
                            String tipoMaterial = scan.next();
                            System.out.println("==========================");

                            gcp.adicionar(new Movel(codigo, nome, fabricante, quantidade, valorUnitario, tipoMaterial));
                            break;
                    }
                    break;
                case 2:
                    System.out.println("==========================");
                    System.out.print("Digite o código do produto: ");
                    int codigo = scan.nextInt();
                    if (gcp.remover(codigo)) {
                        System.out.println("Produto removido");
                        System.out.println("==========================");
                        break;
                    }
                    ;
                    System.out.println("Produto não encontrado");
                    System.out.println("==========================");
                    break;
                case 3:
                    System.out.println("==========================");
                    System.out.print("Digite o código do produto que deseja buscar: ");
                    codigo = scan.nextInt();
                    if (gcp.buscarPorCodigo(codigo) == null) {
                        System.out.println("Produto não encontrado");
                        System.out.println("==========================");
                        break;
                    }
                    System.out.println(gcp.buscarPorCodigo(codigo).imprimir());
                    System.out.println("==========================");
                    break;
                case 4:
                    System.out.println("==========================");
                    System.out.println(gcp.listarEletronicos());
                    System.out.println("==========================");
                    break;
                case 5:
                    System.out.println("==========================");
                    System.out.println(gcp.listarPereciveis());
                    System.out.println("==========================");
                    break;
                case 6:
                    System.out.println("==========================");
                    System.out.println(gcp.listarMoveis());
                    System.out.println("==========================");
                    break;
                case 7:
                    System.out.println("==========================");
                    System.out.print("Digite o estoque mínimo: ");
                    int estoqueMinimo = scan.nextInt();
                    System.out.println(gcp.listarEstoqueMenor(estoqueMinimo));
                    System.out.println("==========================");
                    break;
                case 8:
                    System.out.println("==========================");
                    System.out.println(gcp.listarEstoqueVazio());
                    System.out.println("==========================");
                    break;
                case 9:
                    System.out.println("==========================");
                    System.out.print("Digite o nome do fabricante: ");
                    String fabricante = scan.next();
                    System.out.println(gcp.listarPorFabricante(fabricante));
                    System.out.println("==========================");
                    break;
                case 10:
                    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    System.out.println("==========================");
                    System.out.print("Digite a validade: ");
                    String validadeBuscada = scan.next();
                    LocalDate validadeTeste = LocalDate.parse(validadeBuscada, formatador);

                    System.out.println(gcp.listarPorValidade(validadeTeste));
                    System.out.println("==========================");
                    break;
                case 11:
                    System.out.println("==========================");
                    System.out.print("Digite o código do produto: ");
                    codigo = scan.nextInt();

                    System.out.print("Digite a quantidade que deseja vender: ");
                    int quantidade = scan.nextInt();

                    System.out.println("Valor da venda " + gcp.venderProduto(codigo, quantidade));
                    System.out.println("==========================");
                    break;
                case 12:
                    System.out.println("==========================");
                    System.out.print("Digite o código do produto: ");
                    codigo = scan.nextInt();

                    System.out.print("Digite a quantidade que deseja comprar: ");
                    quantidade = scan.nextInt();

                    if (gcp.comprarProduto(codigo, quantidade)) {
                        System.out.println("Produto comprado.");
                        System.out.println("==========================");
                        break;
                    }

                    System.out.println("Produto não encontrado.");
                    System.out.println("==========================");
                    break;
                case 13:
                    System.out.println("==========================");
                    System.out.println(gcp.listarTudo());
                    System.out.println("==========================");
                    break;
                case 14:
                    System.out.println("==========================");
                    System.out.println("Até mais!");
                    System.out.println("==========================");
                    break;
                default:
                    System.out.println("==========================");
                    System.out.println("Opção inválida !");
                    System.out.println("==========================");
            }
        } while (opcao != 14);
        scan.close();
   }
}
