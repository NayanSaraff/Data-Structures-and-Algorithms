import java.util.*;
public class Problem03 {
    public static void main(String[] args) {
        
        Stack<Integer> st = new Stack<>();

        Scanner SC = new Scanner(System.in);
        
        System.out.print("Enter limit: ");
        int limit = SC.nextInt();

        int middle = (limit%2 == 0) ? (limit/2-1):(limit/2);

        for(int i=0;i<limit;i++)
        {
            int num = SC.nextInt();

            if(i!=middle)
            st.push(num);
        }
        SC.close();
        while(!st.empty())
        {
            System.out.print(st.pop()+" ");
        }
    }
}
