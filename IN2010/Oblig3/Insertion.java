

class Insertion extends Sorter{
    void sort(){
        //int n = input.length;
        for(int i = 1; i < n; i++){
            int j= i;
            while(gt(j, 0) && gt(A[j - 1], A[j])){
                swap(j, j - 1);
                j -= 1;
            }
        }
    }
    String algorithmName() {
        return "insertion";
    }
}
/*
public class Insertion {
    public static int[] Sort(int[] input){//ArrayList<Integer> iSort(ArrayList<Integer> input){

        int n = input.length;
        for(int i = 1; i < n; i++){
            int j= i;
            while(j > 0 && input[j - 1] > input[j]){
                int tempJmin1 = input[j - 1];
                int tempJ = input[j];
                input[j] = tempJmin1;
                input[j - 1] = tempJ;
                j -= 1;
            }
        }
        return input;
    }
    public static void toFile(int[] A, String filename){

    }
}*/
