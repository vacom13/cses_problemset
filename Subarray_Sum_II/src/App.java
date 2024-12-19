import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = scn.nextInt();
        int[] arr = new int[n];
        for(int i =0; i < n; i++){
            arr[i]= scn.nextInt();
        }
        long ans=0;
        HashMap<Long,Long> map = new HashMap<>();
        map.put(0L,1L);
        long count = 0;
        for(int i =0; i < n;i++){
            ans+=arr[i];
            long diff = ans-x;
            count+=map.getOrDefault(diff,0L);
            map.put(ans,map.getOrDefault(ans,0L) + 1);
        }
        System.out.println(count);
    }
}