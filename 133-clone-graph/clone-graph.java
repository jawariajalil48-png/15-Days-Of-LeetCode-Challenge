import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        // Map to store original node -> cloned node
        Map<Node, Node> visited = new HashMap<>();
        
        return dfs(node, visited);
    }
    
    private Node dfs(Node node, Map<Node, Node> visited) {
        // If already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Create a new clone node
        Node clone = new Node(node.val);
        visited.put(node, clone);
        
        // Recursively clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }
        
        return clone;
    }
}
