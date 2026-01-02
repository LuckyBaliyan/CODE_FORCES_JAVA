import java.util.Scanner;

public class A_Rectangle_Cutting {

    public static String solve(int a,int b){

        if(a%2 != 0 && b%2 != 0)return "No";

        if(a%2 != 0 && b/2 == a){
            return "No";
        }
        else if (b%2 != 0 && a/2 == b)return "No";

        return "Yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 1;i<=t;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(solve(a,b));
        }
    }
}