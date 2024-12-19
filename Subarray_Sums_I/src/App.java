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
        int i =0;
        int j =1;
        long temp = arr[0];
        int count = 0;
        while(j < n && i <= j){
            if(temp < x){
                temp+=arr[j];
                j++;
            }
            else if(temp > x){
                temp-=arr[i];
                i++;
            }
            else{
                count++;
                temp+=arr[j];
                temp-=arr[i];
                i++;
                j++;
            }
        }
        while(temp > x){
            temp-=arr[i];
            i++;
        }
        if(temp == x) count++;
        System.out.println(count);
    }
}
