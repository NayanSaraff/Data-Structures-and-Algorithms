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
class Circular
{
    Node head; int count = 0;

    /*This is the Insertion method which is used to add nodes in the end of circular list
     * Therefore, in this, the exisitng the last node's next is broken and joined to new node
     * and the new node's next is joined back to head
     * Thus maintaining the circularity
     */
    void addNode(int data)
    {
        Node newNode = new Node(data);

        if(head == null) //if the list is empty
        {
            /*When the list is empty, we create the node and link it back to itself */
            head = newNode;
            head.next = head;
            count++;
        }
        else //if the list is not empty
        {
            Node temp = head;
            while(temp.next!=head) ///Most important condition specific only to Circular List as there is no 'null' node
            {
                temp = temp.next;
            }
            temp.next = newNode; //pointing the existing last node to new node
            newNode.next = head; //pointng the new node to head
            count++;
        }
    }

    void Insertion(int data,int pos)
    {
        Node newNode = new Node(data);

        if(pos == 0) //for index 0
        {
            if(head == null) //if list is already empty
        {
            head = newNode;
            head.next = head;
            count++;
        }
        else //if list is not empty
        {

            /*This is for insertion of a node at the beginning of list so as to link  to exisiting first node */
            Node temp = head;
            while(temp.next!=head)
            {
                temp = temp.next;
            }
            /*making linkings and updating the values */
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
            count++;
        }
        return;
        }

        /*Insertion at other random position */
        Node temp = head;
        for(int i=1;i<pos&&temp.next!=head;i++)
        {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        count++;
    }
    void Deletion(int key)
    {
        if(head == null) //if list is not empty, nothing can be deleted
        return;

        Node temp = head,prev = null;;
        while(temp.data!=key) //finding the node with the key data
        {
            if(temp.next == head)
            {System.out.println("Node not found");
            return;}
            prev = temp;
            temp = temp.next;
            count--;
        }
        if(temp == head && temp.next == head) //if there is only one node in the entire list
        {
            head = null;
            count--;
        }
        else if(temp == head) //for deletion of first node
        {
            Node last = head;
            while(last.next!=head)
            {
                last = last.next;
            }
            head = head.next;
            last.next = head;
            count--;
        }
        else  //for any general node
        {
            prev.next = temp.next;
            count--;
        }
    }

/*In circular linked list, it is important to handle the first and last node exclusively as we need to establish a link between
 * these nodes in order to maintain the integrity of CLL.
 */

    int Length()
    {
        return count;
    }
    void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Head)");
    }
}
public class CircularLinkedList {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        Circular circ = new Circular();

        while(true)
        {
            //All menu to show the various functions implemented in this code
            System.out.println("1. Add Node");
            System.out.println("2. Insertion");
            System.out.println("3. Delete node");
            System.out.println("4. Display list");
            System.out.println("5. Length of list");
            System.out.println("-1. Exit");
            System.out.print("Enter choice: ");
            int choice = SC.nextInt();

        switch(choice)
        {
            case 1: System.out.print("Enter node date: ");
                    int data = SC.nextInt();
                    circ.addNode(data);
                    break;
            //-----------------------------------------------------------------
            case 2: System.out.print("Enter index: ");
                    int index = SC.nextInt();

                    if(index <= circ.Length())
                    {
                        System.out.print("Enter node data: ");
                        int first = SC.nextInt();
                        circ.Insertion(index, first);
                    }
                    else
                    System.out.println("Index out of bounds so no insertion");
                    break;
            //-----------------------------------------------------------------
            case 3: System.out.print("Enter data to remove: ");
                    int remove = SC.nextInt();
                    circ.Deletion(remove);
                    break;
            //-----------------------------------------------------------------
            case 4: circ.display();
                    break;
            //-----------------------------------------------------------------
            case 5: System.out.println("Length of list: "+circ.Length());
                    break;
            //-----------------------------------------------------------------
            case -1:SC.close(); 
                    System.exit(0);
            }
        }
    }

    
}
