import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class MinimumCostOfRopes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        while (tc > 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int n = Integer.parseInt(sc.nextLine());
            String nums[] = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                pq.add(Integer.parseInt(nums[i]));
            }

            long ans = 0;
            while (pq.size() > 1) {
                int sumOfMiniTwo = pq.poll() + pq.poll();
                ans += sumOfMiniTwo;
                pq.add(sumOfMiniTwo);
            }
            System.out.println(ans);
            tc--;
        }

        // Your code here
    }
}
