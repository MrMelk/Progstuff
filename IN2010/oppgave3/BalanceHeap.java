import java.util.PriorityQueue;

public class BalanceHeap {


    public void pqueuesort(PriorityQueue<Integer> uspqueue){
        int n = uspqueue.size()/2;
        if(n == 0){
            return;
        }
        PriorityQueue<Integer> rightbranch = new PriorityQueue<Integer>();
        PriorityQueue<Integer> leftbranch = new PriorityQueue<Integer>();
        for(int i = 0; i < n; i++){
            leftbranch.offer(uspqueue.poll());
        }
        System.out.println(uspqueue.poll());
        int newN = uspqueue.size();
        for(int i = 0; i < newN; i++){
            rightbranch.offer(uspqueue.poll());
        }
        pqueuesort(rightbranch);
        pqueuesort(leftbranch);
        int rn = rightbranch.size();
        for(int i = 0; i < rn; i++){
            System.out.println(rightbranch.poll());
        }
        int ln = leftbranch.size();
        for(int i = 0; i < ln; i++){
            System.out.println(leftbranch.poll());
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();

        for(int i = 0; i < 11; i++){
            pqueue.offer(i);
        }
        BalanceHeap test = new BalanceHeap();
        test.pqueuesort(pqueue);

    }    
}
