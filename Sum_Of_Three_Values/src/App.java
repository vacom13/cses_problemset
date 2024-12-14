import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = scn.nextInt();
        int[][] arr = new int[n][2];
        for(int i =0; i < n; i++){
            arr[i][0]= scn.nextInt();
            arr[i][1] = i;
        }
        Arrays.sort(arr,(int[] a, int[]b)-> a[0] - b[0]);
        int i = -1,j = -1,k = -1;
        boolean ans = false;
        for(i = 0; i < arr.length - 2 && ans == false; i++){
            long target = x - (long)arr[i][0];
            if(target < 0){
                break;
            }
            j = i + 1;
            k = n - 1;
            while(j < k){
                long sum = arr[j][0] + arr[k][0];
                if(sum == target){
                    i = arr[i][1];
                    j = arr[j][1] + 1;
                    k = arr[k][1] + 1;
                    ans = true;
                    break;
                }
                else if(sum > target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }

        if(!ans){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(i + " " + j + " " + k);
        }
    }
}
