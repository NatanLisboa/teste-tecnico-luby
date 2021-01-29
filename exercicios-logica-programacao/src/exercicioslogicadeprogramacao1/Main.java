package exercicioslogicadeprogramacao1;

import java.text.ParseException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ParseException {

        //1. Lógica de Programação

        //Exercício 1.1
        System.out.println("1.1 " + (Operacao.calcularFatorial(5) == 120));

        //Exercício 1.2
        System.out.println("1.2a " + (Operacao.calcularPremio(100, "vip") == 120.00));
        System.out.println("1.2b " + (Operacao.calcularPremio(100, "basic", 3) == 300.00));

        /*Outra maneira de resolução do exercício 1.2
        * System.out.println("1.2a " + (Operacao.calcularPremio(100, "vip", null) == 120.00));
        * System.out.println("1.2b " + (Operacao.calcularPremio(100, "basic", "3") == 300.00));
        */

        //Exercício 1.3
        System.out.println("1.3 " + (Operacao.contarNumerosPrimos(10) == 4));

        //Exercício 1.4
        System.out.println("1.4 " + (Operacao.calcularVogais("Luby Software") == 4));

        //Exercício 1.5
        System.out.println("1.5 " + (Operacao.calcularValorComDescontoFormatado("R$ 6.800,00", "30%").equals("R$ 4.760,00")));

        //Exercício 1.6
        System.out.println("1.6 " + ((Operacao.calcularDiferencaData("10122020", "25122020")) == 15));

        //Exercício 1.7
        int[] vetor = new int[]{1, 2, 3, 4, 5};
        System.out.println("1.7 " + (Arrays.equals(Operacao.obterElementosPares(vetor), new int[]{2, 4}))); // Função do JDK 15 para comparar dois vetores.

        //Exerício 1.8
        String[] vetorPessoa = new String[]{
                "John Doe",
                "Jane Doe",
                "Alice Jones",
                "Bobby Louis",
                "Lisa Romero"
        };

        System.out.println("1.8 " + (Arrays.deepEquals(Operacao.buscarPessoa(vetorPessoa, "Doe"), new String[]{"John Doe", "Jane Doe"})));
        System.out.println((Arrays.deepEquals(Operacao.buscarPessoa(vetorPessoa, "Alice"), new String[]{"Alice Jones"})));
        System.out.println((Arrays.deepEquals(Operacao.buscarPessoa(vetorPessoa, "Louis"), new String[]{ }))); // O resultado foi falso pois, no vetor de exemplo, existe uma ocorrência da string "Louis"

        //Exercício 1.9
        System.out.println("1.9 " + Arrays.deepEquals(Operacao.transformarEmMatriz("1,2,3,4,5,6"), new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6}}));

        //Exercício 1.10
        // faltam elementos no vetor2
        int[] vetor1 = new int[] { 1,2,3,4,5 };
        int[] vetor2 = new int[] { 1,2,5 };
        System.out.println("1.10a " + (Arrays.equals(Operacao.obterElementosFaltantes(vetor1, vetor2), new int[]{3, 4})));

        // faltam elementos no vetor3
        int[] vetor3 = new int[] { 1,4,5 };
        int[] vetor4 = new int[] { 1,2,3,4,5 };
        System.out.println("1.10b " + (Arrays.equals(Operacao.obterElementosFaltantes(vetor3, vetor4), new int[]{2, 3})));

        // faltam elementos em ambos vetores
        int[] vetor5 = new int[] { 1,2,3,4 };
        int[] vetor6 = new int[] { 2,3,4,5 };
        System.out.println("1.10c " + (Arrays.equals(Operacao.obterElementosFaltantes(vetor5, vetor6), new int[]{1, 5})));

        // não faltam items
        int[] vetor7 = new int[] { 1,3,4,5 };
        int[] vetor8 = new int[] { 1,3,4,5 };
        System.out.println("1.10d " + (Arrays.equals(Operacao.obterElementosFaltantes(vetor7, vetor8), new int[]{})));
    }

}
