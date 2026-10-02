import java.util.*;
public class Print_In_Range {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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
            System.out.print(root.data + " ");
            Inorder(root.right);
    }


    public static void InRange(Node root,int X,int Y){
        if(root == null){
            return;
        }

        if(X <= root.data && root.data <= Y){
            InRange(root.left,X,Y);
            System.out.print(root.data+" ");
            InRange(root.right,X,Y);
        }
        else if(root.data >= Y){
            InRange(root.left,X,Y);
        }
        else{
            InRange(root.right,X,Y);
        }
    }

    public static void main(String[]args){
        int[] nodes = {5,1,3,4,2,7};
        Node root = null;

        for(int i = 0; i < nodes.length; i++){
            root = Insert(root,nodes[i]);
        }
        Inorder(root);
        System.out.println();
        InRange(root,4,7);
    }
}


