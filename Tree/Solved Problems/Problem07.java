import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class MAX {
    Node root;

    Scanner SC = new Scanner(System.in);

    public void Tree() 
    {
        System.out.print("Enter root for Tree: ");
        int value = SC.nextInt();
        if (value == -1) 
        {
            root = null;
            return;
        }

        root = new Node(value);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) 
        {
            Node current = queue.poll();

            System.out.print("Enter left node of " + current.data + " (-1 for no node): ");
            int left = SC.nextInt();
            if (left != -1) 
            {
                current.left = new Node(left);
                queue.add(current.left);
            }

            System.out.print("Enter right node of " + current.data + " (-1 for no node): ");
            int right = SC.nextInt();
            if (right != -1) 
            {
                current.right = new Node(right);
                queue.add(current.right);
            }
        }
    }
    public void Level_Max(Node node)
    {
        if(node == null)
        {
            System.out.println("No tree");
            return;
        }

        System.out.println("Largest values in each level:");
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            int max = 0;

            for(int i=0;i<size;i++)
            {
                Node current = queue.poll();
                
                if(current.data > max)
                {
                    max = current.data;
                }
                if(current.left!=null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
            }
            System.out.print(max+" ");
        }
    }
}
public class Problem07 {
    public static void main(String[] args) {
        
        MAX obj = new MAX();

        obj.Tree();
        obj.Level_Max(obj.root);
    }
    
}
