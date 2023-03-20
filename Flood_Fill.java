package graphs;

public class Flood_Fill {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int m = image.length, n = image[0].length;
        int sr = 1, sc = 1, color = 2;
        int start = image[sr][sc];
        int[][] cpyArray = image;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCols = {0, 1, 0, -1};
        int[][] finalRes = dfs(sr, sc, color, image, m, n, start, cpyArray, delRow, delCols);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(finalRes[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static int[][] dfs(int sr, int sc, int color, int[][] image, int m, int n, int start, int[][] cpyArray, int[] delRow, int[] delCols) {
        cpyArray[sr][sc] = color;
        for (int i = 0; i < 4; i++) {
            int nrow = sr + delRow[i];
            int ncol = sc + delCols[i];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == start && cpyArray[nrow][ncol] != color) {
                dfs(nrow, ncol, color, image, m, n, start, cpyArray, delRow, delCols);
            }

        }
        return cpyArray;

    }
}
