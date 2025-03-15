import java.util.*;
/*This Node class creates the Nodes for the Singly Linked List
 * which contains 2 parameters: Data and Pointer for next node*/
class Node
{
    int data; Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
/*This class handles the operations pertaining to Singly Linked List */
class LinkedList
{
    Node head;
    int count = 0;
    /*This method is for adding a new node to the list but this will add node only in the end */
    void addNode(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
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
    /*This is the Insertion at Beginning method to insert node at beginning */
    void insertbeg(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head=newNode;
    }
    /*This is the Insertion at Any Position method to insert node anywhere in the list untill and unless
     * it is not surpassing the length of list*/
    void insertpos(int index,int key)
    {
        Node newNode = new Node(key);
        if(index == 0)
        {
            newNode.next = head;
            head=newNode;
            return;
        }
        Node temp = head;
        for(int i = 1;temp!=null && i<index;i++)
        {
            temp = temp.next;
        }
        if(temp == null)
        {
            System.out.println("Index out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    /*This is the Deletion method to delete any particular node based on the key input */
    void deleteNode(int key)
    {
        if(head == null)
        return;
        if(head.data == key)
        {
            head=head.next;
            count--;
            return;
        }
        Node temp = head;

        while(temp.next!=null && temp.next.data !=key)
        {
            temp = temp.next;
        }
        if(temp.next!=null)
        {
            temp.next = temp.next.next;
        }
        count--;
    }
    /*The function to display the contents of list based on Traversing */
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
    /*This function handles the length of list and return the latest length based on other perfomred operations */
    int Length()
    {
        return count;
    }
    /*This method is used to search for a particular key in the list by Traversing */
    int search(int key)
    {
        int index = 0;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data == key)
            {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }
}
//This is the Main class to invoke the methods and to create objects for linked lists
public class SinglyLinkedList
{
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        LinkedList list = new LinkedList();
        while(true)
        {
            //All menu to show the various functions implemented in this code
        System.out.println("1. Add node");
        System.out.println("2. Delete node");
        System.out.println("3. Display list");
        System.out.println("4. Length of list");
        System.out.println("5. Insertion");
        System.out.println("6. Searching");
        System.out.println("-1. Exit");
        System.out.print("Enter choice: ");
        int choice = SC.nextInt();

        switch(choice)
        {
            //-----------------------------------------------------------------
            case 1: System.out.print("Enter node data: ");
                    int data = SC.nextInt();
                    list.addNode(data);
                    break;
            //-----------------------------------------------------------------
            case 2: System.out.println("Enter data to remove: ");
                    int remove = SC.nextInt();
                    list.deleteNode(remove);
                    break;
            //-----------------------------------------------------------------
            case 3: System.out.println("Details of list");
                    list.display();
                    break;
            //-----------------------------------------------------------------
            case 4: System.out.println("Length of list: "+list.Length());
                    break;
            //-----------------------------------------------------------------
            case 5: System.out.print("Enter index: ");
                    int index = SC.nextInt();

                    if(index <= list.Length()){
                    System.out.print("Enter node data: ");
                    int first = SC.nextInt();
                    list.insertpos(index,first);}
                    else
                    System.out.println("Index out of bounds so no insertion");

                    break;
            //-----------------------------------------------------------------
            case 6: System.out.print("Enter element to search: ");
                    int key = SC.nextInt();

                    int pos = list.search(key);
                    if(pos == -1)
                    System.out.println("Not found");
                    else
                    System.out.println("Element found at position "+pos);

                    break;
            //-----------------------------------------------------------------
            case -1:SC.close(); 
                    System.exit(0);
            }
        }
    }   
}
