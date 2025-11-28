import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        
        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];
        
        // Check each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false; // cycle detected
            }
        }
        return true;
    }
    
    private boolean dfs(int course, List<List<Integer>> graph, int[] state) {
        if (state[course] == 1) return false; // cycle
        if (state[course] == 2) return true;  // already checked
        
        state[course] = 1; // mark as visiting
        
        for (int neighbor : graph.get(course)) {
            if (!dfs(neighbor, graph, state)) {
                return false;
            }
        }
        
        state[course] = 2; // mark as visited
        return true;
    }
}
