import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int myCard1 = drawRandomCard();
        int myCard2 = drawRandomCard();
        int myCardTotal = myCard1 + myCard2;
        System.out.println("You get a \n" + cardString(myCard1) 
        + "\n and a \n" + cardString(myCard2));
        System.out.println("Your total is: " + myCardTotal);
        scan.nextLine();

        if (myCardTotal > 21) {
            System.out.println("\nBust! You lose!");
            System.exit(0);
        }

        int compCard1 = drawRandomCard();
        int compCard2 = drawRandomCard();
        int compCardTotal = compCard1 + compCard2;
        System.out.println("\nThe dealer shows \n" + cardString(compCard1) 
        + "\nand has a card facing down \n" + faceDown());
        System.out.println("The dealer's total is hidden");

        while (true) {
            String hitOrStay = hitOrStay();
            if (hitOrStay.equals("hit")) {
                int newCard = drawRandomCard();
                myCardTotal += newCard;
                System.out.println("\nYou get a ");
                System.out.println(cardString(newCard));
                System.out.println("Your new total is " + myCardTotal);
                scan.nextLine();

                if (myCardTotal > 21) {
                    System.out.println("Bust! You lose!");
                    System.exit(0);
                }

            } else if (hitOrStay.equals("stay")) {
                break;
            }
        }

        System.out.println("\nDealer's turn...");
        scan.nextLine();
        System.out.println("The dealer's cards are \n" 
        + cardString(compCard1) + "\n and a \n" + cardString(compCard2));
        System.out.println("Dealer's total is " + compCardTotal);
        scan.nextLine();

        while (compCardTotal <= 17) {
            int newCard = drawRandomCard();
            compCardTotal += newCard;
            System.out.println("\nDealer draws a new card: ");
            System.out.println(cardString(newCard));
            System.out.println("Dealer's new total is " + compCardTotal);
            scan.nextLine();

            if (compCardTotal > 21) {
                System.out.println("Bust! Dealer loses!");
                System.exit(0);
            }
        }

        System.out.println("Player's total: " + myCardTotal);
        System.out.println("Dealer's total: " + compCardTotal);

        if (myCardTotal > compCardTotal) {
            System.out.println("\nPlayer wins!");
        } else if (compCardTotal > myCardTotal){
            System.out.println("\nDealer wins!");
        } else {
            System.out.println("\nIt's a tie!");
        }

        scan.close();
    }

    public static int drawRandomCard() {
        return (int)(Math.random() * 13 + 1);
    }

    public static String hitOrStay() {
        System.out.print("\nDo you want to hit or stay? ");
        String option = scan.nextLine();

        while (!(option.equals("hit") || option.equals("stay"))) {
            System.out.println("Please write 'hit' or 'stay'");
            option = scan.nextLine();
        }

        return option;
    }

    public static String cardString(int num) {
        switch (num) {
            case 1: return                    
                "   _____ \n"+
                "  |A _  |\n"+ 
                "  | ( ) |\n"+
                "  |(_'_)|\n"+
                "  |  |  |\n"+
                "  |____V|\n";

            case 2: return
                "   _____\n"+              
                "  |2    |\n"+ 
                "  |  o  |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____Z|\n";

            case 3: return
                "   _____\n" +
                "  |3    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____E|\n";

            case 4: return
                "   _____\n" +
                "  |4    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  | o o |\n"+
                "  |____h|\n";

            case 5: return
                "   _____ \n" +
                "  |5    |\n" +
                "  | o o |\n" +
                "  |  o  |\n" +
                "  | o o |\n" +
                "  |____S|\n";

            case 6: return
                "   _____ \n" +
                "  |6    |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  |____6|\n";

            case 7: return
                "   _____ \n" +
                "  |7    |\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |____7|\n";

            case 8: return
                "   _____ \n" +
                "  |8    |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  |____8|\n";

            case 9: return
                "   _____ \n" +
                "  |9    |\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |____9|\n";

            case 10: return
                "   _____ \n" +
                "  |10  o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |___10|\n"; 

            case 11: return
                "   _____\n" +
                "  |J  ww|\n"+ 
                "  | o {)|\n"+ 
                "  |o o% |\n"+ 
                "  | | % |\n"+ 
                "  |__%%[|\n";

            case 12: return
                "   _____\n" +
                "  |Q  ww|\n"+ 
                "  | o {(|\n"+ 
                "  |o o%%|\n"+ 
                "  | |%%%|\n"+ 
                "  |_%%%O|\n";

            case 13: return
                "   _____\n" +
                "  |K  WW|\n"+ 
                "  | o {)|\n"+ 
                "  |o o%%|\n"+ 
                "  | |%%%|\n"+ 
                "  |_%%%>|\n";

            default: return "";
        }
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
}

