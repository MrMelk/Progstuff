import java.io.BufferedReader;
import java.util.Scanner;
//import jdk.internal.org.jline.utils.InputStreamReader;
import java.io.InputStreamReader;
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
            size = 0;
            front = temp;
            //front.next = null;
            //front.prev = null;
            middle = temp;
            //middle.prev = null;
            //middle.next = null;
            rear = temp;
            //rear.next = null;
            //rear.prev = null;
            size++;
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
                //System.out.println("feilen er i pushfront");
            }
        }
    

    }

    public void push_middle(int x){
        Node temp = new Node();
        temp.value = x;
        if(size == 2){
            temp.prev = front;
            temp.next = rear;
            front.next = temp;
            rear.prev = temp;
            middle = temp;
        }
        else{
            if(size % 2 == 0){
                temp.prev = middle;
                temp.next = middle.next;
                middle.next.prev = temp;
                middle.next = temp;
                middle = temp;
            }
            else{
                temp.next = middle;
                temp.prev = middle.prev;
                middle.prev.next = temp;
                middle.prev = temp;
                middle = temp;
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
            temp.next = null;
            temp.prev = rear;
            rear.next = temp;
            rear = temp;
            size++;
            /*if(size == 3){
                middle = front.next;
            }
            else{
                if(size % 2 == 0){
                    middle = middle.next;
                }
            }*/
            if(size % 2 == 0){
                middle = middle.next;
            }
            
        }
    }
    public int getsize(){
        return size;
    }
    public void printq() {
        Node pront = front;
        while(pront.next != null){
            System.out.print("|" + pront.value);
            pront = pront.next;
        }
        System.out.println("|" + pront.value + "|");
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
        /*Scanner input = new Scanner(System.in);
        int opnum = input.nextInt();
        Teque letsgo = new Teque();
        for(int i = 0; i < opnum; i++){
            String command = input.next();
            letsgo.command(input.nextInt());
        }*/
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
            }
            //letsgo.cmd(x);
            //letsgo.command(input.nextInt());
        }
        /*
        Teque test = new Teque();
        test.push_front(2);
        System.out.println("size: " + test.getsize() + " values: " + test.front.value + " " + test.middle.value + " " + test.rear.value);
        //test.push_front(8);
        System.out.println(test.front.value + " ");// + test.front.next.value + " " + test.middle.value + " " + test.rear.value);
        test.push_back(3);
        System.out.println(test.front.value + " " + test.front.next.value + " " + test.middle.value + " " + test.rear.value);
        System.out.println("middle: " + test.middle.value);
        test.push_middle(70);
        System.out.println("middle: " + test.middle.value + " Size: " + test.getsize());
        test.push_front(40);
        test.printq();
        System.out.println("middle: " + test.middle.value);
        test.push_front(9000);
        System.out.println("middle: " + test.middle.value);
        System.out.println(test.front.value + " " + test.middle.value + " " + test.rear.value);
        System.out.println("size: " + test.getsize());
        test.printq();
        System.out.println(test.get(0));*/

    }
}