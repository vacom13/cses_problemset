import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] customer = new int[n][3];
        for(int i =0; i < n; i++){
            customer[i][0] = scn.nextInt();
            customer[i][1] = scn.nextInt();
            customer[i][2] = i;
        }
        
        Arrays.sort(customer, (int[] a, int[] b) -> a[0] - b[0]);
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i < n; i++){
            while(pq.size() > 0 && pq.peek() < customer[i][0]){
                pq.remove();
            }
            pq.add(customer[i][1]);
            ans = Math.max(ans, pq.size());
        }
        System.out.println(ans);
        Stack<Integer> st = new Stack<>();
        for(int i = ans;i > 0; i--){
            st.push(i);
        }
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((int[] a, int[] b) -> a[1] - b[1]);
        int[] a = new int[n];
        for(int i =0; i < n; i++){
            while(pq2.size() > 0 && pq2.peek()[1] < customer[i][0]){
                st.push(a[pq2.peek()[2]]);
                pq2.remove();
            }
            pq2.add(customer[i]);
            a[customer[i][2]] = st.pop();
        }
        for(int i: a){
            System.out.print(i + " ");
        }
    }
}
