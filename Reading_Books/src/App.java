import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long ans = 0;
        int[] arr = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        Arrays.sort(arr);
        System.out.println();
        int i2 = arr.length-2;
        while(i2 >= 0){
            ans+=arr[i2];
            i2--;
        }
        if(ans >= arr[arr.length-1]){
            ans+=arr[arr.length-1];
        }
        else{
            ans = 2 * (long)arr[arr.length-1];
        }
        
        System.out.println(ans);
    }
}
