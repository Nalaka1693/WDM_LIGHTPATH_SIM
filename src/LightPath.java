import java.util.*;

public class LightPath {
    private IP_Router src;
    private IP_Router dst;

    public LightPath(IP_Router src, IP_Router dst) {
        this.src = src;
        this.dst = dst;
    }

    public void findLightPath() {
        Node currNode = src;
        Node nextNode = null;
        int noOfHops = 0;
        ArrayList noOfHopsList = new ArrayList<>();
        ArrayList<ArrayList<Node>> paths = new ArrayList<>();
        ArrayList<Node> tempPath = new ArrayList<>();
        ArrayList<Node> gray = new ArrayList<>();
        ArrayList<Node> visited = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> parentRelateMap = new HashMap<>();

        gray.add(src);
        List<Node> adjacencyNodes = currNode.getConnectedNodes();

        if(adjacencyNodes.get(0) == null) {
            System.out.println("Router " + currNode.getName() + " is not connected to the WDM network");

            return;
        }

        currNode = adjacencyNodes.get(0);       //OXC-1
        gray.add(currNode);
        queue.add(currNode);                    //OXC-1 to queue

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            for (Node n : node.getConnectedNodes()) {
                if (!gray.contains(n)) {
                    queue.add(n);
                    gray.add(n);
                    parentRelateMap.put(n, node);
                }

                visited.add(node);

                if (dst == node) {
                    break;
                }
            }
        }

        Node curr = dst;

        for (Node ignored : parentRelateMap.keySet()) {
            for (Node n : parentRelateMap.keySet()) {
                if (n == curr) {
                    Node val = parentRelateMap.get(n);
                    tempPath.add(val);
                    curr = val;
                }
            }
        }
        Collections.reverse(tempPath);
        paths.add(tempPath);
        for (Node n : tempPath) {
            System.out.print(n.getName() + " ");
        }
        System.out.println();
    }
}
