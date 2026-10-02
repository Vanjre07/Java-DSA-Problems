import java.util.*;
public class Diameter_Tree {
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
        static class BinaryTree{
            static int idx = -1;
            public static Node buildTree(int []nodes){
                idx++;
                if(nodes[idx] == -1){
                    return null;
                }
                Node newNode= new Node(nodes[idx]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);

                return newNode;
            }
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }

            int H1 = height(root.right);
            int H2 = height(root.left);
            return Math.max(H1,H2) +1;
        }

        //Approach 1
        public static int Diameter(Node root){
            if(root == null){
                return 0;
            }
            int diam = Diameter(root.left);
            int diam1 = Diameter(root.right);
            int diam2 = height(root.left) + height(root.right) +1;

            return Math.max(diam2,Math.max(diam,diam1));
        }

        //Approach 2
    static class TreeInfo{
            int ht;
            int diam;

            TreeInfo(int ht,int diam){
                this.ht = ht;
                this.diam = diam;
            }
        }

        public static TreeInfo diameter2(Node root){
            if(root == null){
                return new TreeInfo(0,0);
            }

            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);

            int myHt = Math.max(left.ht,right.ht) + 1;

            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.ht + right.ht + 1;

            int myDia = Math.max(diam1,Math.max(diam2,diam3));

            TreeInfo myinfo = new TreeInfo(myHt,myDia);

            return myinfo;
         }

        public static void main(String[]args){
            int ele[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(ele);

            System.out.println(Diameter(root));
        }
    }


