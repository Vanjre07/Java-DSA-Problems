import java.util.*;
public class Number_of_Provinces_LT547 {

    public static int Provinces(int[][]isConnected){
        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean []vis = new boolean[n];
        int count = 0;

        for(int index = 0; index < n; index++){
            if(!vis[index]){
                count++;
                dfs(index,adj,vis);
            }
        }

        return count;
    }

    private static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[]vis){
        vis[node] = true;

        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.print(Provinces(isConnected));
    }
}
