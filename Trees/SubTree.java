import java.util.*;
public class SubTree {
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;

        public static Node BuildTree(int []nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.right =  BuildTree(nodes);
            newNode.left = BuildTree(nodes);

            return newNode;
        }
    }


    public static void main(String[] args){
        int[]nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree Tree = new BinaryTree();
        Tree.BuildTree(nodes);

    }
}
