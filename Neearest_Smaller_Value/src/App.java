import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int[][] arr = new int[n][2];
        for(int i =0; i < n; i++){
            arr[i][0] = scn.nextInt();
            arr[i][1] = i;
        }
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        st.push(0);
        for(int i =1; i < n; i++){
            while(st.size()>0 && arr[i][0] <= arr[st.peek()][0]){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = 0;
            }else{
                ans[i] = st.peek()+1;
            }
            st.push(arr[i][1]);
        }
        for(int i:ans){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
