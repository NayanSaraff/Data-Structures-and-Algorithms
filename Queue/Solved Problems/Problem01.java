import java.util.*;
class REVERSE
{
    //Method 1: Using Stack
    public void reverse(Queue<Integer> qt, int k)
    {
        if(qt == null || k < 0 || k > qt.size())
        return;

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<k;i++)
        {
            st.push(qt.poll());
        }
        while(!st.isEmpty())
        {
            qt.offer(st.pop());
        }
        int remaining = qt.size()-k;

        for(int i=0;i<remaining;i++)
        {
            qt.offer(qt.poll());
        }
    }

    /*
    Method 2 - Using Recursion


    public void reversefirstrecursive(Queue<Integer> qt, int k)
    {
        if(k<=0 || qt.isEmpty())
        return;

        int front = qt.poll();

        reversefirstrecursive(qt, k-1);
        qt.offer(front);
    }

    public void reverseKelements(Queue<Integer> qt, int k)
    {
        int n = qt.size();

        reversefirstrecursive(qt, k);

        for(int i=0;i<n-k;i++)
        {
            qt.offer(qt.poll());
        }
    }*/
}
public class Problem01
{
    public static void main(String[] args) {
        
        Scanner SC = new Scanner(System.in);
        Queue<Integer> qt = new LinkedList<>();

        while(true)
        {
            System.out.print("Enter values for queue (-1 to stop): ");
            int value = SC.nextInt();

            if(value != -1)
            qt.offer(value);

            else
            break;
        }
        System.out.print("Enter value of k: ");
        int k = SC.nextInt();

        REVERSE obj = new REVERSE();
        obj.reverse(qt, k);

        System.out.println(qt);
    }
}