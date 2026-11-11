package lista12_pob;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Aluno {
    String nome;
    String curso;
    double notaFinal;

    public Aluno(String nome, String curso, double notaFinal) {
        this.nome = nome;
        this.curso = curso;
        this.notaFinal = notaFinal;
    }

    public String getCurso() {
        return curso;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    @Override
    public String toString() {
        return nome + " (" + notaFinal + ")";
    }
}

public class Exercicio3 {
    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(
            new Aluno("Ana", "Sistemas", 8.5),
            new Aluno("Carlos", "Direito", 6.0),
            new Aluno("Beatriz", "Sistemas", 9.0),
            new Aluno("Bruno", "Direito", 7.5),
            new Aluno("Diana", "Medicina", 5.5)
        );

        Map<String, List<Aluno>> agrupadoPorCurso = alunos.stream()
                .collect(Collectors.groupingBy(Aluno::getCurso));

        Map<Boolean, List<Aluno>> particionadoPorNota = alunos.stream()
                .collect(Collectors.partitioningBy(a -> a.getNotaFinal() > 7.0));

        System.out.println("Agrupados por Curso: " + agrupadoPorCurso);
        System.out.println("Particionados por Aprovados (>7): " + particionadoPorNota);
    }
}
