package atv1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GerenciaAluno {
    public static void main(String[] args) {
        GerenciaAluno gerencia = new GerenciaAluno();
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Remover aluno");
            System.out.println("4 - Alterar aluno");
            System.out.println("5 - Calcular madia das notas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = entrada.next();
                    System.out.print("Nota do aluno: ");
                    double nota = entrada.nextDouble();
                    Aluno novoAluno = new Aluno(nome, nota);
                    gerencia.adicionarAluno(novoAluno, listaAlunos);
                    break;

                case 2:
                    gerencia.listarTodosAlunos(listaAlunos);
                    break;

                case 3:
                    System.out.print("Nome do aluno a remover: ");
                    String nomeRemover = entrada.next();
                    gerencia.removerAluno(nomeRemover, listaAlunos);
                    break;

                case 4:
                    System.out.print("Nome do aluno a alterar: ");
                    String nomeAlterar = entrada.next();
                    gerencia.alterarAluno(nomeAlterar, listaAlunos, entrada);
                    break;

                case 5:
                    gerencia.calcularMediaNotas(listaAlunos);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção invalida.");
            }

        } while (opcao != 0);

        entrada.close();
    }
    public void adicionarAluno(Aluno aluno, ArrayList<Aluno> listaAlunos) {
        listaAlunos.add(aluno);
        System.out.println("Aluno " + aluno.getNome() + " com nota " + aluno.getNota() + " adicionado com sucesso.");
    }

    public void listarTodosAlunos(ArrayList<Aluno> listaAlunos) {
        for (Aluno aluno : listaAlunos) {
            System.out.println("Aluno: " + aluno.getNome() + " - Nota: " + aluno.getNota());
        }
    }

    public void removerAluno(String nome, ArrayList<Aluno> listaAlunos) {
        Iterator<Aluno> iterador = listaAlunos.iterator();
        while (iterador.hasNext()) {
            Aluno aluno = iterador.next();
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                iterador.remove();
                System.out.println("Aluno " + nome + " removido.");
                return;
            }
        }
        System.out.println("Aluno nao encontrado.");
    }

    public void alterarAluno(String nome, ArrayList<Aluno> listaAlunos, Scanner entrada) {
        for (int i = 0; i < listaAlunos.size(); i++) {
            Aluno aluno = listaAlunos.get(i);
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Digite o novo nome:");
                String novoNome = entrada.next();
                System.out.println("Digite a nova nota:");
                double novaNota = entrada.nextDouble();
                listaAlunos.set(i, new Aluno(novoNome, novaNota));
                System.out.println("Aluno atualizado.");
                return;
            }
        }
        System.out.println("Aluno nao encontrado.");
    }

    public void calcularMediaNotas(ArrayList<Aluno> listaAlunos) {
        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        double soma = 0;
        for (Aluno aluno : listaAlunos) {
            soma += aluno.getNota();
        }
        double media = soma / listaAlunos.size();
        System.out.println("Madia das notas: " + media);
    }
}


