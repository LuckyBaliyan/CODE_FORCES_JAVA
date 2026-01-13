import java.util.Scanner;

public class D_Sum_of_LDS {

    /* 
    // Brute force way to generate and check
    public static int getLongestLDS(int [] arr){
        int n = arr.length;

        int sum = 0;

        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                sum += lds(arr,i,j,-1);
            }
        }

        return sum;
    }
   // Brute 
    public static int lds(int [] arr,int i,int j,int prev){
        if(i > j)return 0;

        int take = 0;
        if(prev == -1 || arr[prev] > arr[i]){
           take = lds(arr, i+1, j, i)+1;
        }

        int notTake = lds(arr,i+1,j,prev);
        return Math.max(take,notTake);
    }
    */

    // Mistake in this approach
    //  we don't have choices we are working on subarrays not subsequences

    public static long ldsTab(long [] arr){
        int n = arr.length;

        long ans = 0;
        long [] dp = new long[n];
        //Base Cases:-

        dp[0] = 1;
        ans = 1;

        if(arr[1] < arr[0]){
            dp[1] = 3;
        }
        else{
            dp[1] = 2;
        }

        ans = ans + dp[1];

        for(int i = 2;i<n;i++){
            if(arr[i] < arr[i-1]){
                dp[i] = dp[i-1]+(i+1);
            }
            else{
                dp[i] = dp[i-2]+(i+1);
            }
            ans = ans + dp[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0;i<t;i++){

            int n = sc.nextInt();

            long [] arr = new long[n];

            for(int j = 0;j<n;j++){
                arr[j] = sc.nextInt();
            }

            System.out.println(ldsTab(arr));
        }
    }
}