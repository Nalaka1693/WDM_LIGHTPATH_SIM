public class Main {
    public static void main(String[] args) {
        IP_Router r1 = new IP_Router("ROU-1");
        IP_Router r2 = new IP_Router("ROU-2");

        IP_Router r3 = new IP_Router("ROU-3");
        IP_Router r4 = new IP_Router("ROU-4");

        IP_Router r5 = new IP_Router("ROU-5");
        IP_Router r6 = new IP_Router("ROU-6");

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

        Link l10 = new Link(r3, oxc2);
        Link l11 = new Link(r4, oxc5);

        Link l12 = new Link(r5, oxc6);
        Link l13 = new Link(r6, oxc4);

        System.out.println("\nLightpath");
        LightPath o1 = new LightPath(r1, r2);
        o1.findLightPath();

        System.out.println("\nLightpath");
        LightPath o2 = new LightPath(r3, r4);
        o2.findLightPath();

        System.out.println("\nLightpath");
        LightPath o3 = new LightPath(r5, r6);
        o3.findLightPath();

    }
}


