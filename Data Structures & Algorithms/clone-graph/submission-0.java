/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public class NodeWrapper {
        public NodeWrapper(Node node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }
        Node node;
        boolean visited;
        
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        return cloneGraph(node, new HashMap<>());

    }

    public Node cloneGraph(Node node, Map<Integer, NodeWrapper> nodeMap) {
        if (node == null) {
            return node;
        }
        if (nodeMap.containsKey(node.val) && nodeMap.get(node.val).visited) {
            return nodeMap.get(node.val).node;
        }
        if (!nodeMap.containsKey(node.val)) {
            nodeMap.put(node.val, new NodeWrapper(new Node(node.val), true));
        } else {
            nodeMap.get(node.val).visited = true;
        }
        List<Node> newNeighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            if (!nodeMap.containsKey(neighbor.val)) {
                nodeMap.put(neighbor.val, new NodeWrapper(new Node(neighbor.val), false));
            }
            newNeighbors.add(nodeMap.get(neighbor.val).node);
            cloneGraph(neighbor, nodeMap);
        }
        nodeMap.get(node.val).node.neighbors = newNeighbors;
        return nodeMap.get(node.val).node;
    }
}