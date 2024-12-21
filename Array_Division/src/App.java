import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] x = new int[n];
        for(int i =0;i  < n; i++){
            x[i] = scn.nextInt();
        }
        long low =1;
        long high = (long)1e15;
        while(low < high){
            long mid = low + (high - low) / 2;
            boolean possible = true;
            int kTemp = k-1;
            long tempSum = 0;
            for(int i = 0; i < n; i++){
                if(x[i] > mid || kTemp < 0){
                    possible = false;
                    break;
                }
                if(kTemp == n - i || tempSum + x[i]> mid){
                    tempSum = x[i];
                    kTemp--;
                }
                else{
                    tempSum+=x[i];
                }
            }
            if(kTemp <0){
                possible = false;
            }
            if(possible){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}
