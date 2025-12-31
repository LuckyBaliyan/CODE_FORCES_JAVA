import java.util.*;

class A_Remove_Smallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            Arrays.sort(arr);

            boolean ok = true;
            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[i - 1] > 1) {
                    ok = false;
                    break;
                }
            }

            if (ok) System.out.println("YES");
            else System.out.println("NO");
        }

        sc.close();
    }
}

