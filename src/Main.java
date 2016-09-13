import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeMath.round;

public class Main {
    public static void main(String[] args) {
        String input;

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

        IP_Router r1 = new IP_Router("ROU-1");  new Link(r1, oxc1);
        IP_Router r2 = new IP_Router("ROU-2");  new Link(r2, oxc2);
        IP_Router r3 = new IP_Router("ROU-3");  new Link(r3, oxc3);
        IP_Router r4 = new IP_Router("ROU-4");  new Link(r4, oxc4);
        IP_Router r5 = new IP_Router("ROU-5");  new Link(r5, oxc5);
        IP_Router r6 = new IP_Router("ROU-6");  new Link(r6, oxc6);

        System.out.print("Find lightpath automatically (yes/no): ");
        Scanner userIn = new Scanner(System.in);
        input = userIn.nextLine();

        if (input.equalsIgnoreCase("yes")) {
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
        } else if (input.equalsIgnoreCase("no")) {
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

                new LightPath(IP_Router.routers.get(var1 - 1), IP_Router.routers.get(var2 - 1)).findCustomLightPath();
            }
        } else {
            System.out.println("Only enter 'yes' or 'no'");
        }

        System.out.print("Percentage of the number of lightpaths blocked = " +
                (LightPath.noOfLightPathsReq - LightPath.noOfLightPathsCreated) / (double) LightPath.noOfLightPathsReq * 100 + "%");

//        new LightPath(r1, r3).findLightPath();
//        new LightPath(r1, r4).findLightPath();
//        new LightPath(r2, r5).findLightPath();
//        new LightPath(r6, r3).findLightPath();
//        new LightPath(r2, r4).findLightPath();
//        new LightPath(r1, r3).findLightPath();
//        new LightPath(r1, r5).findLightPath();


    }
}


