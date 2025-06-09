
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //
        // Marketplace Project
        // By Rayan & Koorosh
        //

        // initial variables
        // Arraylist holds the cart items
        ArrayList<String> cartItems = new ArrayList<>();
        ArrayList<Integer> cartCosts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // newestEntry is made to keep the newestKey/Entry pressed
        for (int newestEntry = 0; newestEntry < 98; newestEntry = sc.nextInt()) {
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
                        System.out.println(String.format("!: \tYou have no items in cat :("));
                    }


                    break;

            }

        }

    }

}
