package Atv3;
import java.util.ArrayList;
import java.util.Iterator;
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
                    String Desc = entrada.nextLine();
                    System.out.println("digite a prioridade");
                    int Prioridade = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("coloque o status (pendente ou concluída)");
                    String status = entrada.nextLine();
                    Tarefas novo = new  Tarefas(Desc,Prioridade,status);
                    gerenciador.adicionarTarefas(tarefasList, novo);
                    break;
                case 2:
                    System.out.print("digite o nome da tarefa: ");
                    String busca = entrada.nextLine();
                    gerenciador.buscar(tarefasList, busca);
                    break;
                case 3:
                    System.out.print("Nome da tarefa a alterar: ");
                    String nomeAlterar = entrada.next();
                    gerenciador.alterarTarefa(nomeAlterar,tarefasList,entrada);
                    break;
                case 4:
                    System.out.print("Nome da Tarefa a remover: ");
                    String nomeRemover = entrada.next();
                    gerenciador.remover(nomeRemover, tarefasList);
                    break;
                case 5:
                    gerenciador.listar(tarefasList);
                    break;
            }
        }while (true);
    }
    public void adicionarTarefas(List<Tarefas> lista, Tarefas tarefas) {
        lista.add(tarefas);
        System.out.println("Tarefa adicionado com sucesso!");
    }
    public void buscar(List<Tarefas> lista, String Busca) {
        boolean encontrado = false;
        for (Tarefas t : lista) {
            if (t.getDescricao().equals(Busca)) {
                System.out.println("Tarefa: "+t.getDescricao() + " \nPrioridade:  " + t.getDescricao());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Tarefa não encontrado");
        }
    }
    public void alterarTarefa(String nome,List<Tarefas> listaTarefas, Scanner entrada) {
        for (int i = 0; i < listaTarefas.size(); i++) {
            Tarefas tarefas = listaTarefas.get(i);
            if (tarefas.getDescricao().equalsIgnoreCase(nome)) {
                System.out.println("Digite o novo nome:");
                String novoNome = entrada.next();
                System.out.println("Digite a nova Prioridade:");
                int novaPrioridade = entrada.nextInt();
                System.out.println("qual o novo status (pendente ou concluída)");
                String novoStatus = entrada.nextLine();
                listaTarefas.set(i, new Tarefas(novoNome,novaPrioridade,novoStatus));
                System.out.println("Tarefa atualizado.");
                return;
            }
        }
        System.out.println("Tarefa nao encontrado.");
    }
    public void remover(String nome,List<Tarefas> tarefasList) {
        Iterator<Tarefas> iterador = tarefasList.iterator();
        while (iterador.hasNext()) {
            Tarefas tarefas = iterador.next();
            if (tarefas.getDescricao().equalsIgnoreCase(nome)) {
                iterador.remove();
                System.out.println("Tarefa " + nome + " removido.");
                return;
            }
        }
        System.out.println("Tarefa nao encontrado.");
    }
    public void listar(List<Tarefas> listaTarefas) {
        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhum Tarefa cadastrado.");
            return;
        }

        for (Tarefas tarefas : listaTarefas) {
            System.out.println("Tarefa: " + tarefas.getDescricao() + "\n prioridade: " + tarefas.getPrioridade() + "\n status:" + tarefas.getStatus());
        }
    }
}
