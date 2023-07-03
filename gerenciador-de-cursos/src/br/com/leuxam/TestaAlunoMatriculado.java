package br.com.leuxam;

public class TestaAlunoMatriculado {
    public static void main(String[] args) {
        Curso curso1 = new Curso("Ciências da Computação", "Maxuel");
        Aluno aluno1 = new Aluno("Maxuel Jr", 1782);
        Aluno aluno2 = new Aluno("Murilo Magalhaes", 1781);
        Aluno aluno3 = new Aluno("Valdir Spignata", 1780);

        curso1.matricula(aluno1);
        curso1.matricula(aluno2);
        curso1.matricula(aluno3);

        Aluno aluno4 = new Aluno("Maxuel Jr", 17821);
        System.out.println(curso1.estaMatriculado(aluno4));

        System.out.println(aluno1.hashCode() == aluno4.hashCode());
    }
}
