
public class TreeTest{

    public static class Node{
        int value;
        Node left;
        Node right;

    }

    Node head;

    public void add(int x){
        //Node temp = new Node();
        temp.value = x;

    }

    public static void main(String[] args) {
        TreeTest tree = new TreeTest();
        tree.head = new Node();
        tree.head.value = 20;
        Node bs = new Node();
        bs.value = 37;
        tree.head.left = bs; 
        System.out.println(tree.head.value + " " + tree.head.left.value);
    }
}

