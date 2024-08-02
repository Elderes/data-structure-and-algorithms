public class App {
    public static void main(String[] args) throws Exception {
        TabelaHash tabela = new TabelaHash(5);

        tabela.inserirValor(1, "Alice");
        tabela.inserirValor(2, "Bob");
        tabela.inserirValor(3, "Charlie");
        tabela.inserirValor(4, "David");
        tabela.inserirValor(5, "Eve");

        System.out.println(tabela.pegarValor(3)); // Output: Charlie

        tabela.removerValor(3);
        System.out.println(tabela.pegarValor(3)); // Output: null

        tabela.inserirValor(3, "Charlie");
        System.out.println(tabela.pegarValor(3)); // Output: Charlie
    }
}