import java.util.*;
public class Search_BST {
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root,int val){
        if(root == null){
            return new Node(val);
        }
        if(root.data > val) {
            root.left = insert(root.left,val);
        }
        else{
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data > key){
            return search(root.left,key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return search(root.right,key);
        }
    }

    public static void main(String[] args){
        int[]nodes = {5,1,3,4,2,7};
        Node root = null;

        for(int i = 0;i < nodes.length; i++){
            root = insert(root,nodes[i]);
        }
        inorder(root);
        System.out.println();
        int key = 10;
        System.out.print(search(root,key));
    }
}
