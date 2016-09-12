public class Main {
    public static void main(String[] args) {
        OXC oxc1 = new OXC("OXC-1");
        OXC oxc2 = new OXC("OXC-2");
        OXC oxc3 = new OXC("OXC-3");
        OXC oxc4 = new OXC("OXC-4");
        OXC oxc5 = new OXC("OXC-5");
        OXC oxc6 = new OXC("OXC-6");

        new Link(oxc1, oxc2);
        new Link(oxc2, oxc3);
        new Link(oxc3, oxc4);
        new Link(oxc4, oxc5);
        new Link(oxc5, oxc1);
        new Link(oxc1, oxc6);
        new Link(oxc6, oxc3);
        System.out.println();

        IP_Router r1 = new IP_Router("ROU-1");
        IP_Router r2 = new IP_Router("ROU-2");
        new Link(r1, oxc1);
        new Link(r2, oxc3);
        new LightPath(r1, r2).findLightPath();

        IP_Router r3 = new IP_Router("ROU-3");
        IP_Router r4 = new IP_Router("ROU-4");
        new Link(r3, oxc2);
        new Link(r4, oxc5);
        new LightPath(r3, r4).findLightPath();


        IP_Router r5 = new IP_Router("ROU-5");
        IP_Router r6 = new IP_Router("ROU-6");
        new Link(r5, oxc6);
        new Link(r6, oxc4);
        new LightPath(r5, r6).findLightPath();

        IP_Router r7 = new IP_Router("ROU-7");
        IP_Router r8 = new IP_Router("ROU-8");
        new Link(r7, oxc1);
        new Link(r8, oxc2);
        new LightPath(r7, r8).findLightPath();

        IP_Router r9 = new IP_Router("ROU-9");
        IP_Router r10 = new IP_Router("ROU-10");
        new Link(r9, oxc1);
        new Link(r10, oxc3);
        new LightPath(r9, r10).findLightPath();

        IP_Router r11 = new IP_Router("ROU-11");
        IP_Router r12 = new IP_Router("ROU-12");
        new Link(r9, oxc1);
        new Link(r10, oxc3);
        new LightPath(r9, r10).findLightPath();
    }
}


