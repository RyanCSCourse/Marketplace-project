
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
        ArrayList<String> categories = new ArrayList<String>();

        ArrayList<String> bookedSrve = new ArrayList<String>();

        // Listings
        ArrayList<String> listings = new ArrayList<>();
        // Presiquite
        listings.add("School^9021^Homework^Dirty work^50^Il do your lab work, no chemistry, cash only!!");
        listings.add("Electronics^2839^Build a pc^Item^230 + parts^Building pc's for your needs!");
        listings.add("Vehicles^4521^2019 Honda Civic SI^Item^24000^Well kept, modded injectors + clean title!");
        listings.add("DoItForMe^2381^Exterminator^Service^0.10perInsect^I kill insects, no cleanup sandle only");
        // Variable Tracks if the user is still "in" the app
        boolean notExited = true;
        String currentlyViewingCat = "All";
        Scanner sc = new Scanner(System.in);

        ///
        /// SHOP CODE
        ///
        // newestEntry is made to keep the newestKey/Entry pressed
        for (int newestEntry = 0; newestEntry < 98; newestEntry = Integer.parseInt(sc.nextLine())) {
            //
            // switch case to select different options
            // 0=MainMenu, 1=CartView, 2=AddService, 3=Browse market services, 4=Browse ordered service, 5=Exit
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
                                    System.out.println("All selected services have been BOOKED!");
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

                        System.out.println("\n > Enter type of service (Item or Service)");
                        String ServType = sc.nextLine();

                        System.out.println("\n > Description:");
                        String ServAddDesc = sc.nextLine().replace("^", "");

                        System.out.println("\n > Price? (you can do \"prHr\" or do not use \"$\"");
                        String ServAddPrice = sc.nextLine().replaceAll("$", "");
                        // Add an ID to listing
                        int listingADDID = (int) (Math.random() * 9999) + 1111;
                        // check if ID is already in use (chances of it being 2x is very low)
                        if (listings.contains(listingADDID)) {
                            listingADDID = (int) (Math.random() * 9999) + 1111;
                        }
                        System.out.print("\033[H1\033[2J");
                        System.out.flush();
                        // Add listing and print result!
                        listings.add(String.format("%s^%s^%s^%s^%s^%s^U", ServAddCat, listingADDID, ServAddName, ServType, ServAddPrice, ServAddDesc,
                                ServAddPrice, ServAddDesc));
                        System.out.println(String.format("Listing \"%s\" was created! (ID:%s)", ServAddName, listingADDID));
                        System.out.println(String.format("\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",(cartItems.size()), (bookedSrve.size())));

                        break;
                    case 3:
                        // Re clear terminal
                        System.out.print("\033[H1\033[2J");
                        System.out.flush();
                        // Print *LISTINGS!!!*
                        boolean itemsPrinted = false;
                        System.out.println(String.format("C O M M U N I T Y   M A R K E T\n\nTracking %s listings | Currently browsing *%s*\n\n[1] Add item to cart (by ID)\n[2] Sort by catagory\n[0] Return to Main Menu\n______________________________________________", listings.size(), currentlyViewingCat));
                        for (String listingSelect : listings) {
                            // printStuffBeforehand
                            int posNamount = 0;
                            String listingItemCat = "";
                            String listingItemCost = "";
                            String listingItemName = "";
                            String listingItemID = "";
                            String listingItemDesc = "";
                            String listingItemType = "";
                            boolean isSelflisting = false;
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
                                            isSelflisting = true;
                                            break;
                                    }
                                }
                            }
                            // update items printed
                            // if statement is for catagories!

                            if (currentlyViewingCat.toLowerCase().equals(listingItemCat.toLowerCase()) || currentlyViewingCat.toLowerCase().equals("all")) {
                             if (!isSelflisting) {
                                System.out.println(String.format("\n| %s : %s : $%s\n| %s\n| ID:%s : Catagory: %s", listingItemName, listingItemType ,listingItemCost, listingItemDesc, listingItemID, listingItemCat));
                             } else if (isSelflisting) {
                                System.out.println(String.format("\n| %s : %s : $%s\n| %s\n| ID:%s : Catagory: %s : This is your listing!", listingItemName, listingItemType ,listingItemCost, listingItemDesc, listingItemID, listingItemCat));
                             }
                             itemsPrinted = true;
                            } else if (isSelflisting && currentlyViewingCat.toLowerCase().equals("mine")) {
                                System.out.println(String.format("\n| %s : %s : $%s\n| %s\n| ID:%s : Catagory: %s : This is your listing!", listingItemName, listingItemType ,listingItemCost, listingItemDesc, listingItemID, listingItemCat));
                                itemsPrinted = true;
                            }
                        }
                        if (!itemsPrinted) {
                           System.err.println("\nErr: Unable to find Items that fit catagory, are you sure its spelt correctly?");
                        }
                        // FollowUps
                        switch (Integer.parseInt(sc.nextLine())) {
                            case 1:
                                // Add to cart!
                                System.out.print("\033[H1\033[2J");
                                System.out.flush();
                                System.err.println("Adding Item to cart!\n\nID of Item:");
                                String itemTobeAdded = sc.nextLine();
                                boolean iteminCart = false;
                            for (String cartSelect : cartItems) {
                                if (cartSelect.contains(itemTobeAdded)) {
                                    iteminCart = true;
                                }
                            }
                            if (!iteminCart) {
                                    boolean itemAddedtocart = false;
                                    for (String listingSelect:listings) {
                                        if (listingSelect.contains(itemTobeAdded)) {
                                            cartItems.add(listingSelect);
                                            System.out.print("\033[H1\033[2J");
                                            System.out.flush();
                                             System.err.println("Item Added to Cart!!!");
                                            System.out.println(String.format(
                                        "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                        (cartItems.size()), (bookedSrve.size())));
                                        itemAddedtocart = true;
                                        }
                                    }
                                    if (!itemAddedtocart) {
                                            System.out.print("\033[H1\033[2J");
                                            System.out.flush();
                                             System.err.println("Errr: Unable to add Item are you sure it exits?");
                                            System.out.println(String.format(
                                        "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                        (cartItems.size()), (bookedSrve.size())));
                                        }
                                } else {
                                    System.out.print("\033[H1\033[2J");
                                    System.out.flush();
                                    System.err.println("Err: Cannot add Item that is already in cart!");
                                    // Invalid Info
                                    System.out.println(String.format(
                                        "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                        (cartItems.size()), (bookedSrve.size())));
                                }
                            
                            break;
                            case 2:
                                System.out.print("\033[H1\033[2J");
                                System.out.flush();
                                ArrayList<String> avaiableCats = new ArrayList<>();
                                // Get catagories
                                for (String selecListing:listings) {
                                    String storeCat = "";
                                    for (int charSelect = 0; (selecListing.charAt(charSelect) != '^') ; charSelect++) {
                                        storeCat += selecListing.charAt(charSelect);
                                    }
                                    // Avoid Dupes
                                    if (!avaiableCats.contains(storeCat)) {
                                            avaiableCats.add(storeCat);
                                    }
                                }
                                // Take Catagory
                                System.out.println("Sort by Catagory:");
                                System.out.println(String.format("\nDefualts: All, Mine\nCommunity: %s", avaiableCats));
                                System.out.println("Type the catagory you want:");
                                currentlyViewingCat = sc.nextLine();
                                System.out.print("\033[H1\033[2J");
                                System.out.flush();
                                System.out.println("Listings Sorted! return to browser see changes!");
                                System.out.println(String.format(
                                        "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                        (cartItems.size()), (bookedSrve.size())));

                            break;
                            case 0: 
                                // Re clear terminal
                                System.out.print("\033[H1\033[2J");
                                System.out.flush();
                                System.out.println(String.format("\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",(cartItems.size()), (bookedSrve.size())));
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
                    case 4:
                        System.out.print("\033[H1\033[2J");
                        System.out.flush();
                      System.out.println(String.format("These are your Ordered services:\n\n[1] Cancel an Order\n[2] Return to Main Menu"));
                        for (String bookedE : bookedSrve) {
                                int posNamount = 0;
                                String bookedItemCost = "";
                                String bookedItemName = "";
                                String bookedItemID = "";
                            for (int letterPOS = 0; letterPOS < bookedE.length(); letterPOS++){
                                if (bookedE.charAt(letterPOS) == '^') {
                                    posNamount += 1;
                                } else {
                                    // Organize values to variables
                                    switch (posNamount) {
                                        case 1:
                                            bookedItemID += bookedE.charAt(letterPOS);
                                            break;
                                        case 2:
                                            bookedItemName += bookedE.charAt(letterPOS);
                                            break;
                                        case 4:
                                            bookedItemCost += bookedE.charAt(letterPOS);
                                            break;
                                    }
                                }
                            }
                             System.out.println(String.format("\n%s : Paid $%s\nID:%s", bookedItemName, bookedItemCost, bookedItemID));
                        }
                        switch (Integer.parseInt(sc.nextLine())) {
                            case 1:
                              System.out.print("\033[H1\033[2J");
                              System.out.flush();
                              System.out.println("Type ID of item you wish to remove:");
                                String removID = sc.nextLine();
                                boolean anItemRemov = false;
                                for (int arrySelec = 0; arrySelec < bookedSrve.size(); arrySelec++) {
                                    if (bookedSrve.get(arrySelec).contains(removID)) {
                                        bookedSrve.remove(arrySelec);
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
                            case 2:
                            System.out.println(String.format(
                                        "\n[1] View cart (%s)\n[2] Add Listing\n[3] Browse market Services\n[4] Browse ordered Services (%s)\n[5] Exit",
                                        (cartItems.size()), (bookedSrve.size())));
                            break;
                        }

                        break;

                    case 5:
                        notExited = false;
                        System.out.print("\033[H1\033[2J");
                        System.out.flush();
                        System.out.println("Thanks for using Marketplacey\n You can now exit the program!");
                        break;
                        

                }

            }

                }
            }

        }
