import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] x = new int[n];
        for(int i =0; i<n;i++){
            x[i] = scn.nextInt();
        }
        TreeMap<Integer, Integer> tree1 = new TreeMap<>();
        TreeMap<Integer, Integer> tree2 = new TreeMap<>();
        int i =0;
        int j =0;
        while(j <k){
            tree1.put(x[j],tree1.getOrDefault(x[j], 0) + 1);
            j++;
        }
        int size1 = k;
        int size2 = 0;
        while(size2 + 1 < size1){
            int lk = tree1.lastKey();
            tree1.put(lk, tree1.get(lk) - 1);
            tree2.put(lk, tree2.getOrDefault(lk, 0) + 1);
            if(tree1.get(lk) == 0){
                tree1.remove(lk);
            }
            size1--;
            size2++;
        }
        int[] ans = new int[n-k + 1];
        while(j < n){
            
            ans[i] = tree1.lastKey();
            int lk = tree1.lastKey();
            if(lk>=x[i]){
                tree1.put(x[i], tree1.get(x[i]) - 1);
                size1--;
                if(tree1.get(x[i]) == 0){
                    tree1.remove(x[i]);
                }
            }
            else{
                tree2.put(x[i], tree2.get(x[i]) - 1);
                size2--;
                if(tree2.get(x[i]) == 0){
                    tree2.remove(x[i]);
                }
            }
            lk = size1==0?-1:tree1.lastKey();
            if(x[j] <= lk){
                tree1.put(x[j], tree1.getOrDefault(x[j], 0) + 1);
                size1++;
            }
            else{
                tree2.put(x[j], tree2.getOrDefault(x[j], 0) + 1);
                size2++;
            }

            while(size2 + 1 < size1){
                lk = tree1.lastKey();
                tree1.put(lk, tree1.get(lk) - 1);
                tree2.put(lk, tree2.getOrDefault(lk, 0) + 1);
                if(tree1.get(lk) == 0){
                    tree1.remove(lk);
                }
                size1--;
                size2++;
            }
            while(size2 > size1){
                int fk = tree2.firstKey();
                tree2.put(fk, tree2.get(fk) - 1);
                tree1.put(fk, tree1.getOrDefault(fk, 0) + 1);
                if(tree2.get(fk) == 0){
                    tree2.remove(fk);
                }
                size1++;
                size2--;
            }

            i++;
            j++;
        }

        ans[i] = tree1.lastKey();

        for(int temp: ans){
            System.out.print(temp + " ");
        }
    }
}
