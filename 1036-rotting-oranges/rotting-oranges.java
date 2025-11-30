import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Add all initially rotten oranges to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh oranges, return 0 immediately
        if (freshCount == 0) return 0;

        int minutes = -1; // start at -1 because first level is initial rotten oranges
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] != 1) {
                        continue;
                    }

                    // Rot the fresh orange
                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    freshCount--;
                }
            }
        }

        // Step 3: Check if all fresh oranges are rotten
        return freshCount == 0 ? minutes : -1;
    }
}
