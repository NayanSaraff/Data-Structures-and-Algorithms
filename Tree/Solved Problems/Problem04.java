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
class Diameter
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

    int max = 0;

    public int Height(Node node)
    {
        if(node == null)
        return 0;

        int Left = Height(node.left);
        int Right = Height(node.right);

        max = Math.max(max,Left+Right);
        return 1+Math.max(Left,Right);
    }
}
public class Problem04 {
    public static void main(String[] args) {

        Diameter obj = new Diameter();
        obj.Tree();
        obj.Height(obj.root);
        System.out.println("Diamter of tree: "+obj.max);
    }
    
}
