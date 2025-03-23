import java.util.*;
class Node
{
    int data; Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
class queue
{
    Node head;

    void enqueue(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        head = newNode;

        Node temp = head;
        if(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode; //insertion is done to rear that is tail of linked list
    }
    void dequeue()
    {
        if(head == null)
        {
            System.out.println("Queue is empty");
            return;
        }
        
        head = head.next; //always dequeing from the front that is head in case of linked list and updating the head with the next value
    }

    void display()
    {
        if(head == null)
        {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
public class simple_linked {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        queue obj = new queue();
        while(true)
        {
            System.out.println("\n1) Add element to queue");
            System.out.println("2) Remove element from queue");
            System.out.println("3) Display queue data");
            System.out.println("0 to exit");
            System.out.print("Enter choice: ");
            int choice = SC.nextInt();

            switch (choice) {
                case 1: System.out.print("Enter data to add: ");
                        int data = SC.nextInt();
                        obj.enqueue(data);
                    break;
                case 2: obj.dequeue();
                        break;
                case 3: obj.display();
                    break;
                case 0: SC.close();
                        System.exit(0);
        }
        }
    }
    
}
