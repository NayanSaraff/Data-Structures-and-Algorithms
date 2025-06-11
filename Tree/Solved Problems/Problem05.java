import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Balanced {
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

    public int Height(Node node) {
        if (node == null)
            return 0;
        
            return 1+Math.max(Height(node.left),Height(node.right));
    }
    public boolean balance(Node node)
    {
        if(node == null)
        return true;

        int left = Height(node.left);
        int right = Height(node.right);

        if(Math.abs(left-right) > 1)
        return false;

        return balance(node.left) && balance(node.right);
    }
}

public class Problem05 {
    public static void main(String[] args) {
        Balanced obj = new Balanced();

        obj.Tree();
        if(obj.balance(obj.root))
        System.out.println("Balanced");
        else
        System.out.println("Unbalanced");
    }

}
