import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input; boolean flag1 = true;

        /* Initializing core WDM network using OXCs */
        OXC oxc1 = new OXC("OXC-1");
        OXC oxc2 = new OXC("OXC-2");
        OXC oxc3 = new OXC("OXC-3");
        OXC oxc4 = new OXC("OXC-4");
        OXC oxc5 = new OXC("OXC-5");
        OXC oxc6 = new OXC("OXC-6");

        /* Connect OXCs to setup core network */
        new Link(oxc1, oxc2);
        new Link(oxc2, oxc3);
        new Link(oxc3, oxc4);
        new Link(oxc4, oxc5);
        new Link(oxc5, oxc1);
        new Link(oxc1, oxc6);
        new Link(oxc6, oxc3);

        /* Initialize IP routers and connect each one to corresponding OXC */
        IP_Router r1 = new IP_Router("ROU-1");  new Link(r1, oxc1);
        IP_Router r2 = new IP_Router("ROU-2");  new Link(r2, oxc2);
        IP_Router r3 = new IP_Router("ROU-3");  new Link(r3, oxc3);
        IP_Router r4 = new IP_Router("ROU-4");  new Link(r4, oxc4);
        IP_Router r5 = new IP_Router("ROU-5");  new Link(r5, oxc5);
        IP_Router r6 = new IP_Router("ROU-6");  new Link(r6, oxc6);

        System.out.print("Find lightpath automatically (y/n): ");
        Scanner userIn = new Scanner(System.in);
        input = userIn.nextLine();

        if (input.equalsIgnoreCase("y")) {
            while (true) {
                int var1, var2;

                System.out.print("\nList of connected routers: ");
                for (IP_Router r : IP_Router.routers) {
                    System.out.print( r.getName() + " ");
                } System.out.println();

                System.out.print("Enter source router       (1, 2, 3, ... 0 to exit): ");
                var1 = userIn.nextInt();
                if (var1 == 0) { break; }

                System.out.print("Enter destination router  (1, 2, 3, ... 0 to exit): ");
                var2 = userIn.nextInt();
                if (var2 == 0) { break; }

                new LightPath(IP_Router.routers.get(var1 - 1), IP_Router.routers.get(var2 - 1)).findLightPath();
            }
        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("\nLightpath finding is manual give desired next node at\neach node source and destination should be IP routers\n0 to exit, -1 to find next lightpath.");
            while (true) {
                int var1, var2, waveLen;
                Node src = null;
                boolean flag2 = true; Node n2 = null;
                Map<Node, Node> map = new HashMap<>();

                while (true) {
                    ArrayList<Node> connectedNodes = new ArrayList<>();


                    if (flag2) {
                        System.out.print("\nList of connected routers: ");
                        for (IP_Router r : IP_Router.routers) {
                            System.out.print( r.getName() + " ");
                        } System.out.println();

                        System.out.print("\nEnter source router (1, 2, 3, ... 0 to exit): ");
                        flag2 = false;
                        var1 = userIn.nextInt();
                        if (var1 == -1) { break; } else if (var1 == 0) { flag1 = false; break; }
                        src = IP_Router.routers.get(var1 - 1);
                        System.out.print(IP_Router.routers.get(var1 - 1).getName() + " is selected, ");

                        System.out.print("connected nodes -> ");
                        for (Node n : IP_Router.routers.get(var1 - 1).getConnectedNodes()) {
                            System.out.print(n.getName() + " ");
                            connectedNodes.add(n);
                        } System.out.println();

                        System.out.print("\nEnter next node     (1, 2, 3, ... 0 to exit): ");
                        var2 = userIn.nextInt();
                        if (var2 == -1) { break; } else if (var2 == 0) { flag1 = false; break; }

                        n2 = connectedNodes.get(var2 - 1);
                        System.out.print(n2.getName() + " is selected, ");
                        map.put(n2, IP_Router.routers.get(var1 - 1));
                    }

                    connectedNodes.clear();

                    System.out.print("connected nodes -> ");
                    for (Node n : n2.getConnectedNodes()) {
                        System.out.print(n.getName() + " ");
                        connectedNodes.add(n);
                    } System.out.println();

                    System.out.print("\nEnter next node     (1, 2, 3, ... 0 to exit): ");
                    var2 = userIn.nextInt();
                    if (var2 == -1) { break; } else if (var2 == 0) { flag1 = false; break; }
                    System.out.println(connectedNodes.get(var2 - 1).getName() + " is selected, ");

                    map.put(connectedNodes.get(var2 - 1), n2);

                    n2 = connectedNodes.get(var2 - 1);

                    if (IP_Router.routers.contains(n2)) {
                        new LightPath(src, n2).findCustomLightPath(map);
                        break;
                    }
                }

                if (!flag1) { break; }
            }
        } else {
            System.out.println("Only enter 'yes' or 'no'");
        }

        System.out.print("Percentage of the number of lightpaths blocked = " +
                (LightPath.noOfLightPathsReq - LightPath.noOfLightPathsCreated) / (double) LightPath.noOfLightPathsReq * 100 + "%");
    }
}


