

class Merge extends Sorter{

    void sort(){
        mergeSort(A);
    }


    int[] mergeSort(int[] A){
        if(leq(A.length, 1)){
            return A;
        }
        int i  = A.length/2;
        int[] A1 = new int[i];
        int[] A2 = new int[A.length - i];
        for(int j = 0; j < i; j++){
            A1[j] = A[j];
        }
        for(int j = 0; j < A2.length; j++){
            A2[j] = A[j + i];
        }
        

        A1 = mergeSort(A1);
        A2 = mergeSort(A2);
        return merge(A1, A2, A);
    }

    int[] merge(int[] A1, int[] A2, int[] A){
        int i = 0;
        int j = 0;

        while(lt(i, A1.length) && lt(j, A2.length)){
            if(A1[i] < A2[j]){
                A[i+j] = A1[i];
                i += 1;
            }
            else{
                A[i+j] = A2[j];
                j += 1;
            }
        }

        while(lt(i, A1.length)){
            A[i+j] = A1[i];
                i += 1;
        }

        while(lt(j, A2.length)){
            A[i+j] = A2[j];
                j += 1;
        }

        return A;
    }



    String algorithmName() {
        return "merge";
    }
}
