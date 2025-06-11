import java.util.*;

public class Problem07 {
    public static void main(String[] args) {

        Scanner SC = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String input = SC.nextLine();
        SC.close();
        Stack<String> st = new Stack<>();

        int count = 0;

        String word = "";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ')
                word = word + input.charAt(i);

            else {
                if(!word.equals(""))
                {
                    if (!st.empty() && st.peek().equals(word)) {
                    st.pop();
                    count--;
                } else {
                    st.push(word);
                    count++;
                }
                }
                word = "";
            }
        }
         if (!word.equals("")) {
            if (!st.empty() && st.peek().equals(word)) {
                st.pop();
                count--;
            } else {
                st.push(word);
                count++;
            }
        }

        System.out.println("Total: " + count);
    }
}
