public class Main {
    public static void main(String[] args) {
        // Criando instâncias de alunos
        Aluno aluno1 = new Aluno(1, "Alan");
        Aluno aluno2 = new Aluno(2, "Jeferson");
        Aluno aluno3 = new Aluno(11, "Ramon");  // Este causará colisão com aluno1 se o tamanho da tabela for 10

        // Criando a tabela hash
        TabelaHash tabela = new TabelaHash(10);

        // Inserindo valores
        tabela.inserirValor(aluno1);
        tabela.inserirValor(aluno2);
//        tabela.inserirValor(aluno3);

        System.out.println("Tabela Hash após inserções:");
        System.out.println(tabela);

        // Pegando valor
        String nome = tabela.pegarValor(2);
        System.out.println("Nome do aluno com matrícula 2: " + nome);

        // Removendo valor
        tabela.removerValor(1);
        System.out.println("Tabela Hash após remoção da matrícula 1:");
        System.out.println(tabela);

    }
}
