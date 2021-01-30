public class Venda {

    private Produto produto;
    private static int quantidadeVendas;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void venderProduto(double valorPago) {
        if (valorPago >= produto.getValor()) {
            System.out.println("\nProduto: " + produto.getNome());
            System.out.println("\nValor: R$" + String.format("%.2f", produto.getValor()));
            System.out.println("\nTroco: R$" + String.format("%.2f", valorPago - produto.getValor()));
            produto.atualizarEstoque();
            atualizarQuantidadeVendas();
        } else {
            System.out.println("Faltam R$" + String.format("%.2f", produto.getValor() - valorPago));
        }
    }

    public void atualizarQuantidadeVendas() {
        quantidadeVendas++;
    }
}

