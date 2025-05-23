import java.util.*;
class Node
{
    Node next;
    int data;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class Merge
{
    public static Node insert(Node head1, Node head2)
    {
        Node c1 = head1;
        Node c2 = head2;

        Node h1,h2;

        while(c1!=null && c2!=null)
        {
            h1 = c1.next;
            h2 = c2.next;


            c1.next = c2;
            c2.next = h1;

            c1 = h1;
            c2 = h2;
        }

        return c2;
    }
    public static void print(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

}
public class Problem04 {
    public static void main(String[] args) {

        Scanner SC = new Scanner(System.in);

        System.out.print("Enter no of element in first list: ");
        int n1 = SC.nextInt();
        System.out.print("Enter second: ");
        int n2 = SC.nextInt();



        System.out.println("Enter elements of first list");
        int h1 = SC.nextInt();


        Node head1 = new Node(h1);
        Node tail1 = head1;
        for (int i=1;i<n1;i++)
        {
            tail1.next = new Node(SC.nextInt());
            tail1 = tail1.next;
        }

        System.out.println("Enter elements of second list");
        int h2 = SC.nextInt();

        Node head2 = new Node(h2);
        Node tail2 = head2;
        for (int i=1;i<n2;i++)
        {
            tail2.next = new Node(SC.nextInt());
            tail2 = tail2.next;
        }


        Merge obj = new Merge();
        obj.insert(head1,head2);
        obj.print(head1);
    }
    
}
