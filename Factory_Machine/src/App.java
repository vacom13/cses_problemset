import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        long low = 1;
        long high = Long.MAX_VALUE;
        while(low < high){
            long mid = low + (high - low)/2;
            long temp = t;
            boolean check = false;
            for(int i =0; i < n; i++){
                long ele = mid / arr[i];
                temp -=ele;
                if(temp<= 0){
                    check= true;
                    break;
                }
            }
            if(check){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}
