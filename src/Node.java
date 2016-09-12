import java.util.ArrayList;
import java.util.List;

public class Node {
    public static ArrayList<Node> nodes = new ArrayList<>();

    private String name;
    private List<Node> adjacencyNodes = new ArrayList<>();
    private ArrayList<Link> listOfLinks = new ArrayList<>();
    private OXC oxc;
    private IP_Router ip_router;

    public Node(String name) {
        this.name = name;
        oxc = new OXC("OXC-" + name);
        oxc = new OXC("ROU-" + name);
        nodes.add(this);
    }

    public String getName() {
        return this.name;
    }

    public void addAdjacencyNode(Node node) {
        this.adjacencyNodes.add(node);
    }

    public List<Node> getConnectedNodes() {
        return this.adjacencyNodes;
    }

    public void printNeighbors() {
        for (Node n : this.adjacencyNodes) {
            System.out.print(n.getName() + " ");
        }

        System.out.println();
    }

    public void addLink(Link link) {
        this.listOfLinks.add(link);
    }

    public ArrayList<Link> getLinks() {
        return this.listOfLinks;
    }
}
