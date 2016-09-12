import java.util.*;

public class LightPath {
    public static int noOfLightPathsReq = 0;
    public static int noOfLightPathsCreated = 0;
    public static ArrayList<LightPath> lightPaths = new ArrayList<>();

    private IP_Router src;
    private IP_Router dst;

    public LightPath(IP_Router src, IP_Router dst) {
        this.src = src;
        this.dst = dst;

        lightPaths.add(this);
        noOfLightPathsReq++;
    }

    public void findLightPath() {
        Node currNode = src;
        ArrayList<Node> tempPath = new ArrayList<>();
        ArrayList<Node> gray = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> parentRelateMap = new HashMap<>();

        gray.add(src);
        List<Node> adjacencyNodes = currNode.getConnectedNodes();

        if(adjacencyNodes == null || adjacencyNodes.get(0) == null) {
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
                    for (Link link : node.getLinks()) {
                        if (link.getFib(0).isWavLensFree() && (link.getNode1() == n || link.getNode2() == n)) {
                            if (!gray.contains(n)) {
                                queue.add(n);
                                gray.add(n);
                                parentRelateMap.put(n, node);
                            }
                        }
                    }
                }

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

                    if (n != dst) {
                        for (Link link : n.getLinks()) {
                            if (link.getNode1() == val || link.getNode2() == val) {
                                link.getFib(0).consumeWavLen();
                                System.out.println(link.getName() + " consumed wavelengths = " + link.getFib(0).getConsumedWavLens());
                            }
                        }
                    }
                    curr = val;
                }
            }
        }
        Collections.reverse(tempPath);
        noOfLightPathsCreated++;
        System.out.print("Lightpath - ");
        for (Node n : tempPath) {
            System.out.print(n.getName() + " ");
        }
        System.out.println("\nLightpaths requested = " + noOfLightPathsReq + " Lightpaths created = " + noOfLightPathsCreated);
        System.out.println("\n");
    }
}
