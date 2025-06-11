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
class last
{
    public static Node occurence(Node head,int target)
    {
        Node temp = null;
        Node prev = null;
        Node track = null;
        Node curr = head;
        while(curr!=null)
        {
            if(curr.data == target)
            {
                temp = curr;
                prev = track;
            }
            track = curr;
            curr = curr.next;
        }

        if(temp == null)
        return head;

        if(prev == null)
        head = head.next;
        else
        prev.next = temp.next;

        return head;
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
public class Problem09 {
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

        head = last.occurence(head, key);
        last.display(head);
    }
    
}
