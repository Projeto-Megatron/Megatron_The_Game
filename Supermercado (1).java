import java.util.ArrayList;
import java.util.Scanner;

// Classe para representar um produto
class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

public class Supermercado {
    private ArrayList<Produto> estoque;

    public Supermercado() {
        this.estoque = new ArrayList<>();
    }

    // Método para adicionar um produto ao estoque
    public void adicionarProduto(Produto produto) {
        estoque.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    // Método para remover um produto do estoque
    public void removerProduto(String nome) {
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i).getNome().equalsIgnoreCase(nome)) {
                estoque.remove(i);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    // Método para alterar o preço de um produto
    public void alterarPreco(String nome, double novoPreco) {
        for (Produto produto : estoque) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produto.setPreco(novoPreco);
                System.out.println("Preço do produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    // Método para incluir quantidade de um produto no estoque
    public void incluirQuantidade(String nome, int quantidade) {
        for (Produto produto : estoque) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produto.setQuantidade(produto.getQuantidade() + quantidade);
                System.out.println("Quantidade do produto atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    // Método para listar todos os produtos do estoque
    public void listarProdutos() {
        System.out.println("Lista de produtos no estoque:");
        System.out.println("");
        for (Produto produto : estoque) {
            System.out.println("Produto: " + produto.getNome() );
            System.out.println("Preço: R$ " + produto.getPreco());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermercado supermercado = new Supermercado();

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Alterar Preço do Produto");
            System.out.println("4. Incluir Quantidade de Produto");
            System.out.println("5. Listar Produtos");
            System.out.println("6. Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Digite o preço do produto: R$");
                    double precoProduto = scanner.nextDouble();
                    System.out.print("Digite a quantidade do produto: ");
                    int quantidadeProduto = scanner.nextInt();
                    supermercado.adicionarProduto(new Produto(nomeProduto, precoProduto, quantidadeProduto));
                    break;
                case 2:
                    System.out.print("Digite o nome do produto a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    supermercado.removerProduto(nomeRemover);
                    break;
                case 3:
                    System.out.print("Digite o nome do produto a ter o preço alterado: ");
                    String nomeAlterar = scanner.nextLine();
                    System.out.print("Digite o novo preço do produto: R$");
                    double novoPreco = scanner.nextDouble();
                    supermercado.alterarPreco(nomeAlterar, novoPreco);
                    break;
                case 4:
                    System.out.print("Digite o nome do produto a ter a quantidade incluída: ");
                    String nomeIncluir = scanner.nextLine();
                    System.out.print("Digite a quantidade a ser incluída: ");
                    int quantidadeIncluir = scanner.nextInt();
                    supermercado.incluirQuantidade(nomeIncluir, quantidadeIncluir);
                    break;
                case 5:
                    supermercado.listarProdutos();
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
