package hash_table_unchained;

public class HashTable {
    private Aluno[] tabela; // Declarando um array de objetos Aluno.
    private int tamanho;
    private int capacidade;
    private static final Aluno REMOVIDO = new Aluno(-1, "REMOVIDO"); // Valor padrão para objetos removidos da table (eles não podem ser nulos).

    public HashTable(int capacidadeInicial) {
        this.capacidade = capacidadeInicial; // Capacidade total de armazenamento da lista.
        this.tabela = new Aluno[capacidadeInicial]; // Cria uma array de tamanho escolhido na instância.
        this.tamanho = 0; // Número de espaços ocupados na lista.
    }

    private int calcularHash(int matricula) {
        return matricula % capacidade; // Função hash básica usando o resto da divisão para os índices.
    }

    private void redimensionar() {
        int novaCapacidade = capacidade * 2; // Dobra a váriavel capacidade.
        Aluno[] novaTabela = new Aluno[novaCapacidade]; // Cria uma nova tabela para receber os objetos da tabela antiga.

        for (Aluno aluno : tabela) { // Percorre a tabela antiga.
            if (aluno != null && aluno != REMOVIDO) { // Ignora os nulos e os removidos.
                int posicao = aluno.getMatricula() % novaCapacidade; // Calcula o hash com a nova capacidade.
                while (novaTabela[posicao] != null) { // Enquanto não for nulo (espaço vazio), adicione 1 a posição atual e calcule o hash novamente.
                    posicao = (posicao + 1) % novaCapacidade;
                }
                novaTabela[posicao] = aluno; // Encontrou espaço vazio, realocou um elemento da tabela antiga para a nova tabela.
            }
        }

        tabela = novaTabela; // A tabela antiga é sobrescrita pela tabela nova, com todos os objetos realocados.
        capacidade = novaCapacidade; // A capacidade antiga é sobrescrita com a capacidade nova.
    }

    public void inserirValor(int matricula, String nome) {
        if (tamanho == capacidade) { // Caso todos os elementos da lista forem ocupados, redimensione.
            redimensionar();
        }

        int posicao = calcularHash(matricula); // Calcula o hash e atribui a posição.
        while (tabela[posicao] != null && tabela[posicao] != REMOVIDO) { // A partir do hash calculado, procurar uma posição de valor nulo ou item removido (-1).
            posicao = (posicao + 1) % capacidade;
        }

        tabela[posicao] = new Aluno(matricula, nome); // Posição encontrada, preencha.
        tamanho++; // Indicar que um novo elemento foi adicionado a lista.
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