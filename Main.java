import java.util.Scanner;

public class Main {

    public static final int MOD = 1000000007;

    public static long fac(int n){
        long fac = 1;
        for(long i = 2;i<=n;i++){
            fac  = ((fac) % MOD * (i) % MOD)%MOD;
        }

        return fac;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int pos = sc.nextInt();

        int l = 0;
        int r = n;

        long sum = 1;
        int greater = n - x;
        int smallest = x - 1;
        int space = n - 1;

        while (l < r) {
            int mid = (l+r)/2;

            if(mid == pos){
                l = mid + 1;
            }

            else if (mid > pos){
                sum = ((sum % MOD) * (greater % MOD))%MOD;
                greater--;
                space--;
                r = mid;
            }
            else{
               sum = ((sum % MOD) * (smallest % MOD))%MOD;
               smallest--;
               space--;
               l = mid + 1;
            }
        }

        if(l > 0 && l-1 == pos){
            sum = ((sum % MOD) * (fac(space) % MOD)) % MOD;
            System.out.println(sum);
        }
        else System.out.println(0);
    }
}