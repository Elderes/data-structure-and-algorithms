package hash_table_chained;

public class Main {
    public static void main(String args[]) {
        HashTable hashTable = new HashTable(10);
        
        Aluno aluno_001 = new Aluno(180, "Abraão Borges");
        Aluno aluno_002 = new Aluno(337, "André Borges");

        hashTable.inserirValor(aluno_001);
        hashTable.inserirValor(aluno_002);

        System.out.println(hashTable);
    }
}