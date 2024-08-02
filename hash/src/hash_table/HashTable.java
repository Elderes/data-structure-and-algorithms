public class HashTable {
    private int tamanho;
    private LinkedList[] tabela;

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
        tabela[indice].inserir(aluno);
    }

    public boolean removerValor(int matricula) {
        int indice = calcularHash(matricula);
        return tabela[indice].remover(matricula);
    }

    public String pegarValor(int matricula) {
        int indice = calcularHash(matricula);
        return tabela[indice].pegarValor(matricula);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            result.append(i).append(": ").append(tabela[i]).append("\n");
        }
        return result.toString();
    }
}