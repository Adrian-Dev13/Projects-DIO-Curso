import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    // Nova classe para estruturar melhor os dados do candidato
    static class Candidato {
        String nome;
        List<String> habilidades;

        Candidato(String nome, List<String> habilidades) {
            this.nome = nome;
            this.habilidades = habilidades;
        }

        @Override
        public String toString() {
            // Junta as habilidades com ", " para uma exibição amigável
            String habilidadesStr = String.join(", ", this.habilidades);
            return "Nome: " + this.nome + " | Habilidades: " + habilidadesStr;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Candidato> bancoDeCandidatos = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU DE FILTRO DE CANDIDATOS ---");
            System.out.println("1. Adicionar novo candidato");
            System.out.println("2. Filtrar por habilidade");
            System.out.println("3. Ver todos os candidatos cadastrados");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o nome do candidato: ");
                    String nome = scanner.nextLine().trim();

                    System.out.print("Digite as habilidades de " + nome + " (separadas por vírgula): ");
                    String habilidadesInput = scanner.nextLine();

                    // Converte a string "java, sql, git" em uma lista de strings
                    List<String> listaDeHabilidades = Arrays.stream(habilidadesInput.split(","))
                            .map(String::trim) // Remove espaços em branco de cada habilidade
                            .collect(Collectors.toList());

                    bancoDeCandidatos.add(new Candidato(nome, listaDeHabilidades));
                    System.out.println(">> Candidato " + nome + " adicionado com sucesso!");
                    break;

                case "2":
                    if (bancoDeCandidatos.isEmpty()) {
                        System.out.println(">> Nenhum candidato cadastrado para filtrar.");
                        break;
                    }

                    System.out.print("Digite a habilidade que deseja buscar: ");
                    String habilidadeBuscada = scanner.nextLine().trim().toLowerCase();

                    // Lista para guardar os nomes dos candidatos encontrados
                    List<String> candidatosEncontrados = new ArrayList<>();

                    // A LÓGICA DE FILTRO É A MESMA DO DESAFIO ORIGINAL
                    for (Candidato candidato : bancoDeCandidatos) {
                        for (String habilidade : candidato.habilidades) {
                            if (habilidade.trim().toLowerCase().equals(habilidadeBuscada)) {
                                candidatosEncontrados.add(candidato.nome);
                                break; // Encontrou, pode parar de olhar as habilidades deste candidato
                            }
                        }
                    }

                    System.out.println("\n--- RESULTADO DO FILTRO ---");
                    if (candidatosEncontrados.isEmpty()) {
                        System.out.println("Nenhum candidato encontrado com a habilidade: " + habilidadeBuscada);
                    } else {
                        System.out.println("Candidatos com a habilidade '" + habilidadeBuscada + "':");
                        for (String nomeEncontrado : candidatosEncontrados) {
                            System.out.println(nomeEncontrado);
                        }
                    }
                    break;

                case "3":
                    if (bancoDeCandidatos.isEmpty()) {
                        System.out.println(">> Nenhum candidato cadastrado ainda.");
                        break;
                    }
                    System.out.println("\n--- TODOS OS CANDIDATOS ---");
                    for (Candidato c : bancoDeCandidatos) {
                        System.out.println(c);
                    }
                    break;

                case "4":
                    System.out.println("Até mais!");
                    scanner.close();
                    return;

                default:
                    System.out.println("!! Opção inválida. Por favor, escolha uma das opções do menu.");
                    break;
            }
        }
    }
}

