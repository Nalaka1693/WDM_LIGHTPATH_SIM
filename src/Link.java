public class Link {
    private String name;

    public Link(Node node1, Node node2) {
        this.name = node1.getName() + "-" + node2.getName();
        Fiber fib1 = new Fiber("fib-1", 0);
        Fiber fib2 = new Fiber("fib-2", 1);

        node1.addAdjacencyNode(node2);
        node2.addAdjacencyNode(node1);

        System.out.println(node1.getName() + " and " + node2.getName() + " are connected");
    }
}
