
class Selection extends Sorter {
    
    void sort(){
        selectionSort(A);
    }

    void selectionSort(int[] A){
        for(int i = 0; i < n; i++){
            int k = i;
            for(int j = i + 1; j < n; j++){
                if(lt(A[j], A[k])){
                    k = j;
                }
            }
            if(i != k){
                swap(i, k);
            }
        }
    }

    String algorithmName() {
        return "selection";
    }
}
