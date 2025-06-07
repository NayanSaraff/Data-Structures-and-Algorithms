import java.util.*;
class Node
{
    int data; Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}
class Tree
{
    Node root1,root2;
    Scanner SC = new Scanner(System.in);

    public void Tree1()
    {
        System.out.print("Enter root for Tree1: ");
        int value = SC.nextInt();
        root1 = new Node(value);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root1);

        while(!queue.isEmpty())
        {
            Node current = queue.poll();

            System.out.print("Enter left node of "+current.data+" (-1 for no node): ");
            int left = SC.nextInt();
            if(left != -1)
            {
                current.left = new Node(left);
                queue.add(current.left);
            }

            System.out.print("Enter right node of "+current.data+" (-1 for no node): ");
            int right = SC.nextInt();
            if(right != -1)
            {
                current.right = new Node(right);
                queue.add(current.right);
            }
        }
    }
    public void Tree2()
    {
        System.out.print("Enter root for Tree2: ");
        int value = SC.nextInt();
        root2 = new Node(value);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root2);

        while(!queue.isEmpty())
        {
            Node current = queue.poll();

            System.out.print("Enter left node of "+current.data+" (-1 for no node): ");
            int left = SC.nextInt();
            if(left != -1)
            {
                current.left = new Node(left);
                queue.add(current.left);
            }

            System.out.print("Enter right node of "+current.data+" (-1 for no node): ");
            int right = SC.nextInt();
            if(right != -1)
            {
                current.right = new Node(right);
                queue.add(current.right);
            }
        }
    }

    //Method 1: Using Depth First Search and aggresively comparing every element

    public static boolean compare(Node r1, Node r2)
    {
        if(r1==null && r2==null)
        return true;

        else if(r1==null||r2==null)
        return false;

        else
        {
            return (r1.data==r2.data)&&
            compare(r1.left,r2.left)&&
            compare(r1.right,r2.right);
        }
    }
}

public class Problem01
{
    public static void main(String[] args) {
        
        Tree obj = new Tree();
        obj.Tree1();
        obj.Tree2();
        boolean value = obj.compare(obj.root1, obj.root2);

        if(value)
        System.out.println("Identical");
        else
        System.out.println("Not identical");
    }
}