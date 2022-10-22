package Com.bridgelab.day14_LinkedList;
import java.util.*;
public class LinkedList{
    Node head;

    class Node {
        Object data;
        Node ref;

        Node(Object data) {
            this.data = data;
        }
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.ref = head;
        head = newNode;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        Node temp = head;
        if (head == null)
            head = newNode;
//		else if(head.ref == null)
//			head.ref = newNode;
        else {
            while (temp.ref != null) {
                temp = temp.ref;
            }
            temp.ref = newNode;
        }
    }

    public void addAtPosition(Object data, int position) {
        int index = 0;
        Node newNode = new Node(data);
        Node left = head;
        Node right = left.ref;

        /*
         * position-1 is used because the value of index will be incremented and stops
         * before the position at which user wants to add the node
         */
        while (index < (position - 1)) {

            left = left.ref;
            right = right.ref;
            index++;
        }
        /*
         * if we do index < position is used because the value of index will be
         * incremented and will point to the index user has entered and the new element
         * will be added after the entered position
         */
        newNode.ref = right;
        left.ref = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            if (temp.ref != null)
                System.out.print(temp.data + " > ");
            else
                System.out.println(temp.data);
            temp = temp.ref;
        }

    }

    public void deleteFirst() {
        head = head.ref;
    }

    public void deleteLast() {

        if (head == null)
            System.out.println("Linked List is Empty");
        else if (head.ref == null)
            head = null;
        else {
            Node temp = head;
            while (temp.ref.ref != null) {
                temp = temp.ref;
            }
            temp.ref = null;
        }
    }

    public Object searchElement(Object input) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            index++;
            if (temp.data == input) {
                String res = temp.data + " found at index " + index;
                return res;
            }
            temp = temp.ref;
        }
        return null;
    }

    public void insertElement(Object input , Object value)
    {
        Node newNode = new Node(value);
        Node temp = head;

        int index = 0;
        while(temp.data != input)
        {
            index++;
            temp = temp.ref;
        }
        Node left = head;
        Node right = left.ref;
        int index1 =0;
        while(index1 < index)
        {
            index1++;
            left = left.ref;
            right = right.ref;
        }
        newNode.ref = right;
        left.ref = newNode;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Welcome to LinkedList program");
        Scanner sc = new Scanner(System.in);
        list.addFirst(56);
        list.display();
        list.addLast(70);
        list.display();
        // System.out.println("Enter position after which you want to add node: ");
        System.out.println("Enter position at which you want to add node: ");
        int position = sc.nextInt();
        list.addAtPosition(30, position);
        list.display();
        System.out.println("Enter element to search in linked list: ");
        int input = sc.nextInt();
        System.out.println(list.searchElement(input));
        System.out.println("Enter element after which you want to add: ");
        int element = sc.nextInt();
        System.out.println("Enter value to add: ");
        int value = sc.nextInt();
        list.insertElement(element,value);
        list.display();
    }
}
