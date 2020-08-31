import java.util.Scanner;



class helloworld{

    public static void main(String[] args) {
        System.out.print("Ka farsken hete du? ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hallo " + name );

    }
}
