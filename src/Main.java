
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
        // The arraylist takes the ItemName, Catagory, Cost and Desc and compresses it
        // to
        // one string which then gets redistributed when viewed
        ArrayList<String> cartItems = new ArrayList<>();
        cartItems.add("Product^2478^Homemade PC^Item^1500^homemade pc I7-1500k, 4070ti, 1tb^U");
        ArrayList<String> categories = new ArrayList<String>();

        ArrayList<String> bookedSrve = new ArrayList<String>();

        // Listings
        ArrayList<String> listings = new ArrayList<>();
        // Presiquite
        listings.add("Product^2478^Homemade PC^Item^1500^homemade pc I7-1500k, 4070ti, 1tb");

        Scanner sc = new Scanner(System.in);

        // newestEntry is made to keep the newestKey/Entry pressed
        for (int newestEntry = 0; newestEntry < 98; newestEntry = Integer.parseInt(sc.nextLine())) {
            //
            // switch case to select different options
            // 0=MainMenu, 1=CartView, 2=AddService

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
                    System.out.println("[3] Browse market Services");
                    System.out.println("[4] Browse ordered Services");
                    System.out.println("[5] Exit");

                    break;
                case 1:
                    // Clear Terminal
                    System.out.print("\033[H1\033[2J");
                    System.out.flush();

                    System.out.println(String.format("\nCart:"));
                    if (cartItems.size() == 0) {
                        System.out.println(String.format("!: You have no items in cart :("));
                    } else {
                        boolean canCheckout = true;
                        // fortmat items in cart
                        for (String cartitem : cartItems) {
                            // Cart Decription!!!!!
                            int posNamount = 0;
                            String itemCartName = "";
                            String itemCartID = "";
                            String itemCartCat = "";
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
                                            break;
                                        case 1:
                                            itemCartID += cartitem.charAt(letterPOS);
                                            break;
                                        case 2:
                                            itemCartName += cartitem.charAt(letterPOS);
                                            break;
                                        case 3:
                                            itemCartCat += cartitem.charAt(letterPOS);
                                            break;
                                        case 4:
                                            itemCartCost += cartitem.charAt(letterPOS);
                                            break;
                                        case 5:
                                            itemCartDesc += cartitem.charAt(letterPOS);
                                            break;
                                        case 6:
                                            System.out.println(String.format(
                                                    "!:Err You have carted your own service, please remove it (ID: %s):!",
                                                    itemCartID));
                                            canCheckout = false;
                                            break;
                                    }

                                }

                            }
                            // Print out cart items
                            System.out.println(String.format("\n%s : %s | $%s\n%s\nID: %s", itemCartCat, itemCartName,
                                    itemCartCost, itemCartDesc, itemCartID));
                        }
                    }
                    // Follow up options
                    System.out.println("\n[0] Deselect");
                    System.out.println("[1] Checkout");
                    System.out.println("[2] Remove Item");
                    switch (Integer.parseInt(sc.nextLine())) {
                        case 0:
                            // Menu return options
                            System.out.println(String.format("\n[1] View cart (%s)", (cartItems.size())));
                            System.out.println("[2] Add service ");
                            System.out.println("[3] Browse market Services");
                            System.out.println("[4] Browse ordered Services");
                            System.out.println("[5] Exit");
                            break;
                        case 1:
                            System.out.print("\033[H1\033[2J");
                            System.out.flush();
                            System.out.println("All services BOOKED!\n");
                            cartItems.ad // Menu return options
                                    System
                            .out.println(String.format("\n[1] View cart (%s)", (cartItems.size())));
                            System.out.println("[2] Add service ");
                            System.out.println("[3] Browse market Services");
                            System.out.println("[4] Browse ordered Services");
                            System.out.println("[5] Exit");
                            break;

                    }
                    break;

                /// View Add Services
                case 2:
                    // Clear Terminal
                    System.out.print("\033[H1\033[2J");
                    System.out.flush();
                    // this is getting the name
                    System.out.println(
                            String.format("Add a listing:%n Do not input \"^\" character! it will be removed. "));
                    System.out.println("\n > Listing Name:");
                    String ServAddName = sc.nextLine().replace("^", "");

                    System.out.println("\n > Enter service catagory (it will create a new if it doesnt exist)");
                    String ServAddCat = sc.nextLine().replace("^", "");

                    System.out.println("\n > Description:");
                    String ServAddDesc = sc.nextLine().replace("^", "");

                    System.out.println("\n > Price? (you can do \"prHr\" or adjust it to your needs!");
                    String ServAddPrice = sc.nextLine();
                    // Add an ID to listing
                    int listingADDID = (int) (Math.random() * 9999) + 1111;
                    // check if ID is already in use (chances of it being 2x is very low)
                    if (listings.contains(listingADDID)) {
                        listingADDID = (int) (Math.random() * 9999) + 1111;
                    }
                    // Add listing and print result!
                    listings.add(String.format("%s^%s^%s^%s^%s^U", listingADDID, ServAddName, ServAddCat,
                            ServAddPrice, ServAddDesc));
                    System.out.println(String.format("Listing \"%s\" was created! (ID:%s)", ServAddName, listingADDID));

                    break;
                case 3:

                    break;

            }
        }

    }

}
