
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
        // Variable Tracks if the user is still "in" the app
        boolean notExited = true;
        Scanner sc = new Scanner(System.in);

        ///
        /// SHOP CODE
        ///
        // newestEntry is made to keep the newestKey/Entry pressed
        for (int newestEntry = 0; newestEntry < 98; newestEntry = Integer.parseInt(sc.nextLine())) {
            //
            // switch case to select different options
            // 0=MainMenu, 1=CartView, 2=AddService, 3=Browse market services,
            if (notExited) {
                switch (newestEntry) {
                    //
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

                        System.out.println(String.format(
                                "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                (cartItems.size()), (bookedSrve.size())));

                        break;
                    case 1:
                        // Clear Terminal
                        System.out.print("\033[H1\033[2J");
                        System.out.flush();
                        boolean canCheckout = true;
                        System.out.println(String.format("\nCart:"));
                        if (cartItems.size() == 0) {
                            System.out.println(String.format("!: You have no items in cart :("));
                        } else {
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
                                System.out
                                        .println(String.format("\n%s : %s | $%s\n%s\nID: %s", itemCartCat, itemCartName,
                                                itemCartCost, itemCartDesc, itemCartID));
                            }
                        }
                        // Follow up options
                        System.out.println("\n[0] Go to Main Menu");
                        System.out.println("[1] Checkout");
                        System.out.println("[2] Remove Item");
                        switch (Integer.parseInt(sc.nextLine())) {
                            case 0:
                                System.out.print("\033[H1\033[2J");
                                System.out.flush();
                                // Menu return options
                                System.out.println(String.format(
                                        "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                        (cartItems.size()), (bookedSrve.size())));
                                break;
                            case 1:
                                System.out.print("\033[H1\033[2J");
                                System.out.flush();
                                if (canCheckout && (cartItems.size() != 0)) {
                                    // if its finee
                                    System.out.println("All selected services have been BOOKED!\n[2] Add service\n");
                                    bookedSrve.addAll(cartItems);
                                    cartItems.clear();
                                } else if (!canCheckout) {
                                    // if it has an issue item
                                    System.out.println(
                                            "Err: unable to checkout, please return to your cart and remove any issues");
                                } else {
                                    // if cart is empty
                                    System.out.println("Err: unable to checkout, your cart is empty!");
                                }
                                System.out.println(String.format(
                                        "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                        (cartItems.size()), (bookedSrve.size())));
                                break;
                            case 2:
                                System.out.println("Currently removing an Item type in its ID:");
                                String removID = sc.nextLine();
                                boolean anItemRemov = false;
                                for (int arrySelec = 0; arrySelec < cartItems.size(); arrySelec++) {
                                    if (cartItems.get(arrySelec).contains(removID)) {
                                        cartItems.remove(arrySelec);
                                        // clear!
                                        System.out.print("\033[H1\033[2J");
                                        System.out.flush();
                                        anItemRemov = true;
                                        System.out.println(String.format("\nItem %s successfully removed!", removID));
                                    }
                                }
                                if (!anItemRemov) {
                                    System.out.print("\033[H1\033[2J");
                                    System.out.flush();
                                    System.out.print(
                                            "Err: Failed to find Item, Are you sure you typed the correct ID?\n");
                                }
                                System.out.println(String.format(
                                        "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                        (cartItems.size()), (bookedSrve.size())));
                                break;
                            default:
                                // invalid input
                                System.out.print("\033[H1\033[2J");
                                System.out.flush();
                                System.err.println("Err: Invalid input please try again.\n");
                                System.out.println(String.format(
                                        "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                        (cartItems.size()), (bookedSrve.size())));
                                break;
                        }
                        break;
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

                        System.out.println("\n > Price? (you can do \"prHr\" or do not use \"$\"");
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
                        System.out.println(
                                String.format("Listing \"%s\" was created! (ID:%s)", ServAddName, listingADDID));

                        break;
                    case 3:
                        // Re clear terminal
                        System.out.print("\033[H1\033[2J");
                        System.out.flush();
                        // Variables Sorted + Temp
                        String currentlyViewingCat = "All";
                        int page = 0;
                        int currentItemTrack = listings.size() - 1;
                        // Print *LISTINGS!!!*
                        for (String listingSelect : listings) {
                            // listingSlelect5
                            int posNamount = 0;
                            String listingItemCat = "";
                            String listingItemCost = "";
                            String listingItemName = "";
                            String listingItemID = "";
                            String listingItemDesc = "";
                            String listingItemType = "";
                            for (int letterPOS = 0; letterPOS < listingSelect.length(); letterPOS++){
                                if (listingSelect.charAt(letterPOS) == '^') {
                                    posNamount += 1;
                                } else {
                                    // Organize values to variables
                                    switch (posNamount) {
                                        case 0:
                                            listingItemCat += listingSelect.charAt(letterPOS);
                                            break;
                                        case 1:
                                            listingItemID += listingSelect.charAt(letterPOS);
                                            break;
                                        case 2:
                                            listingItemName += listingSelect.charAt(letterPOS);
                                            break;
                                        case 3:
                                            listingItemType += listingSelect.charAt(letterPOS);
                                            break;
                                        case 4:
                                            listingItemCost += listingSelect.charAt(letterPOS);
                                            break;
                                        case 5:
                                            listingItemDesc += listingSelect.charAt(letterPOS);
                                            break;
                                        case 6:
                                            break;
                                    }
                                }
                            }
                            // update items printed
                             currentItemTrack++;
                             System.out.println(String.format("%s\nID:%s\nName:%s\nCat:%s\nType:%s\nCost:%s\nDesc%s", (currentItemTrack), listingItemID, listingItemName, listingItemCat, listingItemType, listingItemCost, listingItemDesc));   
                        }
                        break;
                    case 4:
                        for (String listingSelect : listings) {
                            int posNamount = 0;
                            String listingItemCat = "";
                            String listingItemCost = "";
                            String listingItemName = "";
                            String listingItemID = "";
                            String listingItemDesc = "";
                            String listingItemType = "";
                            for (int letterPOS = 0; letterPOS < listingSelect.length(); letterPOS++){
                                if (listingSelect.charAt(letterPOS) == '^') {
                                    posNamount += 1;
                                } else {
                                    // Organize values to variables
                                    switch (posNamount) {
                                        case 0:
                                            listingItemCat += listingSelect.charAt(letterPOS);
                                            break;
                                        case 1:
                                            listingItemID += listingSelect.charAt(letterPOS);
                                            break;
                                        case 2:
                                            listingItemName += listingSelect.charAt(letterPOS);
                                            break;
                                        case 3:
                                            listingItemType += listingSelect.charAt(letterPOS);
                                            break;
                                        case 4:
                                            listingItemCost += listingSelect.charAt(letterPOS);
                                            break;
                                        case 5:
                                            listingItemDesc += listingSelect.charAt(letterPOS);
                                            break;
                                        case 6:
                                            break;
                                    }
                                }
                            }
                             System.out.println(String.format("ID:%s\nName:%s\nCat:%s\nType:%s\nCost:%s\nDesc%s", listingItemID, listingItemName, listingItemCat, listingItemType, listingItemCost, listingItemDesc));   
                        }
                        break;

                    case 5:
                        notExited = false;
                        break;
                    


                }

            } else {
                // Exit code here!!!
                System.out.println("Thanks for using Marketplacey\n Bye!!");
            }

                }
            }

        }
