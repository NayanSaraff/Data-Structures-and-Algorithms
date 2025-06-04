import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Tree_Prop {
    Node root;

    ArrayList<Integer> leaf = new ArrayList<>();

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

            if (left == -1 && right == -1)
                leaf.add(current.data);
        }
        SC.close();
    }

    public void NodeProperty(int value) {
        Queue<Node> temp = new LinkedList<>();

        temp.add(root);
        if (root == null) {
            System.out.println("Null tree");
            return;
        }

        if (root.data == value) {
            System.out.println("Its a root node, the ultimate parent and no sibling");
            return;
        }
        while (!temp.isEmpty()) {
            Node current = temp.poll();

            if (current.left.data == value || current.right.data == value) {
                System.out.println("Parent Node is: " + current.data);

                if (current.right != null && current.left.data == value)
                    System.out.println("Sibling: " + current.right.data);
                else if (current.left != null && current.right.data == value)
                    System.out.println("Sibling: " + current.left.data);
                else
                    System.out.println("No sibling");
                return;
            } else {
                if (current.left != null)
                    temp.add(current.left);
                if (current.right != null)
                    temp.add(current.right);
            }
            
        }
        System.out.println("No such node found");
    }

    public void Leaf() {
        System.out.println(leaf.size() + " leaf nodes");
        for (int i : leaf) {
            System.out.print(i + " ");
        }
    }

    public int Height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(Height(node.left), Height(node.right));
    }

    public int Total_nodes(Node node) {
        if (node == null)
            return 0;
        return 1 + Total_nodes(node.left) + Total_nodes(node.right);
    }

}

public class Properties {
    public static void main(String[] args) {

        Scanner SC = new Scanner(System.in);

        Tree_Prop tree = new Tree_Prop();

        tree.make();

        System.out.println("Press to check properties");
        while (true) {
            System.out.println("\n1. Height of tree");
            System.out.println("2. Total number of nodes");
            System.out.println("3. About a node");
            System.out.println("4. Leaf Nodes");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = SC.nextInt();

            switch (choice) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    System.out.println("Height: " + tree.Height(tree.root));
                    break;

                case 2:
                    System.out.println("Total Nodes: " + tree.Total_nodes(tree.root));
                    break;

                case 3:
                    System.out.print("Enter node: ");
                    int node = SC.nextInt();
                    tree.NodeProperty(node);
                    break;

                case 4:
                    tree.Leaf();
                    break;
            }
            SC.close();
        }
    }
}
