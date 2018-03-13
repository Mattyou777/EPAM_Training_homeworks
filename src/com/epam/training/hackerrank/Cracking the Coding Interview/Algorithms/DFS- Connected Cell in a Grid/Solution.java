import java.util.Scanner;

public class Solution {
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        visited = new boolean[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
                visited[grid_i][grid_j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) max = Math.max(max, findZoneHelper(grid, i, j, n, m));
            }
        }
        System.out.println(max);
    }

    public static int findZoneHelper(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) return 0;
        if (visited[i][j]) return 0;
        visited[i][j] = true;
        if (grid[i][j] == 0) return 0;
        else return 1 +
                findZoneHelper(grid, i - 1, j - 1, n, m) +
                findZoneHelper(grid, i - 1, j, n, m) +
                findZoneHelper(grid, i - 1, j + 1, n, m) +
                findZoneHelper(grid, i, j - 1, n, m) +
                findZoneHelper(grid, i, j + 1, n, m) +
                findZoneHelper(grid, i + 1, j - 1, n, m) +
                findZoneHelper(grid, i + 1, j, n, m) +
                findZoneHelper(grid, i + 1, j + 1, n, m);
    }
}
