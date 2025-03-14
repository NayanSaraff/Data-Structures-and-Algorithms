import java.util.*;
/*This class is used to create nodes of the list with 2 pointers
 * One pointing to next element another pointing to previous element*/
class Node
{
    int data; Node prev,next;
    Node(int data)
    {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

/*This class handles the operations performed in a doubly linked list */
class Doubly
{
    Node head;//First node
    int count = 0;

    void addNode(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            count++;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        count++;
    }

    /*This method is called Insertion which is used to insert a new node at 
     * beginning , end or at any position */
    void insertion(int index,int data)
    {
        Node newNode = new Node(data); //This line is used for creating a new node with data as its info and 2 pointers prev and next

        /*This condition is to insert a new node in the beginning */
        if(index == 0)
        {
            if(head != null)
            {
                newNode.next = head; //Pointing the new node's next pointer to existing head so as to make it second node
                head.prev = newNode; //Pointing the head back to new node
            }
            head = newNode; //inserting the newnode data to head 
            count++;
            return;

            /*It is essential to link a newnode and its neighbouring nodes so as to create a doubly link */
        }
        Node temp = head; //temporary variable to store list elements
        for(int i=1;temp!=null && i<index;i++)
        {
            /*traversing the lopp until index-1 so as to get the node just before the index node */
            temp = temp.next; //changing the node values
        }
        newNode.next = temp.next; //linking the new node to node value at index+1
        newNode.prev = temp; //linking the new node to previous node

        if(temp.next != null)
        {
            temp.next.prev = newNode;//linking the node after the newnode to itself.
        }
        temp.next = newNode;//linking the previous node to new Node
        count++;
    }

    /*This method is called Deletion which is used to delete a new node at 
     * beginning , end or at any position */
    void deletion(int key)
    {
        if(head == null) //empty list
        return;

        Node temp = head;
        if(temp.data == key) //finding the key at 0 index
        {
            head = temp.next; //shifting of pointers
            if(head != null)
            {
                head.prev = null; //pointing the new node's previous to null
            }
            count--;
            return;
        }
        while(temp!=null && temp.data != key) //finding the node with key value
        {
            temp = temp.next;
        }
        if(temp == null) //if no key found return as it is
        return;

        /*the next two conditions are for linking the nodes which are before and after the deleted node in order to
         maintain the flow of doubly linked list*/
    
        if(temp.next!=null)
        {
            temp.next.prev = temp.prev;
        }
        if(temp.prev!=null)
        {
            temp.prev.next = temp.next;
        }
        count--;
    }

    /*Displays the linked list in normal order */
    void displayForward()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp = temp.next; //update the temp
        }
        System.out.println("NULL");
    }

    /*Displays the linked list in reverse order */
    //Note: This is easier in DoublyLinkedList due to its 2 pointer format otherwise in SinglyLinkedList we will have to create manually 2 pointer
    void displayBackward()
    {
        if(head == null)
        return;

        Node temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        while(temp!=null)
        {
            System.out.print(temp.data+" <- ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
    /*This method finds the updated length of list for every insertion or deletion */
    int Length()
    {
        return count;
    }
}
public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        Doubly dbl = new Doubly();

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
                    dbl.addNode(data);
                    break;
            //-----------------------------------------------------------------
            case 2: System.out.print("Enter index: ");
                    int index = SC.nextInt();

                    if(index <= dbl.Length())
                    {
                        System.out.print("Enter node data: ");
                        int first = SC.nextInt();
                        dbl.insertion(index, first);
                    }
                    else
                    System.out.println("Index out of bounds so no insertion");
                    break;
            //-----------------------------------------------------------------
            case 3: System.out.print("Enter data to remove: ");
                    int remove = SC.nextInt();
                    dbl.deletion(remove);
                    break;
            //-----------------------------------------------------------------
            case 4: System.out.println("Press f for forward list");
                    System.out.println("Press b for backward list");
                    System.out.print("Enter choice: ");
                    char ch = SC.next().charAt(0);

                    switch(ch)
                    {
                        case 'f': dbl.displayForward();
                                break;
                        case 'b': dbl.displayBackward();
                                break;
                    }
                    break;
            //-----------------------------------------------------------------
            case 5: System.out.println("Length of list: "+dbl.Length());
                    break;
            //-----------------------------------------------------------------
            case -1:SC.close(); 
                    System.exit(0);
            }
        }
    }
    
}
