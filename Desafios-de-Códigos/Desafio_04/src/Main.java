import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    // A classe Candidato continua a mesma
    static class Candidato {
        String nome;
        int pontuacao;

        Candidato(String nome, int pontuacao) {
            this.nome = nome;
            this.pontuacao = pontuacao;
        }

        @Override
        public String toString() {
            // Helper para facilitar a exibição
            return "Nome: " + nome + ", Pontuação: " + pontuacao;
        }
    }

    public static void main(String[] args) {
        // O Scanner e a lista são criados fora do loop para persistirem
        Scanner scanner = new Scanner(System.in);
        List<Candidato> candidatos = new ArrayList<>();

        // Loop principal do menu interativo
        while (true) {
            System.out.println("\n--- MENU DE CLASSIFICAÇÃO ---");
            System.out.println("1. Adicionar novo candidato");
            System.out.println("2. Ver classificação final");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    // Bloco para adicionar um novo candidato
                    System.out.print("Digite o nome do candidato: ");
                    String nome = scanner.nextLine().trim();

                    System.out.print("Digite a pontuação de " + nome + ": ");
                    try {
                        int pontuacao = Integer.parseInt(scanner.nextLine().trim());
                        candidatos.add(new Candidato(nome, pontuacao));
                        System.out.println(">> Candidato " + nome + " adicionado com sucesso!");
                    } catch (NumberFormatException e) {
                        System.out.println("!! Erro: Pontuação inválida. Use apenas números. O candidato não foi adicionado.");
                    }
                    break;

                case "2":
                    // Bloco para ordenar e exibir a classificação
                    if (candidatos.isEmpty()) {
                        System.out.println(">> Nenhum candidato cadastrado ainda.");
                        break;
                    }

                    System.out.println("\n--- CLASSIFICAÇÃO FINAL ---");

                    // Criamos uma cópia para não alterar a ordem original de inserção
                    List<Candidato> listaOrdenada = new ArrayList<>(candidatos);

                    // A LÓGICA DE ORDENAÇÃO É EXATAMENTE A MESMA
                    listaOrdenada.sort(Comparator
                            .comparingInt((Candidato c) -> c.pontuacao).reversed()
                            .thenComparing(c -> c.nome));

                    // Imprimir nomes na ordem definida
                    for (Candidato c : listaOrdenada) {
                        System.out.println(c.nome);
                    }
                    break;

                case "3":
                    // Bloco para encerrar o programa
                    System.out.println("Até mais!");
                    scanner.close(); // Fecha o scanner antes de sair
                    return; // Sai do método main e encerra o programa

                default:
                    // Caso o usuário digite uma opção inválida
                    System.out.println("!! Opção inválida. Por favor, escolha 1, 2 ou 3.");
                    break;
            }
        }
    }
}

