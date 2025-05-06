package Atv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciaTarefas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Tarefas>tarefasList = new ArrayList<>();
        GerenciaTarefas gerenciador = new GerenciaTarefas();
        int opcao;

        do {
            System.out.println("1-adicionar tarefa");
            System.out.println("2-Buscar tarefa por descrição");
            System.out.println("3-atualizar o status da tarefa");
            System.out.println("4-Remover tarefa pela descrição");
            System.out.println("5-Listar todas as tarefas");
            System.out.println("0-Sair");
            System.out.print("Escolha: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); // limpar buffer
            switch (opcao) {
                case 1:
                    System.out.println("digite a descrição: ");
                    String NovaDesc = entrada.nextLine();
                    System.out.println("digite a prioridade");
                    int NovaPrioridade = entrada.nextInt();
                    System.out.println("coloque o status (pendente ou concluída)");
                    String status = entrada.nextLine();
                    Tarefas novo = new  Tarefas(NovaDesc,NovaPrioridade,status);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }while (true);
    }
}
