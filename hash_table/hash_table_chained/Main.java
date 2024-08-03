package hash_table_chained;

public class Main {
    public static void main(String args[]) {
        HashTable hashTable = new HashTable(10);
        
        Aluno aluno_001 = new Aluno(180, "Abraão Borges");
        Aluno aluno_002 = new Aluno(337, "André Borges");
        Aluno aluno_003 = new Aluno(190, "Lucio Borges");
        Aluno aluno_004 = new Aluno(100, "Pedro Borges");
        Aluno aluno_005 = new Aluno(101, "Antonio Borges");
        Aluno aluno_006 = new Aluno(201, "Filipe Borges");

        hashTable.inserirValor(aluno_001);
        hashTable.inserirValor(aluno_002);
        hashTable.inserirValor(aluno_003);
        hashTable.inserirValor(aluno_004);
        hashTable.inserirValor(aluno_005);
        hashTable.inserirValor(aluno_006);

        hashTable.exibirValores();
    }
}