
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class MergeTrees {
    static int count = 0;

    static void dfs(ArrayList<Integer>[] li, boolean visited[], int src) {
        if (visited[src]) return;
        visited[src] = true;
        count++;
        for (int i : li[src]) {
            dfs(li, visited, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        ArrayList<Integer> li[] = new ArrayList[nodes + 1];
        for (int i = 0; i <= nodes; i++) li[i] = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            li[u].add(v);
            li[v].add(u);
        }
        boolean visited[] = new boolean[nodes + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= nodes; i++) {
            if (visited[i] == false) {
                count = 0;
                dfs(li, visited, i);
                //count should have no of nodes, visted by curr bfs
                pq.add(count);
            }
        }
        long ans = 0;

        while (pq.size() > 1) {
            int sumOfTwoCompo = pq.poll() + pq.poll();
            ans += sumOfTwoCompo;
            pq.add(sumOfTwoCompo);
        }
        System.out.println(ans);

    }
}
