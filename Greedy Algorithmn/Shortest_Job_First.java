import java.util.*;
public class Shortest_Job_First {

    public static long SJF(int[]job){
        Arrays.sort(job);
        int n = job.length;
        long cal = 0;
        long wt = 0;
        for (int i : job) {
            wt += cal;
            cal += i;
        }

        return (wt / n);
    }
    public static void main(String[] args) {
        int[]job = {4, 1, 3, 7, 2};
        System.out.print(SJF(job));
    }
}
