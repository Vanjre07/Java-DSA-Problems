import java.util.*;
public class Root_To_Leaf_Path {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
        public static Node Insert(Node root,int val){
            if(root == null){
                return new Node(val);
            }
            if(root.data > val){
                root.left = Insert(root.left,val);
            }
            else{
                root.right = Insert(root.right,val);
            }
            return root;
    }

    public static void Inorder(Node root){
        if(root == null){
            return;
        }
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }

    public static void RootLeaf(Node root,ArrayList<Integer> Path){
        if(root == null){
            return;
        }
        Path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(Path);
        }
        else{
            RootLeaf(root.left,Path);
            RootLeaf(root.right,Path);
        }
        Path.remove(Path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> Path){
        for(int i=0; i<Path.size(); i++){
            System.out.print(Path.get(i) +" ");
        }
        System.out.println();
    }

    public static void main(String[]args){
        int []nodes = {5,1,3,4,2,7};
        Node root = null;

        for(int i = 0; i < nodes.length; i++){
            root = Insert(root,nodes[i]);
        }
        Inorder(root);
        System.out.println();
        RootLeaf(root,new ArrayList<>());
    }
}

