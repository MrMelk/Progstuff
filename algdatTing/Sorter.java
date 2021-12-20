import java.util.List;

class Sorter {

    public static void main(String[] args){

    }
    public List<Integer> quick(List A) {
        //End step, return final element in List
        if(A.size < 2) {
            return A;
        }
        List<Integer> lower = new ArrayList<Integer>();
        List<Integer> higher = new ArrayList<Integer>();
        int n = A.size();
        
        int pivot = A.get(n/2 +1);
        int temp;
        for (int i = 0; i < n; i++) {
            temp = A.get(i);
            if (temp < pivot){
                lower.add(temp)
            }
            else {
                higher.add(temp)
            }
        }
        lower.add(pivot);
        lower = quick(lower);
        higher = quick(higher);

        lower =  lower.addAll(higher);
        return lower;
    }
    public List<Integer> heap(List A) {
        return A;
    }
}