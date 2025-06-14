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
class Search
{
    Node root;
    public void Tree()
    {
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter root node: ");
        int value = SC.nextInt();

        root = new Node(value);

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            Node current = queue.poll();

            System.out.print("Enter left node value of "+current.data+" (-1 for no node): ");
            int left = SC.nextInt();

            if(left!=-1)
            {
                current.left = new Node(left);
                queue.add(current.left);
            }

            System.out.print("Enter left node value of "+current.data+" (-1 for no node): ");
            int right = SC.nextInt();

            if(right!=-1)
            {
                current.right = new Node(right);
                queue.add(current.right);
            }
        }
    }

    public boolean search(Node node,int min,int max)
    {
        if(node == null)
        return true;

        if(node.data <= min || node.data >= max)
        return false;

        return search(node.left,min,node.data)&&search(node.right, node.data, max);
    }
}
public class BST {
    public static void main(String[] args) {
        
        Search obj = new Search();
        obj.Tree();
        
        if(obj.search(obj.root, Integer.MIN_VALUE, Integer.MAX_VALUE))
        System.out.println("Its a valid binary tree");
        else
        System.out.println("Not a valid binary tree");
    }
    
}
