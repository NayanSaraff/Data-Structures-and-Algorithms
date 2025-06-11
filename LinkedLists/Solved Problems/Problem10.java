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
class Reverse
{
    public static Node rev(Node head,int key)
    {
        Node prevTail = null;
        Node curr = head;
        Node new_head = null;
        Node node = null;

        while(curr!=null)
        {
            Node groupHead = curr;
            Node prev = null;
            for(int i=1;i<=key&&curr!=null;i++)
            {
                node = curr.next;
                curr.next = prev;
                prev = curr;
                curr = node;
            }
            if(new_head == null)
            {
                new_head = prev;
            }
             if (prevTail != null) 
             {
                prevTail.next = prev;
            }
                prevTail = groupHead;
        }
        return new_head;
    }
    public static void display(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
public class Problem10 {
    public static void main(String[] args) {
        
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter no of elements: ");
        int len = SC.nextInt();

        System.out.print("Enter elements:");
        Node head = new Node(SC.nextInt());
        Node tail = head;

        for(int i=1;i<len;i++)
        {
            tail.next = new Node(SC.nextInt());
            tail = tail.next;
        }

        System.out.print("Enter key: ");
        int key = SC.nextInt();

        head = Reverse.rev(head, key);
        Reverse.display(head);
    }
}
