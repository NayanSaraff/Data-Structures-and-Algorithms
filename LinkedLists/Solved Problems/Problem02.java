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
class Middle
{
    Node head; int count = 0;
    void push(int data)
    {
        Node newNode = new Node(data);
        if(head == null){
        head = newNode;
        count++;
        return;
        }
        Node temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        count++;
    }
    int Length()
    {
        return count;
    }

    void rotate(int k)
    {
        for(int i=1;i<=k;i++)
        {
            Node temp = head;
            for(int j=1;j<Length()-k;j++)
            {
                temp = temp.next;
            }
            Node newHead = temp.next;
            head = temp.next.next;
            temp.next = null;
            
            // Node last = newHead;
            // while(last.next!=null);
            // {
            //     last = last.next;
            // }
            // last.next = head;
            // head = newHead;
        }
    }
    void display()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

}
public class Problem02
{
    public static void main(String[] args) {

        Scanner SC = new Scanner(System.in);
        Middle mid = new Middle();
        while(true)
        {
            System.out.println("1 for push: ");
            System.out.println("2 to rotate");
            System.out.println("3 to display");
            int choice = SC.nextInt();

            switch(choice)
            {
                case 1: mid.push(SC.nextInt());
                    break;
                case 2: System.out.print("Enter k: ");
                        int k = SC.nextInt();
                        mid.rotate(k);
                        System.out.println("List rotated by k places....");
                break;
                case 3: mid.display();
                break;
                default: System.exit(0);
            }
        }
    }
}