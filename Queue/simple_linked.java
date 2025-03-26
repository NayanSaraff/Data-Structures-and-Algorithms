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
    Node front,rear;

    void enqueue(int data)
    {
        Node newNode = new Node(data);
        if(front == null)
        {
            front = rear = newNode; //pointing both the the front and rear to same node
            return;
        }

        rear.next = newNode;
        rear = newNode;
         //insertion is done to rear that is tail of linked list
    }
    void dequeue()
    {
        if(front == null)
        {
            System.out.println("Queue is empty");
            return;
        }
        
        front = front.next; //always dequeing from the front that is head in case of linked list and updating the head with the next value

        if(front == null)
        rear = null;
    }

    void display()
    {
        if(front == null)
        {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
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
