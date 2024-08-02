public class TabelaHash {
    private Aluno[] tabela; // Declarando um Array de objetos Aluno.
    private int tamanho;
    private int capacidade;
    private static final Aluno REMOVIDO = new Aluno(-1, "REMOVIDO");

    public TabelaHash(int capacidadeInicial) {
        this.capacidade = capacidadeInicial;
        this.tabela = new Aluno[capacidadeInicial];
        this.tamanho = 0;
    }

    private int calcularHash(int matricula) {
        return matricula % capacidade;
    }

    private void redimensionar() {
        int novaCapacidade = capacidade * 2;
        Aluno[] novaTabela = new Aluno[novaCapacidade];

        for (Aluno aluno : tabela) {
            if (aluno != null && aluno != REMOVIDO) {
                int posicao = aluno.getMatricula() % novaCapacidade;
                while (novaTabela[posicao] != null) {
                    posicao = (posicao + 1) % novaCapacidade;
                }
                novaTabela[posicao] = aluno;
            }
        }

        tabela = novaTabela;
        capacidade = novaCapacidade;
    }

    public void inserirValor(int matricula, String nome) {
        if (tamanho == capacidade) {
            redimensionar();
        }

        int posicao = calcularHash(matricula);
        while (tabela[posicao] != null && tabela[posicao] != REMOVIDO) {
            posicao = (posicao + 1) % capacidade;
        }

        tabela[posicao] = new Aluno(matricula, nome);
        tamanho++;
    }

    public String pegarValor(int matricula) {
        int posicao = calcularHash(matricula);
        while (tabela[posicao] != null) {
            if (tabela[posicao].getMatricula() == matricula) {
                return tabela[posicao].getNome();
            }
            posicao = (posicao + 1) % capacidade;
        }
        return null; // Retorna null se o aluno não for encontrado
    }

    public void removerValor(int matricula) {
        int posicao = calcularHash(matricula);
        while (tabela[posicao] != null) {
            if (tabela[posicao].getMatricula() == matricula) {
                tabela[posicao] = REMOVIDO;
                tamanho--;
                return;
            }
            posicao = (posicao + 1) % capacidade;
        }
    }
}