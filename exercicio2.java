package lista12_pob;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Produto {
    String nome;
    double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + preco + ")";
    }
}

public class Exercicio2 {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 3500.0),
            new Produto("Mouse", 120.0),
            new Produto("Teclado", 250.0),
            new Produto("Monitor", 1200.0),
            new Produto("Cadeira", 900.0),
            new Produto("Headset", 300.0)
        );

        double total = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();

        double media = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .average()
                .orElse(0.0);

        Produto maisCarro = produtos.stream()
                .max(Comparator.comparingDouble(Produto::getPreco))
                .orElse(null);

        System.out.println("Valor Total: R$ " + total);
        System.out.println("Preço Médio: R$ " + media);
        System.out.println("Produto mais caro: " + maisCarro);
    }
}
