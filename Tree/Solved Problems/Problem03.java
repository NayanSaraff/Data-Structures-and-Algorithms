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
class Symmetry
{
    Node root;

    Scanner SC = new Scanner(System.in);

    public void Tree()
    {
        System.out.print("Enter root for Tree: ");
        int value = SC.nextInt();
        if(value == -1)
        {
            root = null;
            return;
        }

        root = new Node(value);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

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
    public boolean symmetrical(Node node)
    {
        if(node == null)
        return true;
        Queue<Node> queue = new LinkedList<>();

        queue.add(node.left);
        queue.add(node.right);

        while(!queue.isEmpty())
        {
            Node n1 = queue.poll();
            Node n2 = queue.poll();

            if(n1==null && n2 ==null)
            continue;

            if(n1==null || n2==null || n1.data != n2.data)
            return false;

            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }
}
public class Problem03 {
    public static void main(String[] args) {
        
        Symmetry obj = new Symmetry();
        obj.Tree();
        if(obj.symmetrical(obj.root))
        System.out.println("Symmetrical Tree");
        else
        System.out.println("Unsymmetrical Tree");
    }
}
