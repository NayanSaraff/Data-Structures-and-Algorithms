import java.util.*;
public class Problem08_Method1 {

    public int GCD(int x, int y)
    {
        if(y==0)
        return x;

        return GCD(y,x%y);
    }
    public static void main(String[] args) {

        Problem08_Method1 obj = new Problem08_Method1();
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Scanner SC = new Scanner(System.in);

        int row = 0;

        list.add(new ArrayList<>());

        int max = 0; int node = 0;
        while(true)
        {
            System.out.print("Enter value (-1 to stop): ");
            int value = SC.nextInt();

            if(value == -1)
            break;

            list.get(row).add(value);

            if(list.get(row).size() == 3)
            {
                int val = obj.GCD(list.get(row).get(1),list.get(row).get(2));
                if(val > max)
                {
                    max = val;
                    node = list.get(row).get(0);
                }
                list.add(new ArrayList<>());
                row++;
            }
        }
        System.out.println("The node "+node+" has the greatest gcd of "+max);
    }
    
}
