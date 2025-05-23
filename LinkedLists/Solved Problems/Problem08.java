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

class SWAP
{
    public static void swap(Node head)
    {
        Node curr = head;

        if(head == null || head.next == null) return;

        while(curr!=null)
        {
            int temp = curr.next.data;
            curr.next.data = curr.data;
            curr.data = temp;

            curr = curr.next.next;
        }

        while(head!=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
public class Problem08 {
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
        SWAP.swap(head);
    }
}
