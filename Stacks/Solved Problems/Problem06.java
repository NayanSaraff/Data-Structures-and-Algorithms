import java.util.*;
public class Problem06 {
    public static void main(String[] args) {
        
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter limit: ");
        int limit = SC.nextInt();

        int[] price = new int[limit];

        System.out.print("Enter elements: ");
        for(int i=0;i<limit;i++)
        {
            price[i] = SC.nextInt();
        }
        SC.close();
        Stack<Integer> st = new Stack<>();
        int[] index = new int[limit];

        for(int i=0;i<limit;i++)
        {
            while(!st.empty()&&price[st.peek()] <= price[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                index[i] = i+1;
            }
            else
            {
                index[i] = i - st.peek();
            }
            st.push(i);
        }
        for(int j:index)
        {
            System.out.print(j+" ");
        }
    }
}