import java.util.Scanner;

import java.util.Arrays;

public class cetvrta {

/*What I want to do:
I want to be able to put in 3 sets of 2
integers between 1-1000, and find the last
combination which makes a rectangle. f.eks
(5,5)(5,7)(7,5), which then will put out (2,4)
or (7,7)

What ways can we do this?
List of number sets, go through and find
missing combination?
find the difference betweet first input and
second input and third input, then use that
on the third input to find a Point.
*/

    public static void main(String[] args) {
        //int[][] inputPoints = new int[3][2];
        Scanner rawInput = new Scanner(System.in);
        int[] x_vec = new int[3];
        int[] y_vec = new int[3];

        for(int i = 0; i < 3; i++){
            //String line  = rawInput.next();
            
            //inputPoints[i][0] = rawInput.nextInt();//Integer.parseInt(line.split(" ")[0]);
            //inputPoints[i][1] = rawInput.nextInt();//Integer.parseInt(line.split(" ")[1]);
            x_vec[i] = rawInput.nextInt();
            y_vec[i] = rawInput.nextInt();


        }

        int x1count = 0;
        int x2count = 0;
        int y1count = 0;
        int y2count = 0;
        Arrays.sort(x_vec);
        Arrays.sort(y_vec);
        for(int i = 0; i < x_vec.length; i++){
            if(x_vec[i] == x_vec[0]){
                x1count ++;
            }
            else{
                x2count ++;
            }
            if(y_vec[i] == y_vec[0]){
                y1count ++;
            }
            else{
                y2count ++;
            }
        }
        if(x1count > 1){
            System.out.print(x_vec[2] + " ");
        }
        else{
            System.out.print(x_vec[0] + " ");
        }
        if(y1count > 1){
            System.out.println(y_vec[2]);
        }
        else{
            System.out.println(y_vec[0]);
        }

                



        /*
        if(x_vec[0] != x_vec[1] && x_vec[0] != x_vec[2]){
            if(y_vec[1] == y_vec[0]){
                System.out.println(x_vec[0] + " " + y_vec[2]);
            }
            else{
                System.out.println(x_vec[0] + " " + y_vec[1]);
            }
        }
        if(x_vec[1] != x_vec[2]){

        }
        
        if(x_vec[0] != x_vec[1] && x_vec[0] != x_vec[2]){
            if(y_vec[1] != y_vec[2] && y_vec[1] != y_vec[0]){
                System.out.println(x_vec[0] + " " + y_vec[1]);
            }
            else{
                System.out.println(x_vec[0] + " " + y_vec[2]);
            }
        }
        else if(x_vec[1] != x_vec[2] && x_vec[1] != x_vec[0]){
            if(y_vec[0] != y_vec[2] && y_vec[1] != y_vec[0]){
                System.out.println(x_vec[1] + " " + y_vec[0]);
            }
            else{
                System.out.println(x_vec[1] + " " + y_vec[2])
            }
        }
        else{


        }
        */

        //now we add to find difference
        /*int x1x2diff = Math.abs(x_vec[0] - x_vec[1]);
        int y1y2diff = Math.abs(y_vec[0] - y_vec[1]);
        int x2x3diff = Math.abs(x_vec[1] - x_vec[2]);
        int y2y3diff = Math.abs(y_vec[1] - y_vec[2]);

        System.out.println(x1x2diff + " " + y1y2diff);
        System.out.println(x2x3diff + " " + y2y3diff);
        if(x1x2diff > x2x3diff){

        }*/
    }
}
//System.out.println("punkt: " + inputPoints[i][0] + " " + inputPoints[i][1]);