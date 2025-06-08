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
class Mirror
{
    Node root;

    Scanner SC = new Scanner(System.in);

    public void Tree()
    {
        System.out.print("Enter root for Tree1: ");
        int value = SC.nextInt();
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

    public void mirror(Node node)
    {
        if(node == null)
        return;
        if(node.left == null && node.right == null)
        return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty())
        {
            Node current = queue.poll();

            Node temp = current.left;
            current.left =current.right;
            current.right = temp;

            if(current.left!=null)
            queue.add(current.left);
            if(current.right!=null)
            queue.add(current.right);
        }
    }
    public void display(Node node)
    {
        if(node == null)
        return;

        display(node.left);
        System.out.print(node.data+" ");
        display(node.right);

    }
}

public class Problem02 {
    public static void main(String[] args) {
        Mirror obj = new Mirror();

        obj.Tree();
        obj.display(obj.root);
        obj.mirror(obj.root);
        System.out.println();
        obj.display(obj.root);
    }
}
