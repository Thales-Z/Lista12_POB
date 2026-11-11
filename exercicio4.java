package lista12_pob;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface TransformadorTexto {
    String transformar(String entrada);
}

public class Exercicio4 {
    public static List<String> processarLista(List<String> lista, TransformadorTexto regra) {
        return lista.stream()
                .map(regra::transformar)
                .toList();
    }

    public static void main(String[] args) {
        List<String> textos = Arrays.asList("java", "stream", "lambda");

        List<String> maiusculas = processarLista(textos, String::toUpperCase);
        List<String> comColchetes = processarLista(textos, s -> "[" + s + "]");
        List<String> invertidas = processarLista(textos, s -> new StringBuilder(s).reverse().toString());

        System.out.println("Maiúsculas: " + maiusculas);
        System.out.println("Com colchetes: " + comColchetes);
        System.out.println("Invertidas: " + invertidas);
    }
}
