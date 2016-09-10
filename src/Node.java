import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Node> adjacencyNodes = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public Link getLinks() {
        return new Link(new Node("n1"), new Node("n2"));
    }

}
