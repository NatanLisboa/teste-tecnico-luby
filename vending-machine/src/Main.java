import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Produto p1 = new Produto("Coca-Cola", 4.50, 10);
        Produto p2 = new Produto("Pepsi", 3.50, 15);
        Produto p3 = new Produto("Coca-cola Zero", 4.50, 20);
        Produto p4 = new Produto("Fanta Laranja", 3.50, 20);
        Produto p5 = new Produto("Fanta Uva", 3.50, 20);
        Produto p6 = new Produto("Sukita", 3, 20);
        Produto p7 = new Produto("Fanta Guaraná", 3.50, 15);
        Produto p8 = new Produto("Guaraná Antarctica", 4.50, 10);
        Produto p9 = new Produto("Guaraná Kuat", 4, 15)

        System.out.println("-------------------Vending Machine------------------");
        System.out.println("1 - Coca-cola");
        System.out.println("2 - Pepsi");
        System.out.println("3 - Coca-cola Zero");
        System.out.println("4 - Fanta Laranja");
        System.out.println("5 - Fanta Uva");
        System.out.println("6 - Sukita");
        System.out.println("7 - Fanta Guaraná");
        System.out.println("8 - Guaraná Antarctica");
        System.out.println("9 - Guaraná Kuat");

        System.out.println("Selecione sua bebida (1 a 9): ");

        char escolha = sc.next().charAt(0);

    }

}
