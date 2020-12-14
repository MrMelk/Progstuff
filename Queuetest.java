


//Following a youtube vid
public class Queuetest {
    int queue[] = new int[5];
    int size;
    int front;
    int rear;

    public void enQueue(int data){
        if(!isFull()){
            queue[rear] = data;
            rear = (rear + 1) % 5;
            size = size + 1;
        }
        else{
            System.out.println("The queue is full");
        }
    }
    public void show(){
        System.out.print("Elements: ");
        for(int i = 0; i < size; i++){
            System.out.print(queue[(front + i) % 5] + " ");
        }
        System.out.println();
        for(int n: queue){
            System.out.print(n);
        }
    }
    public int deQueue(){
        int data = queue[front];
        if(isFull()){
            front = (front + 1) % 5;
            size = size - 1;

    
        }
        else{
            System.out.println("The queue is empty");
        }
        return data;
    }
    public int getSize(){
        return size;
    }
    public Boolean isEmpty(){
        return getSize() == 0;
    }

    public Boolean isFull(){
        return getSize() == 5;

    }
    public static void main(String[] args) {
        Queuetest q = new Queuetest();
        //q.enQueue(5);
        //q.enQueue(2);
        //q.enQueue(7);
        //q.enQueue(3);

        //q.deQueue();
        q.deQueue();

        //q.enQueue(9);
        //q.enQueue(1);

        System.out.println("Empty? " + q.isEmpty());
        System.out.println("Full? " + q.isFull());

        System.out.println("Size = " + q.getSize());
        q.show();
    }
}
