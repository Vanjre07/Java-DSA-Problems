import java.util.*;
public class Delete_BST {
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

    public static Node Insert(Node root,int val){
        if(root  == null){
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

    public static Node Delete(Node root,int val){
        if(root ==null){
            return null;
        }
        if(root.data > val){
            root.left = Delete(root.left,val);
        }
        else if(root.data < val){
            root.right = Delete(root.right,val);
        }
        else {

            //Case 1 root.data == null
            if(root.left == null && root.right == null){
                return null;
            }

            //Case 2
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //Case 3
            Node IS = InorderSuccessor(root.right);
            root.data = IS.data;
            root.right = Delete(root.right,IS.data);
        }
        return root;
    }

    public static Node InorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[]args){
        int[]nodes = {5,1,3,4,2,7};
        Node root = null;

        for(int i = 0;i < nodes.length; i++){
            root = Insert(root,nodes[i]);
        }

        Inorder(root);
        System.out.println();
        Delete(root,5);
        Inorder(root);
    }
}
