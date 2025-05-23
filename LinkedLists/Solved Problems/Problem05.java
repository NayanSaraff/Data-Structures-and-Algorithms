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
class NodeDeletion
{
    Node head;
    int m,n;

    int count=0;
    NodeDeletion(int m, int n)
    {
        this.m = m;
        this.n = n;
    }

    public void display(Node head)
    {
        Node curr = head;

        while(curr != null)
        {
            for(int i=1;i<m;i++)
            {
                curr = curr.next;
            }

            if(curr == null || curr.next == null) break;

            Node temp = curr.next;

            for(int i=1;i<=n;i++)
            {
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }

        System.out.println("After skipping the new list....");
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
public class Problem05 {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter no of elements: ");
        int len = SC.nextInt();

        System.out.print("Enter skip: ");
        int m = SC.nextInt();
        System.out.print("Enter delete: ");
        int n = SC.nextInt();

        NodeDeletion obj = new NodeDeletion(m, n);

        System.out.println("Enter elements:");
        Node head = new Node(SC.nextInt());
        Node tail = head;

        for(int i=1;i<len;i++)
        {
            tail.next = new Node(SC.nextInt());
            tail = tail.next;
        }

        obj.display(head);
    }
}
