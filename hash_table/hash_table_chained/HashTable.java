package hash_table_chained;

public class HashTable {
    private int tamanho;
    private LinkedList[] tabela; // Uma tabela de listas encadeadas. Cada índice corresponde a uma lista encadeada.

    public HashTable(int tamanho) {
        this.tamanho = tamanho;
        tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList();
        }
    }

    private int calcularHash(int matricula) {
        return matricula % tamanho;
    }

    public void inserirValor(Aluno aluno) {
        int indice = calcularHash(aluno.getMatricula());
        if (tabela[indice] == null) {
            tabela[indice] = new LinkedList();
        }
        tabela[indice].inserir(aluno);
    }

    public boolean removerValor(int matricula) {
        int indice = calcularHash(matricula);
        return tabela[indice].remover(matricula);
    }

    public String pegarValor(int matricula) {
        int indice = calcularHash(matricula);
        return tabela[indice].pegar(matricula);
    }

    public void exibirValores() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            if (tabela[i] == null) {
                result.append(i).append(": ").append("\n");
            } else {
                result.append(i).append(": ").append(tabela[i].exibir()).append("\n");
            }
        }
        System.out.println(result);
    }
}