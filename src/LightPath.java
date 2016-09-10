import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

        tempPath.add(src);  //ROU-1
        List<Node> adjacencyNodes = currNode.getConnectedNodes();

        if(adjacencyNodes.get(0) == null) {
            System.out.println("Router " + currNode.getName() + " is not connected to the WDM network");

            return;
        }

        currNode = adjacencyNodes.get(0);       //OXC-1
        tempPath.add(currNode);
        queue.add(currNode);                    //OXC-1 to queue

        while (!queue.isEmpty()) {
            for (Node node : queue.remove().getConnectedNodes()) {
                if (!tempPath.contains(node) && !gray.contains(node)) {
                    queue.add(node);
                    gray.add(node);
                    System.out.println(node.getName());

                }

                visited.add(node);
            }
        }
    }
}
