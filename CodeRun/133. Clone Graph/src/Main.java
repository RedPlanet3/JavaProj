import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
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

public class Main {

    public void dfs(Node node, HashMap<Node, Node> dict)
    {
        for (Node nd : node.neighbors) {
            if (!dict.containsKey(nd))
                dict.put(nd, new Node(nd.val));
            dict.get(node).neighbors.add(dict.get(nd));
        }
        for (Node nd : node.neighbors)
        {
            if (dict.get(nd).neighbors.size() == 0)
                dfs(nd, dict);
        }
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> dict = new HashMap<>();
        if (node != null) {
            dict.put(node, new Node(node.val));
            dfs(node, dict);
            return dict.get(node);
        }
        return null;
    }

    public static void main(String[] args) {
        Main ds = new Main();

        System.out.println(ds.cloneGraph());
    }
}
