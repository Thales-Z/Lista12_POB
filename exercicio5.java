package lista12_pob;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Funcionario {
    String nome;
    String departamento;
    double salario;

    public Funcionario(String nome, String departamento, double salario) {
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }
}

public class Exercicio5 {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = Arrays.asList(
            new Funcionario("Thales", "TI", 5000.0),
            new Funcionario("João", "RH", 3000.0),
            new Funcionario("Maria", "TI", 6000.0)
        );

        Predicate<Funcionario> ehDaTI = f -> f.getDepartamento().equalsIgnoreCase("TI");
        Function<Funcionario, Double> reajuste = f -> f.getSalario() * 1.10;
        Consumer<Double> imprimir = val -> System.out.printf("Salário projetado: R$ %.2f\n", val);

        funcionarios.stream()
                .filter(ehDaTI)
                .map(reajuste)
                .forEach(imprimir);
    }
}
