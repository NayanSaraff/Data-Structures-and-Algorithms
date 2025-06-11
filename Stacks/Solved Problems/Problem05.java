import java.util.*;
public class Problem05 {
    public static void main(String[] args) {
        
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = SC.nextInt();

        SC.close();
        int[] arr = new int[size];
        int[] result = new int[size];

        System.out.print("Enter "+size+" elements: ");
        for(int i=0;i<size;i++)
        {
            arr[i]=SC.nextInt();
        }

        //Array method

        // int k=0;
        // int max = 0;
        // int flag = 1;
        // for(int i=0;i<size-1;i++)
        // {
        //     for(int j=i+1;j<size;j++)
        //     {
        //         if(arr[j]>arr[i])
        //         {
        //         max = arr[j];
        //         flag = 1;
        //         break;
        //         }
        //         else
        //         flag = 0;
        //     }
        //     if(flag == 0)
        //     result[k++] = -1;
        //     else
        //     result[k++] = max;

        //     flag = 1;
        // }
        // result[size-1] = -1;

        // for(int i:result)
        // {
        //     System.out.print(i+" ");
        // }



        //Stack Method
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<size;i++)
        {
            while (!st.empty()&&arr[i]>arr[st.peek()]) {
                int index = st.pop();
                result[index] = arr[i];
            }
            st.push(i);
        }
        while(!st.empty())
        {
            result[st.pop()] = -1;
        }
        for(int i:result)
        {
            System.out.print(i+" ");
        }
    }
}
