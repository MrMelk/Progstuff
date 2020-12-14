import java.io.BufferedReader;
import java.util.Scanner;
//import jdk.internal.org.jline.utils.InputStreamReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.io.IOException;



//Har sett at balansert soketre er raskere, men ny til java gjor at jeg defaulter til noe jeg kan bedre.
public class Teque {

    private static class Node{
        public int value;
        public Node next;
        public Node prev;
        
    }
    Node front;
    Node rear;
    Node middle;
    int size = 0;
    

    public void push_front(int x){
        if(front == null){
            Node temp = new Node();
            temp.value = x;
            front = temp;
            middle = temp;
            rear = temp;
            size = 1; //*
        }
        else{
            Node temp = new Node();
            temp.value = x;
            temp.prev = null;
            temp.next = front;
            front.prev = temp;
            front = temp;
            size++;

            if(size % 2 != 0 && size != 2){
                middle = middle.prev;
            }
        }
    

    }

    public void push_middle(int x){
        Node temp = new Node();
        temp.value = x;
        if(middle == null){
            push_front(x);
            return;
        }
        else{
            if(size == 1){
                temp.prev  = front;
                front.next = temp;
                middle = temp;
                rear = temp;
            }
            else{

            
                if(size == 2){
                    temp.prev = front;
                    temp.next = rear;
                    front.next = temp;
                    rear.prev = temp;
                    middle = temp;
                }
                else{
                    if(size % 2 == 0){
                        temp.next = middle;
                        temp.prev = middle.prev;
                        middle.prev.next = temp;
                        middle.prev = temp;
                        middle = temp;
                    }
                    else{
                        temp.prev = middle;
                        temp.next = middle.next;
                        middle.next.prev = temp;
                        middle.next = temp;
                        middle = temp;
                    }
                }
            }
        
        }

        
        size++;
    }

    public void push_back(int x){
        if(rear == null){
            push_front(x);
        }
        else{
            Node temp = new Node();
            temp.value = x;
            temp.prev = rear;
            rear.next = temp;
            rear = temp;
            size++;
            if(size % 2 == 0){
                middle = middle.next;
            }
            
        }
    }
    //for bugtesting
    public int getsize(){
        return size;
    }
    //for bugtesting
    public void printq() {
        Node pront = front;
        while(pront != null){
            System.out.print("|" + pront.value);
            pront = pront.next;
        }
        System.out.println("|");
    }
    public void get(int i){
        //Siden effektivitet ikke har noe aa si gjor jeg dette mindre effektivt. Mister litt grunnen til at Tequeue er bra men
        //det faar gaa. Hvis jeg faar tid gjor jeg dette til et soketre istedenfor linked list og implementerer en raskere get(i)
        Node index = new Node();
        index = front;
        for(int k = 0; k < i; k++){
            index = index.next;
            
        }
        System.out.println(index.value);
        
    }

    public static void main(String[] args) throws IOException{
        //for å teste hvor fort ting blir gjort
        //long start = System.nanoTime();
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        Teque letsgo = new Teque();
        for(int i = 0; i < N; i++){
            String[] line = input.readLine().split(" ");
            String cmd = line[0];
            int n = Integer.parseInt(line[1]);
            switch(cmd){
                case "push_front":
                    letsgo.push_front(n);
                    break;
                case "push_back":
                    letsgo.push_back(n);
                    break;
                case "get":
                    letsgo.get(n);
                    break;
                case "push_middle":
                    letsgo.push_middle(n);
                    break;
                //for bugtesting
                case "print":
                    letsgo.printq();
                    break;
                case "ps":
                    System.out.println(letsgo.size);
                    break;
            }
        }
        //for å teste hvor fort ting ble gjort
        //long end = System.nanoTime();
        //System.out.println("time: " + (end - start)/(Math.pow(10, 9)) + " s");
    }
}