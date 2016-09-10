public class Main {
    public static void main(String[] args) {
        IP_Router r1 = new IP_Router("ROUT-1");
        IP_Router r2 = new IP_Router("ROUT-2");

        OXC oxc1 = new OXC("OXC-1");
        OXC oxc2 = new OXC("OXC-2");
        OXC oxc3 = new OXC("OXC-3");
        OXC oxc4 = new OXC("OXC-4");
        OXC oxc5 = new OXC("OXC-5");
        OXC oxc6 = new OXC("OXC-6");

        Link l1 = new Link(oxc1, oxc2);
        Link l2 = new Link(oxc2, oxc3);
        Link l3 = new Link(oxc3, oxc4);
        Link l4 = new Link(oxc4, oxc5);
        Link l5 = new Link(oxc5, oxc1);
        Link l6 = new Link(oxc1, oxc6);
        Link l7 = new Link(oxc6, oxc3);

        Link l8 = new Link(r1, oxc1);
        Link l9 = new Link(r2, oxc3);

        oxc1.printNeighbors();
        oxc3.printNeighbors();

    }
}
