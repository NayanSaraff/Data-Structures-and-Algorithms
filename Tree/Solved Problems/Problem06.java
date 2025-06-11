import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Sum {
    Node root;

    Scanner SC = new Scanner(System.in);

    public void Tree() {
        System.out.print("Enter root for Tree: ");
        int value = SC.nextInt();
        if (value == -1) {
            root = null;
            return;
        }

        root = new Node(value);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.print("Enter left node of " + current.data + " (-1 for no node): ");
            int left = SC.nextInt();
            if (left != -1) {
                current.left = new Node(left);
                queue.add(current.left);
            }

            System.out.print("Enter right node of " + current.data + " (-1 for no node): ");
            int right = SC.nextInt();
            if (right != -1) {
                current.right = new Node(right);
                queue.add(current.right);
            }
        }
    }
    public boolean Parent_Child_Sum(Node node)
    {
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty())
        {
            Node current = queue.poll();

            int left = (current.left!=null) ? current.left.data : 0;
            int right = (current.right!=null) ? current.right.data : 0;
            
            if(current.left!=null || current.right!=null)
            {
                if(left + right != current.data)
            {
                return false;
            }
            }

            if(current.left != null)
            queue.add(current.left);
            if(current.right != null)
            queue.add(current.right);
        }
        return true;
    }
}
public class Problem06 {
    public static void main(String[] args) {
        
        Sum obj = new Sum();

        obj.Tree();
        if(obj.Parent_Child_Sum(obj.root))
        System.out.println("Binary tree follows Child Sum Property");
        else
        System.out.println("Binary tree does not follow Child Sum Property");
    }
    
}
