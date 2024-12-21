import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] x = new int[n];
        for(int i =0; i< n; i++){
            x[i] = scn.nextInt();
        }
        int i =0;
        int j =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        while(j < n){
            map.put(x[j], map.getOrDefault(x[j], 0) + 1);
            while(map.size() > k){
                map.put(x[i], map.get(x[i]) - 1);
                if(map.get(x[i]) == 0){
                    map.remove(x[i]);
                }
                i++;
            }
            ans+= j - i + 1;
            j++;
        }

        // while(map.size() > k){
        //     map.put(x[i], map.get(x[i]) - 1);
        //     if(map.get(x[i]) == 0){
        //         map.remove(x[i]);
        //     }
        //     i++;
        // }
        // ans+= j - i + 1;
        System.out.println(ans);
    }
}
