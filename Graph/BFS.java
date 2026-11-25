import java.util.*;
public class BFS {

    public static ArrayList<Integer> bfsGraph (int v,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[]vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            for(Integer it : adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
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

        System.out.println(bfsGraph(v, adj));
    }
}
