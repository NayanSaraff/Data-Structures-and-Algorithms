import java.util.*;
public class Problem08 {
    
    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> clone = new Stack<>();
    public static void Clone(Stack<Integer> st)
    {
        if(st.empty())
        return;

        int top = st.pop();
        Clone(st);
        clone.push(top);
    }
    public static void main(String[] args) {
        
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter no of elements: ");
        int limit = SC.nextInt();

        for(int i=1;i<=limit;i++)
        {
            st.push(SC.nextInt());
        }
        Clone(st);
        System.out.println(clone.peek());
        while(!clone.isEmpty())
        {
            System.out.print(clone.pop());
        }
    }
}
