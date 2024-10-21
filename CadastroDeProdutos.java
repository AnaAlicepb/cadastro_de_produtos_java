import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroDeProdutos {

    private static List<Produto> produtos = new ArrayList<>();
    private static int contadorId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Cadastro de Produtos ---");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Remover produto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner);
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    removerProduto(scanner);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.print("Nome do produto: ");
        scanner.nextLine(); // Limpar buffer do scanner
        String nome = scanner.nextLine();

        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade do produto: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(contadorId++, nome, preco, quantidade);
        produtos.add(produto);

        System.out.println("Produto adicionado com sucesso!");
    }

    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n--- Lista de Produtos ---");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    private static void removerProduto(Scanner scanner) {
        System.out.print("ID do produto a ser removido: ");
        int id = scanner.nextInt();

        Produto produtoParaRemover = null;
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtoParaRemover = produto;
                break;
            }
        }

        if (produtoParaRemover != null) {
            produtos.remove(produtoParaRemover);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
