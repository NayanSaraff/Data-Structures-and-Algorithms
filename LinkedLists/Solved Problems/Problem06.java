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
class Deletion 
{
    Node head;

    public Node find(Node head, int val)
    {
        while(head!=null && head.next !=null)
        {
            if(head.data == val)
            return head;
            head = head.next;
        }
        return null;
    }

    public void delete(Node pos)
    {
        if(pos == null || pos.next == null)
        return;

        pos.data = pos.next.data;
        pos.next = pos.next.next;
    }

    public void display(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
public class Problem06 {
    public static void main(String[] args) {
        
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter no of elements: ");
        int len = SC.nextInt();

        System.out.println("Enter elements:");
        Node head = new Node(SC.nextInt());
        Node tail = head;

        for(int i=1;i<len;i++)
        {
            tail.next = new Node(SC.nextInt());
            tail = tail.next;
        }

        System.out.print("Enter node value to be deleted: ");
        int val = SC.nextInt();

        Deletion obj = new Deletion();
        
        Node target = obj.find(head,val);

        if(target == null || target.next == null)
        System.out.println("Does not exist");
        else
        {
            obj.delete(target);
            obj.display(head);
        }

    }
    
}
