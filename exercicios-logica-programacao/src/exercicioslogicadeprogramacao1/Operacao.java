package exercicioslogicadeprogramacao1;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Operacao {

    /*Função para verificar se uma string inserida é numérica (trabalha em conjunto com a outra forma de resolução do exercício 1.2)*/
    private static boolean eNumerico(String string){

        char[] vetorCaracteres = string.toCharArray();
        boolean valorNumerico = true;
        int i;

        if (vetorCaracteres[0] == '-'){
            i = 1;
        } else {
            i = 0;
        }

        for (; i < vetorCaracteres.length; i++){

            if (vetorCaracteres[i] == '.' && Character.isDigit(vetorCaracteres[i-1])){
                continue;
            } else if (!Character.isDigit(vetorCaracteres[i])){
                valorNumerico = false;
                break;
            }

        }

        return valorNumerico;

    }


    //1.1
    public static int calcularFatorial(int numero){

        int fatorial = 1;

        for (int i = numero; i > 1; i--){
            fatorial *= i;
        }

        return fatorial;

    }

    /* 1.2 Outra forma de resolução
    public static double calcularPremio(double valorInicial, String tipoPremio, String fatorMultiplicativo){

        double valorPremio = valorInicial;

        if (fatorMultiplicativo != null){
            if (eNumerico(fatorMultiplicativo) && Float.parseFloat(fatorMultiplicativo) > 0){
                valorPremio *= Float.parseFloat(fatorMultiplicativo);
            } else {
                System.out.println("Fator multiplicativo inválido! Por favor, reinicie o programa e insira um valor maior que zero.");
            }
        }

        switch (tipoPremio) {
            case "basic" -> valorPremio *= 1;
            case "vip" -> valorPremio *= 1.2;
            case "premium" -> valorPremio *= 1.5;
            case "deluxe" -> valorPremio *= 1.8;
            case "special" -> valorPremio *= 2;
            default -> System.out.println("Não foi um tipo de premiação correspondente a \"" + tipoPremio + "\"");
        }

        return valorPremio;

    }
    */

    //1.2
    public static double calcularPremio(double valorInicial, String tipoPremio){

        double valorPremio = valorInicial;

        switch (tipoPremio) {
            case "basic" -> valorPremio *= 1;
            case "vip" -> valorPremio *= 1.2;
            case "premium" -> valorPremio *= 1.5;
            case "deluxe" -> valorPremio *= 1.8;
            case "special" -> valorPremio *= 2;
            default -> System.out.println("Não foi um tipo de premiação correspondente a \"" + tipoPremio + "\"");
        }

        return valorPremio;

    }

    public static double calcularPremio(double valorInicial, String tipoPremio, float fatorMultiplicativo){

        double valorPremio = valorInicial * fatorMultiplicativo;

        switch (tipoPremio) {
            case "basic" -> valorPremio *= 1;
            case "vip" -> valorPremio *= 1.2;
            case "premium" -> valorPremio *= 1.5;
            case "deluxe" -> valorPremio *= 1.8;
            case "special" -> valorPremio *= 2;
            default -> System.out.println("Não foi um tipo de premiação correspondente a \"" + tipoPremio + "\"");
        }

        return valorPremio;

    }

    //1.3
    public static int contarNumerosPrimos(int numeroParada){

        int quantidadeNumerosPrimos = 0;

        for (int i = 2; i <= numeroParada; i++){
            if (ePrimo(i)){
                quantidadeNumerosPrimos++;
            }
        }

        return quantidadeNumerosPrimos;

    }

    //Função para verificar se o número analisado é primo ou não
    private static boolean ePrimo(int numero){

        int quantidadeDivisores = 0;
        boolean numeroPrimo = true;

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                if (++quantidadeDivisores > 2) {
                    numeroPrimo = false;
                    break;
                }
            }
        }

        return numeroPrimo;

    }

    //1.4
    public static int calcularVogais(String string){

        int quantidadeVogais = 0;
        char[] vetorCaracteres = string.toLowerCase().toCharArray();

        for (char caractere : vetorCaracteres) {
            if (eVogal(caractere)) {
                quantidadeVogais++;
            }
        }

        return quantidadeVogais;

    }

    private static boolean eVogal(char caractere) {

        boolean vogal = false;

        if (caractere == 'a' || caractere == 'e' || caractere == 'i' || caractere == 'o' || caractere == 'u') {
            vogal = true;
        }

        return vogal;

    }

    //1.5
    public static String calcularValorComDescontoFormatado(String valorInicial, String porcentagemDesconto){

        valorInicial = valorInicial.replace(" ", "").replace(".", "").replace(",", ".").replace("R$", "");
        porcentagemDesconto = porcentagemDesconto.replace("%", "");
        double valorComDesconto = 0;

        if (eNumerico(valorInicial)){
            double valorInicialDouble = Double.parseDouble(valorInicial);
            if (eNumerico(porcentagemDesconto)){
                float porcentagemDescontoFloat = Float.parseFloat(porcentagemDesconto);
                valorComDesconto = (1 - (porcentagemDescontoFloat / 100)) * valorInicialDouble;
            } else {
                System.out.println("Porcentagem de desconto inválida! Por favor, reinicie o programa e tente novamente (Dica: Insira um valor neste formato: \"30%\")");
            }
        } else {
            System.out.println("Valor inicial inválido! Por favor, reinicie o programa e tente novamente (Dica: Insira um valor neste formato: \"R$ 3.000,00\")");
        }

        DecimalFormat df = new DecimalFormat("R$ ###,##0.00");

        return df.format(valorComDesconto);
    }

    //1.6
    public static long calcularDiferencaData(String dataInicial, String dataFinal) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

        Date dataInicio = sdf.parse(dataInicial);
        Date dataFim = sdf.parse(dataFinal);

        return (dataFim.getTime() - dataInicio.getTime()) / (1000 * 60 * 60 * 24);

    }

    //1.7
    public static int[] obterElementosPares (int[] vetorDeInteiros){

        ArrayList<Integer> listaPares = new ArrayList<>();
        int[] vetorPares;

        for (int numero : vetorDeInteiros){
            if (numero % 2 == 0){
                listaPares.add(numero);
            }
        }

        vetorPares = new int[listaPares.size()];

        for (int i = 0; i < vetorPares.length; i++){
            vetorPares[i] = listaPares.get(i);
        }

        return vetorPares;

    }

    //1.8
    public static String[] buscarPessoa (String[] vetorPessoas, String stringDeBusca){

        ArrayList<String> listaPessoasCorrespondentes = new ArrayList<>();
        String[] vetorPessoasCorrespondentes;

        for (String pessoa : vetorPessoas){
            if (pessoa.contains(stringDeBusca)){
                listaPessoasCorrespondentes.add(pessoa);
            }
        }

        vetorPessoasCorrespondentes = new String[listaPessoasCorrespondentes.size()];

        for (int i = 0; i < vetorPessoasCorrespondentes.length; i++){
            vetorPessoasCorrespondentes[i] = listaPessoasCorrespondentes.get(i);
        }

        return vetorPessoasCorrespondentes;

    }

    //Exercício 1.9
    public static int[][] transformarEmMatriz (String sequenciaDeNumeros){

        sequenciaDeNumeros = sequenciaDeNumeros.replace(" ", "").replace(",", "");
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        int[][] matriz = new int[][]{};

        if (eNumerico(sequenciaDeNumeros)){

            char[] vetorSequencia = sequenciaDeNumeros.toCharArray();
            StringBuilder elementoAnalisado = new StringBuilder();

            for (int i = 0; i < vetorSequencia.length; i++){
                if (vetorSequencia[i] == '-'){
                    elementoAnalisado.append(vetorSequencia[i]);
                } else if ((i > 0 && vetorSequencia[i-1] == '-') || Character.isDigit(vetorSequencia[i])){
                    elementoAnalisado.append(vetorSequencia[i]);
                    listaNumeros.add(Integer.parseInt(String.valueOf(elementoAnalisado)));
                    elementoAnalisado = new StringBuilder();
                }
            }

            matriz = new int[listaNumeros.size() / 2][2];
            int k = 0;

            for (int i = 0; i < matriz.length; i++){
                for (int j = 0; j < matriz[i].length; j++, k++){
                    matriz[i][j] = listaNumeros.get(k);
                }
            }

        } else {
            System.out.println("String inválida! Por favor, insira uma string de números separados por vírgula (Ex.: 1,2,3,4,5,6)");
        }

        return matriz;

    }

    //1.10
    public static int[] obterElementosFaltantes(int[] vetorA, int[] vetorB){

        ArrayList<Integer> listaA = new ArrayList<>();
        ArrayList<Integer> listaB = new ArrayList<>();
        int[] vetorResultado;

        for (int elemento : vetorA){
            listaA.add(elemento);
        }

        for (int elemento : vetorB){
            listaB.add(elemento);
        }

        if (listaA.containsAll(listaB) && listaB.containsAll(listaA)){
            listaA.removeAll(listaB);
            vetorResultado = new int[listaA.size()];
        } else if (listaA.containsAll(listaB) && !(listaB.containsAll(listaA))){
            listaA.removeAll(listaB);
            vetorResultado = new int[listaA.size()];
            for (int i = 0; i < vetorResultado.length; i++){
                vetorResultado[i] = listaA.get(i);
            }
        } else if (!(listaA.containsAll(listaB)) && (listaB.containsAll(listaA))){
            listaB.removeAll(listaA);
            vetorResultado = new int[listaB.size()];
            for (int i = 0; i < vetorResultado.length; i++){
                vetorResultado[i] = listaB.get(i);
            }
        } else {

            ArrayList<Integer> auxLista = new ArrayList<>(listaA);

            listaA.removeAll(listaB);
            listaB.removeAll(auxLista);
            listaA.addAll(listaB);
            vetorResultado = new int[listaA.size()];
            for (int i = 0; i < vetorResultado.length; i++){
                vetorResultado[i] = listaA.get(i);
            }
        }

        return vetorResultado;

    }

}
