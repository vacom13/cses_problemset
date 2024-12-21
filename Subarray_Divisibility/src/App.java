import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        long ans = 0;
        long sum = 0;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        for(int i =0; i < n;i++){
            sum+=arr[i];
            long mod = Math.floorMod(sum,n);
            ans+=map.getOrDefault(mod,0L);
            map.put(mod,map.getOrDefault(mod, 0L) + 1);
        }
        System.out.println(ans);
    }
}
