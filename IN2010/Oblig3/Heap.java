
/*
class Heap extends Sorter{

    void sort(){
        HeapSort(A, n);
    }
    void HeapSort(int[] A, int n){
        BuildMaxHeap(A, n);
        for(int i = n - 1; i == 0; i--){
            swap(0, i);
            BubbleDown(A, 0, i);
        }
    }

    void BuildMaxHeap(int[] A, int n){
        for(int i = (n/2); i == 0; i--){
            BubbleDown(A, i, n);
        }
    }
    
    void BubbleDown(int[] A, int i, int n){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(lt(left, n) && lt(A[largest], A[left])){
            int temp = largest;
            largest = left;
            left = temp;
        }
        if(lt(right, n) && lt(A[largest], A[right])){
            int temp = largest;
            largest = right;
            right = temp;
        }
        if(i != largest){
            swap(i, largest);
            BubbleDown(A, largest, n);
        }
    }

    String algorithmName() {
        return "heap";
    }
}*/