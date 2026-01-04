import java.util.Arrays;
import java.util.Scanner;

public class D_Maximum_path {

    public static int solve(int [][] grid,boolean [][] visited,int r,int c){
        int n =  grid[0].length;

        if(r >= 3 || c >= n || r < 0 || c<0)return Integer.MIN_VALUE;
        if(r == 2 && c == n-1)return grid[r][c];

        if(visited[r][c])return Integer.MIN_VALUE;


        visited[r][c] = true;
        int sum = Integer.MIN_VALUE;

        sum = Math.max(sum,solve(grid, visited, r+1, c));
        sum = Math.max(sum,solve(grid, visited, r, c-1));
        sum = Math.max(sum,solve(grid, visited, r, c+1));
        sum = Math.max(sum,solve(grid, visited, r-1, c));

        visited[r][c] = false;

        if(sum == Integer.MIN_VALUE)return Integer.MIN_VALUE;

        return grid[r][c] + sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][] grid = new int [3][n];
        boolean [][] visited = new boolean[3][n];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }


        System.out.println(solve(grid,visited,0,0));
    }
}