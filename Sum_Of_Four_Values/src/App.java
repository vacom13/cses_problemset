import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = scn.nextInt();
        int[][] a = new int[n][2];
        for(int i =0; i < n; i++){
            a[i][0] = scn.nextInt();
            a[i][1] = i + 1;
        }
        Arrays.sort(a,(int[] a1, int[] b1) -> a1[0] - b1[0]);
        
        boolean ans=false;
        int i= -1, j= -1, k = -1, l=-1;
        outerLoop:
        for(i =0; i < n - 3; i++){
            long target = x- a[i][0];
            for(j = i + 1; j < n-2;j++){
                long target2=target - a[j][0];
                if(target2 < 0){
                    break;
                }
                k = j + 1;
                l = n-1;
                while(k < l){
                    long sum = (long)a[k][0] + (long)a[l][0];
                    if(sum == target2){
                        ans = true;
                        break outerLoop;
                    }
                    else if(sum > target2){
                        l--;
                    }
                    else{
                        k++;
                    }
                }
            }
        }
        // System.out.println(x);
        if(!ans){
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println("" + a[i][1]+" " + a[j][1] +" "+ a[k][1] +" "+ a[l][1]);
    }
}
