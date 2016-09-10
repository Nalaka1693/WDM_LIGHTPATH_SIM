public class Link {
    private String name;

    public Link(OXC oxc1, OXC oxc2) {
        this.name = oxc1.getName() + "-" + oxc2.getName();
        Fiber fib1 = new Fiber(0);
        Fiber fib2 = new Fiber(1);

        oxc1.addAdjacencyNode(oxc2);
        oxc2.addAdjacencyNode(oxc1);

        System.out.println(oxc1.getName() + " and " + oxc2.getName() + " are connected");
    }

    public Link(OXC oxc1, IP_Router rout) {
        this.name = oxc1.getName() + "-" + rout.getName();
        Fiber fib1 = new Fiber(0);
        Fiber fib2 = new Fiber(1);

        oxc1.addAdjacencyNode(rout);
        rout.addAdjacencyNode(oxc1);

        System.out.println(oxc1.getName() + " and " + rout.getName() + " are connected");
    }

    public Link(IP_Router rout, OXC oxc1) {
        this.name = rout.getName() + "-" + oxc1.getName();
        Fiber fib1 = new Fiber(0);
        Fiber fib2 = new Fiber(1);

        rout.addAdjacencyNode(oxc1);
        oxc1.addAdjacencyNode(rout);

        System.out.println(rout.getName() + " and " + oxc1.getName() + " are connected");
    }
}
