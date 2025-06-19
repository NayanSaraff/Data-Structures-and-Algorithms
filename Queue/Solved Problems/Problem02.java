import java.util.*;
class BINARY
{
    public void binary(int n)
    {
        Queue<String> qt = new LinkedList<>();
        qt.add("1");

        while(n-- > 0)
        {
            String s1 = qt.poll();
            System.out.println(s1);
            String s2 = s1;

            qt.add(s1+"0");
            qt.add(s2+"1");
        }
    }
}
public class Problem02 {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = SC.nextInt();

        BINARY obj = new BINARY();
        obj.binary(number);
    }
    
}
