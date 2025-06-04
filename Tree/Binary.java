import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class Tree {
    Node root;

    public void make() {
        Scanner SC = new Scanner(System.in);

        System.out.print("Enter root element: ");
        int value = SC.nextInt();

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
        SC.close();
    }

    public void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
    public void levelorder() 
    {
        if(root == null) return;

        Queue<Node> level = new LinkedList<>();
        level.add(root);

        while(!level.isEmpty())
        {
            Node current = level.poll();
            System.out.print(current.data+" ");

            if(current.left != null) level.add(current.left);
            if(current.right != null) level.add(current.right);
        }

    }
}

public class Binary {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Tree tree = new Tree();

        while (true) {
            System.out.println("\n1. Create Tree");
            System.out.println("2. Pre-Order Traversal");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Post-Order Traversal");
            System.out.println("5. Level-Order Traversal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();

            in.close();

            switch (choice) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    tree.make();
                    break;

                case 2:
                    tree.preorder(tree.root);
                    break;

                case 3:
                    tree.inorder(tree.root);
                    break;

                case 4:
                    tree.postorder(tree.root);
                    break;

                case 5:
                    tree.levelorder();
                    break;
            }
        }

    }
}
