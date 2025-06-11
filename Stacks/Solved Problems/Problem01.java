import java.util.*;
public class Problem01 {
    public static void main(String[] args) {
        
        Scanner SC = new Scanner(System.in);
        Stack<Character> st = new Stack<>();

        System.out.print("Enter expression: ");
        String expression = SC.next();
        SC.close();
        for(int i=0;i<expression.length();i++)
        {
            if(expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[')
            st.push(expression.charAt(i));

            else if(expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']')
            {
                if(st.empty() || ((st.peek()=='(' && expression.charAt(i) != ')')||
                (st.peek()=='{' && expression.charAt(i) != '}')||
                (st.peek()=='[' && expression.charAt(i) != ']')))
                {
                    System.out.println("Not balanced");
                    return;
                }

                else
                st.pop();

            }
        }

        if(st.empty())
        System.out.println("Balanced parantheses");
        
    }
    
}
