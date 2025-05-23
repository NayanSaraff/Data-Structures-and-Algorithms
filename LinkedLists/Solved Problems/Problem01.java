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

    int middle()
    {
        Node temp = head;
        int index = Length();
        for(int i=0;temp!=null && i<(index/2);i++)
            {
                temp = temp.next;
            }
            return temp.data;
    }

}
public class Problem01
{
    public static void main(String[] args) {

        Scanner SC = new Scanner(System.in);
        Middle mid = new Middle();
        while(true)
        {
            System.out.println("1 for push: ");
            System.out.println("2 to find middle");
            int choice = SC.nextInt();

            switch(choice)
            {
                case 1: mid.push(SC.nextInt());
                    break;
                case 2: System.out.println("Middle element is: "+mid.middle());
                break;
                default: System.exit(0);
            }
        }
    }
}