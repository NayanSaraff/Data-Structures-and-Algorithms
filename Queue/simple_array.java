import java.util.*;
public class simple_array
{
    int front = -1, rear = -1; //defining the two queue keywords and initializing them -1
/*-1 is just so as to start the insertion deletion from actual array index 0 upto array length-1 */

    //method to insert elements in the rear
    void enqueue(int size, int arr[], int data)
    {
        if(rear == size-1) //when the queue is full
        {
            System.out.println("Cannot add more elements!!");
            return;
        }
        if(front == -1) //changing the front from -1 to 0 so as to perform future dequeues
        front = 0;

        arr[++rear] = data; //incrementing rear
        System.out.println("Data addedd successfully");
    }

    //method to delete element from front
/*We start deleting element from 0th index of array as it works on FIFO and since element at 0th index was added first so it will be removed */
    void dequeue(int size, int arr[])
    {
        if(front == -1 || front > rear)//initial condition when the queue was first created
        {
            System.out.println("Queue is empty");
            return;
        }

        front++; //move the front from 0th index to subsequent indices

        if(front > rear) 
        {
            /*this condition of if works when there were element previously but now its empty but the front value is still greater
             * so we have to reset both front and rear to the starting initial conditions
             */
            front = -1;
            rear = -1;
        }
        System.out.println("Element dequeued successfully");
    }

    void display(int size, int arr[])
    {
        if (front == -1 || front>rear)
        {
            System.out.println("Queue is empty");
            return;
        }

        for(int i=front;i<=rear;i++) //we loop upto rear and not size of array as otherwise it might result in garbage printing if all the places are not used
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter size of queue: ");
        int size = SC.nextInt();

        int arr[] = new int[size]; //the array which will behave as a queue

        simple_array obj = new simple_array();
        
        while(true)
        {
            System.out.println("\n1) Add element to queue");
            System.out.println("2) Remove element from queue");
            System.out.println("3) Display queue data");
            System.out.println("0 to exit");
            System.out.print("Enter choice: ");
            int choice = SC.nextInt();

            switch (choice) {
                case 1: System.out.print("Enter data to add: ");
                        int data = SC.nextInt();
                        obj.enqueue(size, arr, data);
                    break;
                case 2: obj.dequeue(size, arr);
                        break;
                case 3: obj.display(size, arr);
                    break;
                case 0: SC.close();
                        System.exit(0);
        }
        }
    }
}