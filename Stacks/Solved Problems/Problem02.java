import java.util.*;
public class Problem02 {
    public static void main(String[] args) {
        
        Scanner SC = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        System.out.print("Enter string: ");
        String input = SC.next();
        SC.close();
        for(int i=0;i<input.length();i++)
        {
            st.push(input.charAt(i));
        }

        while(!st.empty())
        {
            System.out.print(st.pop());
        }
    }
    
}
