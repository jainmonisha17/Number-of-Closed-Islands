// Number of Closed Islands

/* You are given a 2D matrix containing only 1s (land) and 0s (water).

An island is a connected set of 1s (land) and is surrounded by either an edge or 0s (water). Each cell is considered connected to other cells horizontally or vertically (not diagonally).

A closed island is an island that is totally surrounded by 0s (i.e., water). This means all horizontally and vertically connected cells of a closed island are water. This also means that, by definition, a closed island can't touch an edge (as then the edge cells are not connected to any water cell).

Write a function to find the number of closed islands in the given matrix. */

public class noOfClosedIslands {
    public int countClosedIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countClosedIslands = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (DFS(grid, visited, i, j)) {
                        countClosedIslands++;
                    }
                }
            }
        }
        return countClosedIslands;
    }

    private static boolean DFS(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }

        if (grid[row][col] == 0 || visited[row][col]) {
            return true;
        }

        visited[row][col] = true;

        Boolean isClosed = true;

        // recursively visit all neighbouring cells(horizantally & vertically)

        isClosed &= DFS(grid, visited, row + 1, col); // lower cell
        isClosed &= DFS(grid, visited, row - 1, col); // upper cell
        isClosed &= DFS(grid, visited, row, col + 1); // right cell
        isClosed &= DFS(grid, visited, row, col - 1); // left cell

        return isClosed;
    }

    public static void main(String[] args) {
        noOfClosedIslands sol = new noOfClosedIslands();
        System.out.println(sol.countClosedIslands(
                new int[][] {
                        { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(sol.countClosedIslands(
                new int[][] {
                        { 0, 0, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 0, 0 }
                }));
    }
}


// Time complexity of the above algorithm will be , where ‘M’ is the number of rows and 'N' is the number of columns of the input matrix. This is due to the fact that we have to traverse the whole matrix to find islands.

// DFS recursion stack can go M*N deep when the whole matrix is filled with '1's. Hence, the space complexity will be O(M * N) , where ‘M’ is the number of rows and 'N' is the number of columns of the input matrix.