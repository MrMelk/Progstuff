import java.util.Scanner;
import java.util.Arrays;

public class Bijele {

    


    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] currentPieces = new int[6];
    String lst = input.nextLine();
    String[] lstarray = lst.split(" ");
    int[] neededPieces = new int[6];
    String bull = "1 1 2 2 2 8";
    String[] shit = bull.split(" ");

    for(int i = 0; i < 6; i++){
        currentPieces[i] = Integer.parseInt(lstarray[i]);
        neededPieces[i] = Integer.parseInt(shit[i]) - currentPieces[i];
        System.out.print(neededPieces[i] + " ");

    }




    }
}