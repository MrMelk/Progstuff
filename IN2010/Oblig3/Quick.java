class Quick extends Sorter{
    void sort(){
        qSort(A, 0, n - 1);
    }
    int[] qSort(int[] A, int low, int high){
        if(geq(low, high)){
            return A;
        }
        int p = Partition(A, low, high);
        qSort(A, low, p - 1);
        qSort(A, p + 1, high);
        return A;
    }
    int Partition(int[] A, int low, int high){
        int p = (low + high)/2;
        swap(p, high);
        int pivot = A[high];
        int left = low;
        int right = high - 1;

        while(leq(left, right)){
            while(leq(left, right) && leq(A[left], pivot)){
                left += 1;
            }
            while(geq(right, left) && geq(A[right], pivot)){
                right -= 1;
            }
            if(lt(left, right)){
                swap(left, right);
            }
        }
        swap(left, high);

        return left;
    }
    
    String algorithmName() {
        return "quick";
    }
}
