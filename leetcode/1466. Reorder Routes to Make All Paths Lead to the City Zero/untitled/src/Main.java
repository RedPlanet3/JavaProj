import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public void fullGraph(HashSet<Integer>[] grapf, int[][] connections, HashSet<Integer> startPoints)
    {
        for(int[] con : connections)
        {
            grapf[con[0]].add(con[1]);
            grapf[con[1]].add(con[0] * -1);
        }
    }
    public int minReorder(int n, int[][] connections) {
        HashSet<Integer>[] graph= new HashSet[n];
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++) visited.add(i);
        HashSet<Integer> startPoints = new HashSet<>();
        for(int i = 0; i < n; i++) startPoints.add(i);
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}