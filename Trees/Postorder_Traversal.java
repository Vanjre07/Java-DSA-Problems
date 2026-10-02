public class Postorder_Traversal {
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
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

    public static void Postorder(Node root){
        if(root == null){
            return;
        }
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String[]args){
        int[]nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Tree tree = new Tree();
        Node root = tree.BuildTree(nodes);

        Postorder(root);
    }
}
