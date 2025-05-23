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
class SORTING
{
    //APPROACH 1 BY USING THREE POINTER APPROACH 

    public static void Sort(Node head)
    {
        Node One = new Node(-1);
        Node Two = new Node(-1);
        Node Zero = new Node(-1);

        Node one = One;
        Node two = Two;
        Node zero = Zero;

        Node curr = head;

        while(curr!=null)
        {
            if(curr.data == 0)
            {
                zero.next = curr;
                zero = zero.next;
            }
            else if(curr.data == 1)
            {
                one.next = curr;
                one = one.next;
            }
            else
            {
                two.next = curr;
                two = two.next;
            }

            curr = curr.next;
        }

        zero.next = (One.next!=null)?One.next:Two.next;
        one.next = Two.next;
        two.next = null;

        head = Zero.next;
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    //APPROACH 2 OVERWRITING THE EXISTING LIST WITH SORTED 0 1 2

    //int count0,count1,count2 = 0;

    /*public void Count(Node head)
    {
        while(head!=null)
        {
            if(head.data == 0)
            count0++;
            else if(head.data == 1)
            count1++;
            else
            count2++;

            head = head.next;
        }
    }*/

    /*public void Sort(Node head)
    {
        for(int i=1;i<=count0;i++)
        {
            head.data = 0;
            head = head.next;
        }
        for(int i=1;i<=count1;i++)
        {
            head.data = 1;
            head = head.next;
        }
        for(int i=1;i<=count2;i++)
        {
            head.data = 2;
            head = head.next;
        }
    }
    public void display(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }*/

    //APPROACH 3 DIRECTLY PRINTING 0 1 2 SORTED BASED ON THEIR FREQUENCY

    /*public void display()
    {
        for(int i=1;i<=count0;i++)
        {
            System.out.print("0");
        }
        for(int i=1;i<=count1;i++)
        {
            System.out.print("1");
        }
        for(int i=1;i<=count2;i++)
        {
            System.out.print("2");
        }
    }*/
    
}
public class Problem07 {
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

        SORTING obj = new SORTING();

        // obj.Count(head);    APPROACH 2
        // obj.Sort(head);     APPROACH 2
        // obj.display(head);  APPROACH 3
        SORTING.Sort(head);
    }
    
}
