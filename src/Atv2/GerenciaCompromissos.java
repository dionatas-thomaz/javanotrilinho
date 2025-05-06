package Atv2;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaCompromissos {

    public void adicionarCompromisso(ArrayList<Compromisso> lista, Compromisso compromisso) {
        lista.add(compromisso);
        System.out.println("Compromisso adicionado com sucesso!");
    }

    public void removerCompromisso(ArrayList<Compromisso> lista, int indice) {
        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
            System.out.println("Compromisso removido com sucesso!");
        } else {
            System.out.println("indice invalido!");
        }
    }

    public void listarCompromissos(ArrayList<Compromisso> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum compromisso cadastrado.");
            return;
        }

        for (int i = 0; i < lista.size(); i++) {
            Compromisso c = lista.get(i);
            System.out.println(i + " - " + c.getData() + " : " + c.getDescricao());
        }
    }

    public void buscarPorData(ArrayList<Compromisso> lista, String dataBusca) {
        boolean encontrado = false;
        for (Compromisso c : lista) {
            if (c.getData().equals(dataBusca)) {
                System.out.println(c.getData() + " : " + c.getDescricao());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum compromisso encontrado para esta data.");
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Compromisso> lista = new ArrayList<>();
        GerenciaCompromissos gerenciador = new GerenciaCompromissos();

        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar Compromisso");
            System.out.println("2. Remover Compromisso (por indice)");
            System.out.println("3. Listar todos os Compromissos");
            System.out.println("4. Buscar Compromissos por Data");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a data : ");
                    String data = entrada.nextLine();
                    System.out.print("Digite a descrição: ");
                    String desc = entrada.nextLine();
                    Compromisso novo = new Compromisso(data, desc);
                    gerenciador.adicionarCompromisso(lista, novo);
                    break;

                case 2:
                    System.out.print("Digite o indice do compromisso a remover: ");
                    int indice = entrada.nextInt();
                    gerenciador.removerCompromisso(lista, indice);
                    break;

                case 3:
                    gerenciador.listarCompromissos(lista);
                    break;

                case 4:
                    System.out.print("Digite a data para busca : ");
                    String busca = entrada.nextLine();
                    gerenciador.buscarPorData(lista, busca);
                    break;

                case 0:
                    System.out.println("Saindo da agenda...");
                    break;

                default:
                    System.out.println("Opção invalida!");
            }

        } while (opcao != 0);

        entrada.close();
    }
}

