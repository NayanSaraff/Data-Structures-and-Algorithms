import java.util.*;
public class Stacks_Builtin
{
    Stack<Integer> stack = new Stack<>();

    void Push(int data)
    {
        stack.push(data);
    }
    void Pop()
    {
        try {
            System.out.println(stack.pop()+" popped out successfully");
        } catch (Exception e) {
            System.out.println("No element in stack");
        }
    }
    int Peek()
    {
        return stack.peek();
    }
    boolean Empty()
    {
        return stack.isEmpty();
    }
    int Search(int data)
    {
        return stack.search(data);
    }
    void Display()
    {
        System.out.println(stack);
    }
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        Stacks_Builtin stk = new Stacks_Builtin();

        while(true)
        {
            System.out.println("\n1. Push an element");
        System.out.println("2. Pop an element");
        System.out.println("3. Peek at the top element");
        System.out.println("4. Check if stack is empty");
        System.out.println("5. Search for an element");
        System.out.println("6. Display the stack");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice = SC.nextInt();

        switch(choice)
        {
            case 1: System.out.print("Enter element: ");
                    int enter = SC.nextInt();
                    stk.Push(enter);
                    System.out.println(enter+ " pushed successfully");
                    break;
            case 2: stk.Pop();
                    break;
            case 3: System.out.println(stk.Peek()+" is the topmost element");
                    break;
            case 4: boolean ans = stk.Empty();
                    if(ans)
                    System.out.println("Stack is empty");
                    else 
                    System.out.println("Stack is not empty");
                    break;
            case 5: System.out.print("Enter element to search: ");
                    int search = SC.nextInt();
                    if(stk.Search(search) != -1)
                    System.out.println(search+" found at position "+stk.Search(search));
                    else
                    System.out.println("No such element");
                    break;
            case 6: stk.Display();
                    break;
            case 0: SC.close();
                    System.exit(0);
        }
        }
    }
}