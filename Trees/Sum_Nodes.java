import java.util.*;
public class Sum_Nodes {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Tree{
        static int idx = -1;

        public static Node BuildTree(int []nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;
        }
    }

    public static int SumNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = SumNodes(root.left);
        int rightSum = SumNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static void main(String[]args){
        int[]nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Tree t = new Tree();
        Node root = t.BuildTree(nodes);
        System.out.println(SumNodes(root));

    }
}
