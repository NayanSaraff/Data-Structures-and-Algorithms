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
class RIGHT_VIEW
{
    Node root;

    public void Tree()
    {
        Scanner SC = new Scanner(System.in);
        
        System.out.print("Enter root element: ");
        int value = SC.nextInt();
        root = new Node(value);

        Queue<Node> qt = new LinkedList<>();
        qt.offer(root);

        while(!qt.isEmpty())
        {
            Node current = qt.poll();

            System.out.print("Enter left node of "+current.data+" (-1 for null): ");
            int left = SC.nextInt();

            if(left!=-1)
            {
                current.left = new Node(left);
                qt.add(current.left);
            }
            System.out.print("Enter right node of "+current.data+" (-1 for null): ");
            int right = SC.nextInt();

            if(right!=-1)
            {
                current.right = new Node(right);
                qt.add(current.right);
            }
        }
    }
    public void rightview(Node node)
    {
        if(node == null)
        return;

        Queue<Node> qt = new LinkedList<>();
        qt.add(node);

        while(!qt.isEmpty())
        {
            int n = qt.size();

            for(int i=1;i<=n;i++)
            {
                Node current = qt.poll();

                if(i == n)
                System.out.print(current.data+" ");

                if(current.left!=null) qt.add(current.left);
                if(current.right!=null) qt.add(current.right);
            }
        }
    }
}
public class Problem03 {
    public static void main(String[] args) {
        RIGHT_VIEW obj = new RIGHT_VIEW();
        obj.Tree();
        obj.rightview(obj.root);
    }
    
}
