
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //
        // Marketplace Project
        // By Rayan & Koorosh
        //

        // initial variables
        // Arraylist holds the cart items and their properties
        // The arraylist takes the ItemName, Type, Cost and Desc and compresses it to
        // one string which then gets redistributed when viewed
        ArrayList<String> cartItems = new ArrayList<>();
        cartItems.add("Homemade PC^Item^1500^homemade pc I7-1500k, 4070ti, 1tb");

        // Listings
        ArrayList<String> listings = new ArrayList<>();
        // Presiquite
        listings.add("Homemade PC^Item^1500^homemade pc I7-1500k, 4070ti, 1tb");

        Scanner sc = new Scanner(System.in);

        // newestEntry is made to keep the newestKey/Entry pressed
        for (int newestEntry = 0; newestEntry < 98; newestEntry = Integer.parseInt(sc.nextLine())) {
            //
            // switch case to select different options
            // 0=Defualt

            switch (newestEntry) {
                // Print Main Menu
                case 0:
                    System.out.println("\r\n"
                            + //
                            "    __  __  __            _        _         _                       __  \r\n"
                            + //
                            "   / / |  \\/  |          | |      | |       | |                      \\ \\ \r\n"
                            + //
                            "  | |  | \\  / | __ _ _ __| | _____| |_ _ __ | | __ _  ___ ___ _   _   | |\r\n"
                            + //
                            "  | |  | |\\/| |/ _` | '__| |/ / _ \\ __| '_ \\| |/ _` |/ __/ _ \\ | | |  | |\r\n"
                            + //
                            "  | |  | |  | | (_| | |  |   <  __/ |_| |_) | | (_| | (_|  __/ |_| |  | |\r\n"
                            + //
                            "  | |  |_|  |_|\\__,_|_|  |_|\\_\\___|\\__| .__/|_|\\__,_|\\___\\___|\\__, |  | |\r\n"
                            + //
                            "   \\_\\                                | |                      __/ | /_/ \r\n"
                            + //
                            "                                      |_|                     |___/      \r\n"
                            + //
                            "");

                    System.out.println(String.format("\n[1] View cart (%s)", (cartItems.size())));
                    System.out.println("[2] Add service ");
                    System.out.println("[3] Exist ");

                    break;
                // Cart View
                case 1:
                    System.out.println(String.format("\nCart:"));
                    if (cartItems.size() == 0) {
                        System.out.println(String.format("!: You have no items in cart :("));
                    } else {
                        // fortmat items in cart
                        for (String cartitem : cartItems) {
                            // Cart Decription!!!!!
                            int posNamount = 0;
                            String itemCartName = "";
                            String itemCarttype = "";
                            String itemCartCost = "";
                            String itemCartDesc = "";
                            for (int letterPOS = 0; letterPOS < cartitem.length(); letterPOS++) {
                                // Make Name
                                if (cartitem.charAt(letterPOS) == '^') {
                                    posNamount += 1;
                                } else {
                                    // Organize values to variables
                                    switch (posNamount) {
                                        case 0:
                                            itemCartName += cartitem.charAt(letterPOS);
                                            break;
                                        case 1:
                                            itemCarttype += cartitem.charAt(letterPOS);
                                            break;
                                        case 2:
                                            itemCartCost += cartitem.charAt(letterPOS);
                                            break;
                                        case 3:
                                            itemCartDesc += cartitem.charAt(letterPOS);
                                            break;
                                    }
                                }

                            }
                            System.out.println(itemCartCost);
                            System.out.println(itemCarttype);
                            System.out.println(itemCartName);
                            System.out.println(itemCartDesc);

                        }
                    }
                    break;

                /// View Add Services
                case 2:
                    // this is getting the name
                    System.out.println("what is the product/services name?\n");
                    String ServAddName = sc.nextLine();
                    
                    System.out.println("what type of service are you offering (product or service)\n");
                    String ServAddType = sc.nextLine();

                    System.out.println("add a description ");
                    String ServAddDesc = sc.nextLine();

                    System.out.println("What is the price");
                    int ServAddPrice = sc.nextInt();
                    listings.add(String.format("%s^%s^%s^%s", ServAddName, ServAddType, ServAddPrice, ServAddDesc));
                    cartItems.add(String.format("%s^%s^%s^%s", ServAddName, ServAddType, ServAddPrice, ServAddDesc));
                    break;
            }

        }

    }

}
