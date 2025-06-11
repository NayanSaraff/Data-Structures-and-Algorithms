import java.util.*;
import java.io.*;
public class Problem04 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter string: ");
        String str = br.readLine();

        Stack<Character> st = new Stack<>();

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!= ' ')
            st.push(str.charAt(i));
            else
            {
                while(!st.empty())
                {
                    System.out.print(st.pop());
                }
                System.out.print(" ");
            }
        }
        while(!st.empty())
                {
                    System.out.print(st.pop());
                }
    }
}
