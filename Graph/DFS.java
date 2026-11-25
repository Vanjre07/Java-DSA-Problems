import java.util.*;
public class DFS {

    public static ArrayList<Integer> DfSGraph(int v,ArrayList<ArrayList<Integer>> adj){
        boolean []vis = new boolean[v + 1];
        ArrayList<Integer> lis = new ArrayList<>();
        vis[0] = true;
        dfs(0,vis,adj,lis);
        return lis;
    }

    public static void dfs(int node,boolean[]vis,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> lis){
        vis[node] = true;
        lis.add(node);

        for(Integer it : adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,lis);
            }
        }
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(0, 3, 4));
        adj.get(2).addAll(Arrays.asList(0, 4));
        adj.get(3).add(1);
        adj.get(4).addAll(Arrays.asList(1, 2));

        System.out.println(DfSGraph(v, adj));
    }
}
