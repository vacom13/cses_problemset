import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer[][] arr = new Integer[n][2];
        for(int i =0; i < n; i++){
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
        }
        Arrays.sort(arr, (Integer[] a, Integer[] b) ->{
            return a[0] - b[0];
        });
        // print(arr);
        long ans = 0;
        long time = 0;
        for(int i =0; i < n; i++){
            ans += arr[i][1] - (arr[i][0] + time);
            time+=arr[i][0];
        }
        System.out.println(ans);

    }


    private static void print(Integer[][] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
        System.out.println();
    }
}
